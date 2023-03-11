package com.high.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.high.dao.VoteDao;
import com.high.entity.Vote;
import com.high.service.VoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class VoteServiceImpl extends ServiceImpl<VoteDao, Vote> implements VoteService {
    @Override
    public List<Map<String, Object>> votelist(Integer sid) {
        return super.baseMapper.votelist(sid);
    }

    @Override
    public List<Map<String, Object>> selectlike(String title) {
        return super.baseMapper.selectlike("%" + title + "%");
    }
}
