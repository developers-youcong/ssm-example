package com.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.request.PageRequest;
import com.pojo.request.UserReqDTO;
import com.pojo.response.UserResDTO;
import com.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDao;

	@Override
	public UserResDTO getUserInfo(UserReqDTO reqDTO) {

		return userDao.selectUserInfo(reqDTO.getUserName());

	}

	@Override
	public PageInfo<UserResDTO> selectUserListInfoByPage(PageRequest reqDTO) {
		System.out.println("pageReqDTO:"+reqDTO.getPageNum()+"||"+reqDTO.getPageSize());
		PageHelper.startPage(reqDTO.getPageNum(), reqDTO.getPageSize());
		List<UserResDTO> userList = userDao.selectByPageCondition();
		PageInfo info = new PageInfo(userList);

		return info;

	}

	@Override
	public int addUserInfo(UserReqDTO reqDTO) {
		
		return userDao.add(reqDTO);
	}

	@Override
	public int updateUserInfo(UserReqDTO reqDTO) {
		
		return userDao.update(reqDTO);
	}

	@Override
	public int deleteUserInfo(UserReqDTO reqDTO) {
		
		return userDao.delete(reqDTO);
	}

}
