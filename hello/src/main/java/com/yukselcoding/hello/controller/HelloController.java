package com.yukselcoding.hello.controller;


import com.yukselcoding.hello.exception.NameNotProvidedException;
import com.yukselcoding.hello.request.HelloRequest;
import com.yukselcoding.hello.response.HelloResponse;
import com.yukselcoding.hello.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Log4j2(topic = "controller")
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello/{name}")
    private ResponseEntity<HelloResponse> hello(@PathVariable String name) throws NameNotProvidedException {
        log.info(String.format("GET request with name: %s", name));
        return new ResponseEntity<>(helloService.hello(name), HttpStatus.OK);
    }

    @PostMapping("/hello")
    private ResponseEntity<HelloResponse> hello(@RequestBody HelloRequest request) throws NameNotProvidedException {
        log.info(String.format("POST request with name: %s", request.getName()));
        return new ResponseEntity<>(helloService.hello(request.getName()), HttpStatus.OK);
    }
}
