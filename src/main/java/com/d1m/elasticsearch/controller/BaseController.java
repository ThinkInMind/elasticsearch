package com.d1m.elasticsearch.controller;

import com.alibaba.fastjson.JSONObject;
import com.d1m.elasticsearch.domain.enums.EstoreCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static sun.awt.geom.Crossings.debug;

public class BaseController {
    //默认 memberId 以及 wechatId
    private Long memberId = 151L;
    private Integer wechatId = 32;

    private Logger log = LoggerFactory.getLogger(BaseController.class);

    protected JSONObject representation(EstoreCodeEnum msg) {
        JSONObject json = new JSONObject();
        json.put("resultCode", msg.getCode().toString());
        json.put("msg", msg.name());
        return json;
    }

    protected JSONObject representation(EstoreCodeEnum msg, Object data) {
        JSONObject json = new JSONObject();
        json.put("resultCode", msg.getCode().toString());
        json.put("msg", msg.name());
        json.put("data", data);
        return json;
    }

    protected JSONObject representation(EstoreCodeEnum msg, Object data,
                                        Integer pageSize, Integer pageNum, long count) {
        JSONObject json = new JSONObject();
        json.put("resultCode", msg.getCode().toString());
        json.put("msg", msg.name());
        JSONObject subJson = new JSONObject();
        subJson.put("result", data);
        subJson.put("pageSize", pageSize);
        subJson.put("pageNum", pageNum);
        subJson.put("count", count < 0 ? 0 : count);
        json.put("data", subJson);
        return json;
    }

    protected JSONObject wrapException(Exception e) {
        JSONObject json = new JSONObject();
        String errEnum = "";
        if (e.getMessage() != null) {
            errEnum = e.getMessage().split(":")[0];
        }
        EstoreCodeEnum codeEnum = EstoreCodeEnum.getCodeByDesc(errEnum);
        if (codeEnum != null) {
            Integer resultCode = codeEnum.getCode();
            String msg = e.getMessage();
            json.put("resultCode", resultCode.toString());
            json.put("msg", msg);
            log.error("[" + resultCode + "]" + msg, e.getMessage());
        } else {
            json.put("resultCode", EstoreCodeEnum.SYSTEM_ERROR.getCode());
            json.put("msg", EstoreCodeEnum.SYSTEM_ERROR.getDesc());
            log.error("[system error]:" + e.getMessage());

        }
        return json;
    }


}
