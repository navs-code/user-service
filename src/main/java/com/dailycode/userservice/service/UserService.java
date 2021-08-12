package com.dailycode.userservice.service;

import com.dailycode.userservice.VO.Department;
import com.dailycode.userservice.VO.ResponseTemplateVO;
import com.dailycode.userservice.controller.UserController;
import com.dailycode.userservice.entity.User;
import com.dailycode.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    //Logger log = LoggerFactory.getLogger(UserService.class);

    public User saveUser(User user) {
        log.info("In save user of User Service");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("In get User with department of User repository");
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
