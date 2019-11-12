package com.ambereye.controller;

import com.ambereye.entity.Student;
import com.ambereye.feign.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * TODO
 *
 * @author ambereye
 * @date 2019/11/12
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {
    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        return feignProviderClient.findAll();
    }
    @GetMapping("/index")
    public String index() {
        return feignProviderClient.index();
    }
}
