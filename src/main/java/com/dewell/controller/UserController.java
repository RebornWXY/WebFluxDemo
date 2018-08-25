package com.dewell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dewell.entity.User;
import com.dewell.repository.UserRepository;

/**
 * @author Reborn.Wang
 * @createDate 创建时间：2018年8月24日 下午4:07:28
 * @Description 类描述: {@link User}} 对象的访问层
 */
@RestController
public class UserController {

	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/person/save")
	public User save(User user) {
		if(userRepository.save(user)) {
			System.out.printf("用户对象：% 保存成功！\n",user);
		}
		return user;
	}

}
