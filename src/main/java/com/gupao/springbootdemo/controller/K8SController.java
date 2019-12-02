package com.gupao.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@RestController
public class K8SController {

    String result="";

    @RequestMapping("/k8s")
    public String k8s(){
        try {
            //用 getLocalHost() 方法创建的InetAddress的对象
            InetAddress address = InetAddress.getLocalHost();
            result="hostname: "+address.getHostName()+"hostaddress: "+address.getHostAddress();
            System.out.println();//主机名
            System.out.println();//主机别名
            System.out.println();//
        }catch(Exception e){
            e.printStackTrace();
        }
        return "hello K8s <br/> "+result;
    }
}
