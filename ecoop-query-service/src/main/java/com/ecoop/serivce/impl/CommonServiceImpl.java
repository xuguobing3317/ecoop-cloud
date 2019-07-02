package com.ecoop.serivce.impl;

import com.ecoop.repository.pid.ProfitRecordRepository;
import com.ecoop.repository.user.RoleUserRepository;
import com.ecoop.serivce.CommonSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @ClassName CommonServiceImpl
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 20:02
 * @Version 1.0
 **/
@Service
public class CommonServiceImpl implements CommonSerivce {


    @Autowired
    private ProfitRecordRepository profitRecordRepository;


    @Autowired
    private RoleUserRepository roleUserRepository;

    @Override
    public long getProfitRecordCount() {
        return profitRecordRepository.countByTnWalletId(22L);
    }

    @Override
    public long getRoleUserCount() {
        return roleUserRepository.countByUserId(1L);
    }

    @Override
    public long getProfileRecordTotal() {
        return profitRecordRepository.countTotal();
    }

    @Override
    public List<Map<String, Object>> getProfitList() {
        return profitRecordRepository.querySomeRecord();
    }


}
