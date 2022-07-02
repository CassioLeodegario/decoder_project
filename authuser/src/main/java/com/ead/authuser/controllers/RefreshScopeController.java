package com.ead.authuser.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class RefreshScopeController {

    @Value("${authuser.refreshscope.name}")
    private String name;

    @RequestMapping("/refreshscope")
    String refreshscope(){
        return this.name;
    }

}
