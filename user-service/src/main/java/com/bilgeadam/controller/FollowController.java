package com.bilgeadam.controller;

import com.bilgeadam.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import  static  com.bilgeadam.constant.ApiUrls.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(FOLLOW)
public class FollowController {

    private final FollowService followService;


    public ResponseEntity<?> createFollow(){


    }


}
