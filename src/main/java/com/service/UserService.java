package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.User;
import com.pojo.request.PageRequest;
import com.pojo.request.UserReqDTO;
import com.pojo.response.UserResDTO;

public interface UserService {

    
    UserResDTO getUserInfo(UserReqDTO reqDTO);
    
    PageInfo<UserResDTO> selectUserListInfoByPage(PageRequest reqDTP); 
    
    int addUserInfo(UserReqDTO reqDTO);
    
    int updateUserInfo(UserReqDTO reqDTO);
    
    int deleteUserInfo(UserReqDTO reqDTO);
}
