package com.bilitech.api.core.controller;

import com.bilitech.api.core.dto.UserCreateRequest;
import com.bilitech.api.core.dto.UserSearchFilter;
import com.bilitech.api.core.dto.UserUpdateRequest;
import com.bilitech.api.core.mapper.UserMapper;
import com.bilitech.api.core.service.UserService;
import com.bilitech.api.core.vo.PageVo;
import com.bilitech.api.core.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    UserService userService;

    UserMapper userMapper;

    @GetMapping
    PageVo<UserVo> search(@Validated UserSearchFilter userSearchFilter) {
        return new PageVo<>(userService.search(userSearchFilter).map(userMapper::toVo));
    }

    @PostMapping
    UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
        return userMapper.toVo(userService.create(userCreateRequest));
    }

    @GetMapping("/{id}")
    UserVo get(@PathVariable String id) {
        return userMapper.toVo(userService.get(id));
    }

    @PutMapping("/{id}")
    UserVo update(@PathVariable String id,
                  @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
        return userMapper.toVo(userService.update(id, userUpdateRequest));
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id) {
        userService.delete(id);
    }

    @GetMapping("/me")
    UserVo me() {
        return userMapper.toVo(userService.getCurrentUser());
    }


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
