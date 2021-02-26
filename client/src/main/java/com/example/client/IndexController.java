package com.example.client;

import com.example.client.wsdl.GetUserInfoResponse;
import com.example.client.wsdl.GetUserTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {


    @Autowired
    private TongluRemoteClient tongluRemoteClient;

    @GetMapping("")
    public String index(){
        GetUserInfoResponse country = tongluRemoteClient.getUserInfo();

        System.out.println(country);
        return country.getGetUserInfoResult();
    }
    @GetMapping("list")
    public String list(){
        GetUserTypeResponse country = tongluRemoteClient.getUserType();

        System.out.println(country);
        return country.getGetUserTypeResult();
    }
}
