package com.junit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.UserDAO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.pojo.response.UserResDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-config.xml")
public class JunitTest {

	@Autowired
	private UserDAO userDao;

	@Test
	public void getUserInfo() throws Exception {

		UserResDTO user = userDao.selectUserInfo("youcong");

		System.out.println("userName:" + user.getUserName());

	}

	@Test
	public void testName() throws Exception {
		PageHelper.startPage(1, 10);
		List<UserResDTO> userVoList = userDao.selectByPageCondition();
		PageInfo pageInfo = new PageInfo(userVoList);
		System.out.println(pageInfo);

	}
}