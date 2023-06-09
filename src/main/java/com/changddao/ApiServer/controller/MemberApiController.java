package com.changddao.ApiServer.controller;

import com.changddao.ApiServer.entity.Info;
import com.changddao.ApiServer.entity.Member;
import com.changddao.ApiServer.service.MemberService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;


    @PostMapping("/api/v1/members")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member ,BindingResult result) {
        if(result.hasErrors())
            return new CreateMemberResponse(result.toString());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PostMapping("/api/v2/members")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }
    @PutMapping("/api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(@PathVariable("id") Long id,
                                               @Valid @RequestBody UpdateMemberRequest request) {
        memberService.update(id, request.getName());
        Member findMember = memberService.findMember(id);
        return new UpdateMemberResponse(findMember.getId(), findMember.getUsername());
    }
    @GetMapping("/api/v2/members")
    public Result findAllMemberV2() {
        List<Member> members = memberService.findMembers();
        List<MemberDto> result = members.stream().map(o -> new MemberDto(o.getUsername()))
                .collect(Collectors.toList());
        return new Result(result.size(), result);
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse{
        private Long id;
        private String updatedName;

    }
    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String name;
    }
    @Data
    static class UpdateMemberRequest{
        private String name;
    }
    @Data
    static class CreateMemberRequest{
        private String name;
    }
    @Data
    static class CreateMemberResponse{
        private Long id;
        private String errorMsg;

        public CreateMemberResponse(Long id) {
            this.id = id;
        }

        public CreateMemberResponse(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private int count;
        private T data;
    }
}
