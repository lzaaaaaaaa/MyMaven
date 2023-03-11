package com.high.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.high.dao.OptionsDao;
import com.high.entity.Options;
import com.high.service.OptionsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OptionsServiceImpl extends ServiceImpl<OptionsDao, Options> implements OptionsService {
}
