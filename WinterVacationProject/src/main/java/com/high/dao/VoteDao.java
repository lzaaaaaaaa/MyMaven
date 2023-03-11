package com.high.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.high.entity.Vote;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VoteDao extends BaseMapper<Vote> {
    //主页
    List<Map<String, Object>> votelist(@Param("sid") Integer sid);

    List<Map<String, Object>> selectlike(@Param("title") String title);
}
