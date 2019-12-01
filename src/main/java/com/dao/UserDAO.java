package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.pojo.request.UserReqDTO;
import com.pojo.response.UserResDTO;

@Repository
public interface UserDAO {

	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	@Select({ "select * from `user` as u where u.user_name = #{userName}" })
	@Results(value = { @Result(property = "Id", column = "id"), @Result(property = "userName", column = "user_name"),
			@Result(property = "pwd", column = "pwd"), @Result(property = "userStatus", column = "user_status"), })
	UserResDTO selectUserInfo(String userName);
	
	/**
	 * 列表查询
	 * @return
	 */
	@Select({ "select * from `user` as u" })
	@Results(value = { @Result(property = "Id", column = "id"), @Result(property = "userName", column = "user_name"),
			@Result(property = "pwd", column = "pwd"), @Result(property = "userStatus", column = "user_status"), })
	List<UserResDTO> selectByPageCondition();
	
	/**
	 * 添加
	 * @param reqDTO
	 * @return
	 */
	@Insert("insert into `user` (user_name,pwd) values(#{userName},#{pwd})")
	@Options(useGeneratedKeys=true, keyProperty="Id", keyColumn="id")
	int add(UserReqDTO reqDTO);
	
	/**
	 * 修改
	 * @param reqDTO
	 * @return
	 */
	@Update("update `user` set user_name = #{userName},pwd=#{pwd} where id = #{Id}")
	int update(UserReqDTO reqDTO);
	
	/**
	 * 删除
	 * @param reqDTO
	 * @return
	 */
	@Delete("delete from `user` where id = #{Id}")
	int delete(UserReqDTO reqDTO);
	
}
