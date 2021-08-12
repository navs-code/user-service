package com.dailycode.userservice.controller;

import com.dailycode.userservice.VO.ResponseTemplateVO;
import com.dailycode.userservice.entity.User;
import com.dailycode.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * File Info {@link }.
 *
 * <b><pre>
 * //==========================================================================
 * //
 * //       Copyright 2020-2020, Blue Yonder Group, Inc.
 * //                   All Rights Reserved
 * //
 * //       THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
 * //                   BLUE YONDER GROUP, INC.
 * //
 * //       The copyright notice above does not evidence any actual
 * //                   or intended publication of such source code.
 * //
 * //===========================================================================
 * </pre></b>
 *
 * @author Naveen Palankar
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    //Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("In save user of User Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Long userId) {
        log.info("In get user with department of User Controller");
        return userService.getUserWithDepartment(userId);
    }
}
