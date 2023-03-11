package com.high.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.high.dao.UsersDao;
import com.high.entity.Options;
import com.high.entity.Users;
import com.high.entity.Vote;
import com.high.service.UsersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UsersServiceImpl extends ServiceImpl<UsersDao,Users> implements UsersService {
//    @Resource
//    private UsersDao usersDao;

//    @Override
//    public Users login(Users users) {
//        return usersDao.login(users);
//    }
//
//    @Override
//    public int insert(Users users) {
//        return usersDao.insert(users);
//    }
//
//    @Override
//    public Users exists(String uname) {
//        return usersDao.exists(uname);
//    }
//
//    @Override
//    public List<Map<String, Object>> votelist(Integer sid) {
//        return usersDao.votelist(sid);
//    }
//
//    @Override
//    public List<Options> selectOptions(Integer o_sid) {
//        return usersDao.selectOptions(o_sid);
//    }
//
//    @Override
//    public int insertVote(Integer v_uid, Integer v_sid, Integer v_oid) {
//        return usersDao.insertVote(v_uid, v_sid, v_oid);
//    }
//
//    @Override
//    public int addvote(String title, Integer stype) {
//        return usersDao.addvote(title, stype);
//    }
//
//    @Override
//    public int max() {
//        return usersDao.max();
//    }
//
//    @Override
//    public int addOptions(String context, Integer o_sid) {
//        return usersDao.addOptions(context, o_sid);
//    }
//
//    @Override
//    public int deletevote(Integer v_sid) {
//        return usersDao.deletevote(v_sid);
//    }
//
//    @Override
//    public int deleteoptions(Integer o_sid) {
//        return usersDao.deleteoptions(o_sid);
//    }
//
//    @Override
//    public int deletesubject(Integer sid) {
//        return usersDao.deletesubject(sid);
//    }
//
//    @Override
//    public List<Map<String, Object>> selectlike(String title) {
//        return usersDao.selectlike("%" + title + "%");
//    }
//
//    @Override
//    public int updateStatus(String status, String uid) {
//        return usersDao.updateStatus(status, uid);
//    }

}
