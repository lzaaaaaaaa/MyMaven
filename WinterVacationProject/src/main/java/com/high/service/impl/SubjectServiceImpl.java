package com.high.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.high.dao.SubjectDao;
import com.high.entity.Subject;
import com.high.service.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectServiceImpl extends ServiceImpl<SubjectDao, Subject> implements SubjectService {
}
