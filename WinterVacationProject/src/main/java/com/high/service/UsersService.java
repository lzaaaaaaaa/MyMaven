package com.high.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.high.entity.Options;
import com.high.entity.Users;
import com.high.entity.Vote;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UsersService extends IService<Users> {
//    Users login(Users users);
//
//    int insert(Users users);
//
//    Users exists(@Param("uname") String uname);
//
//    List<Map<String, Object>> votelist(Integer sid);
//
//    List<Options> selectOptions(@Param("o_sid") Integer o_sid);
//
//    int insertVote(@Param("v_uid") Integer v_uid, @Param("v_sid") Integer v_sid, @Param("v_oid") Integer v_oid);
//
//    int addvote(@Param("title") String title, @Param("stype") Integer stype);
//
//    int max();
//
//    int addOptions(@Param("context") String context, @Param("0_sid") Integer o_sid);
//
//    int deletevote(@Param("v_sid") Integer v_sid);
//
//    int deleteoptions(@Param("o_sid") Integer o_sid);
//
//    int deletesubject(@Param("sid") Integer sid);
//
//    List<Map<String, Object>> selectlike(@Param("title") String title);
//
//    int updateStatus(@Param("status") String status, @Param("uid") String uid);
}
