package com.high.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.high.entity.Options;
import com.high.entity.Subject;
import com.high.entity.Users;
import com.high.entity.Vote;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@Repository
public interface UsersDao extends BaseMapper<Users> {
    //登录
//    Users login(Users users);
//
//    //注册
//    int insert(Users users);
//
//    //查用户重
//    Users exists(@Param("uname") String uname);
//
//    //主页
//    List<Map<String, Object>> votelist(@Param("sid") Integer sid);
//
//    //投票页面
//    List<Options> selectOptions(@Param("o_sid") Integer o_sid);
//
//    //投票
//    int insertVote(@Param("v_uid") Integer v_uid, @Param("v_sid") Integer v_sid, @Param("v_oid") Integer v_oid);
//
//    //添加投票
//    int addvote(@Param("title") String title, @Param("stype") Integer stype);
//
//    int max();
//
//    int addOptions(@Param("context") String context, @Param("o_sid") Integer o_sid);
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
