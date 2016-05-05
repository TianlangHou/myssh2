package cn.fudan.edu.myssh2.controller;

import cn.fudan.edu.myssh2.bean.Message;
import cn.fudan.edu.myssh2.dao.MessageDao;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * Created by Sissors-CX on 2016-04-07.
 */

@Controller
@RequestMapping(value = "/message.do")
public class MessageController {

    @RequestMapping(params = "method=send")
    @ResponseBody
    public String receive(@RequestBody String request) throws JSONException {
        JSONObject requestJson = new JSONObject(request);
        Message message = new Message();
        message.setSource(0);
        message.setContent(requestJson.get("content").toString());
        message.setTime(new Timestamp(System.currentTimeMillis()));
        MessageDao.add(message);
        JSONObject response = new JSONObject();
        response.put("status", "success");
        return response.toString();
    }
}
