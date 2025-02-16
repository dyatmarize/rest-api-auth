package com.dyatmarize.restauth.controller;

import com.dyatmarize.restauth.api.request.LoginRequest;
import com.dyatmarize.restauth.api.request.RegisterRequest;
import com.dyatmarize.restauth.api.response.BaseResponse;
import com.dyatmarize.restauth.service.UserService;
import com.dyatmarize.restauth.util.Prefix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(Prefix.API)
public class AppController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String testEndpoint() {
        return "Initialize Success";
    }

    // User Controller
    @PostMapping(Prefix.USER + "/register")
    public BaseResponse registerUser(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping(Prefix.USER + "/login")
    public BaseResponse doLogin(@RequestBody LoginRequest request) {
        return userService.doLogin(request);
    }

    // Blog Post Controller
    @PostMapping(Prefix.POSTS)
    public BaseResponse createPost() {
        return BaseResponse.builder()
                .withSuccess(true)
                .withData("Create Post")
                .build();
    }

    @GetMapping(Prefix.POSTS)
    public BaseResponse getAllPosts() {
        return BaseResponse.builder()
                .withSuccess(true)
                .withData("Get All Posts")
                .build();
    }

    @GetMapping(Prefix.POSTS + "/{id}")
    public BaseResponse getPostDetails(@PathVariable Long id) {
        return BaseResponse.builder()
                .withSuccess(true)
                .withData("Get Post With Id : " + id)
                .build();
    }

    @PutMapping(Prefix.POSTS + "/{id}")
    public BaseResponse updatePost(@PathVariable Long id) {
        return BaseResponse.builder()
                .withSuccess(true)
                .withData("Update Post With Id : " + id)
                .build();
    }

    @DeleteMapping(Prefix.POSTS + "/{id}")
    public BaseResponse deletePost(@PathVariable Long id) {
        return BaseResponse.builder()
                .withSuccess(true)
                .withData("Delete Post With Id : " + id)
                .build();
    }

    // Comment Controller
    @PostMapping(Prefix.POSTS + "/{id}" + Prefix.COMMENTS)
    public BaseResponse postComment(@PathVariable Long id) {
        return BaseResponse.builder()
                .withSuccess(true)
                .withData("Post Comment To Post : " + id)
                .build();
    }

    @GetMapping(Prefix.POSTS + "/{id}" + Prefix.COMMENTS)
    public BaseResponse getPostComment(@PathVariable Long id) {
        return BaseResponse.builder()
                .withSuccess(true)
                .withData("Get Comment From Post : " + id)
                .build();
    }
}
