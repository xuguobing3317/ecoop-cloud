package com.ecoop.serivce;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CommonSerivce
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 20:00
 * @Version 1.0
 **/
public interface CommonSerivce {


    long getProfitRecordCount();

    long getRoleUserCount();

    long getProfileRecordTotal();

    List<Map<String, Object>> getProfitList();


}
