package com.high.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.high.entity.Vote;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VoteService extends IService<Vote> {
    List<Map<String, Object>> votelist(@Param("sid") Integer sid);

    List<Map<String, Object>> selectlike(@Param("title") String title);
}
