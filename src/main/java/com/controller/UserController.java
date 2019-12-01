package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.request.PageRequest;
import com.pojo.request.UserReqDTO;
import com.pojo.response.UserResDTO;
import com.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/getUserInfo")
	public UserResDTO getUserInfo(@RequestBody UserReqDTO reqDTO) {

		System.out.println("reqDTO:" + reqDTO);

		UserResDTO user = userService.getUserInfo(reqDTO);

		return user;
	}

	@PostMapping("/getUserListInfo")
	public PageInfo<UserResDTO> getUserListInfo(@RequestBody PageRequest reqDTO) {

		System.out.println("pageReqDTO:" + reqDTO.getPageNum() + "||" + reqDTO.getPageSize());
		return userService.selectUserListInfoByPage(reqDTO);

	}

	@PostMapping("/addUserInfo")
	public String addUserInfo(@RequestBody UserReqDTO reqDTO) {

		Integer isAdd = userService.addUserInfo(reqDTO);
		
		int succFlag = 1;
		
		if (isAdd == succFlag) {

			return "success";
		} else {
			return "fail";
		}
	}

	@PostMapping("/updateUserInfo")
	public String updateUserInfo(@RequestBody UserReqDTO reqDTO) {

		Integer isUpdate = userService.updateUserInfo(reqDTO);
		int succFlag = 1;
		if (isUpdate == succFlag) {
			return "success";

		} else {
			return "fail";

		}
	}

	@PostMapping("/deleteUserInfo")
	public String deleteUserInfo(@RequestBody UserReqDTO reqDTO) {

		Integer isUpdate = userService.deleteUserInfo(reqDTO);

		int succFlag = 1;
		
		if (isUpdate == succFlag) {
			return "success";

		} else {
			return "fail";

		}
	}
}
