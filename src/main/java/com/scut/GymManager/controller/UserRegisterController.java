package com.scut.GymManager.controller;

import com.scut.GymManager.dto.RegisterRequest;
import com.scut.GymManager.dto.SuccessResponse;
import com.scut.GymManager.exception.UserRegisterException;
import com.scut.GymManager.service.UserBasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * create by YellowBroke on 2020年5月31日 22点26分
 */

@Api(value = "用户信息接口", tags = "用户信息接口")
@RestController
@Slf4j
@RequestMapping(value = "/api/user")
public class UserRegisterController {

    @Resource
    private UserBasicService userBasicService;

    @ApiOperation("用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<SuccessResponse> register(RegisterRequest registerRequest) {

        try {
            userBasicService.userRegister(registerRequest);
            log.info("用户 {} 注册成功",registerRequest.getUsername());
            return ResponseEntity.ok(new SuccessResponse(true, "注册成功"));
        } catch (UserRegisterException e) {
            return ResponseEntity.ok(new SuccessResponse(false, e.getMessage()));
        }
    }
}