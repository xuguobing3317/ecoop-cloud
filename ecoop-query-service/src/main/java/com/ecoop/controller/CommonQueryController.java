package com.ecoop.controller;

import com.ecoop.annotation.Authenticate;
import com.ecoop.commons.R;
import com.ecoop.handler.WebSocketHandler;
import com.ecoop.serivce.CommonSerivce;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommonQueryController
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 19:58
 * @Version 1.0
 **/
@Controller
@Api
public class CommonQueryController {


    @Autowired
    private CommonSerivce commonSerivce;

    @Autowired
    private WebSocketHandler webSocketHandler;

    @ApiOperation(value="获取公共信息", notes="获取平台公共信息")
    @RequestMapping("/query")
    @ResponseBody
    @Authenticate(permissions="1,2,3")
    public R query() {
        long profitRecordCount = commonSerivce.getProfitRecordCount();
        long roleUserCount = commonSerivce.getRoleUserCount();
        long totalCount = commonSerivce.getProfileRecordTotal();
        List<Map<String, Object>> recordList = commonSerivce.getProfitList();

        Map map = new HashMap();
        map.put("profitRecordCount", profitRecordCount);
        map.put("roleUserCount", roleUserCount);
        map.put("totalCount", totalCount);
        map.put("recordList", recordList);

        R r = R.doSuccess();
        r.setData(map);
        return r;
    }

    @ApiOperation(value="获取公共信息", notes="获取平台公共信息")
    @RequestMapping("/msg")
    @ResponseBody
    public R query2() {
        try {
            webSocketHandler.sendMessage("Tony", "111");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.doSuccess();
    }


    @ApiOperation(value="权限", notes="权限")
    @RequestMapping("/auth")
    @ResponseBody
    @Authenticate(permissions = "auth")
    public R auth() {
        try {
            webSocketHandler.sendMessage("Tony", "111");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.doSuccess();
    }


}
