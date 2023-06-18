package com.changddao.ApiServer.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result <T>{
    public T data;
}
