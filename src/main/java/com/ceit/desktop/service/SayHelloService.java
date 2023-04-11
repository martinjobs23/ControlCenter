package com.ceit.desktop.service;

public class SayHelloService {

    public String Greet(String name){
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("，你好。\n");

        System.out.println(sb.toString());
        return sb.toString();
    }
}
