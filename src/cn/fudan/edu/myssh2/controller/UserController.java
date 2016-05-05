package cn.fudan.edu.myssh2.controller;

import cn.fudan.edu.myssh2.bean.User;
import cn.fudan.edu.myssh2.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.UnsupportedEncodingException;

/**
 * Created by Sissors-CX on 2016-04-03.
 */
@Controller
@RequestMapping(value = "/user.do")
public class UserController {

    @RequestMapping(params = "method=index")
    public String index() {
        return "/user/index";
    }

    @RequestMapping(params = "method=register")
    public String register(String name, String password) throws UnsupportedEncodingException {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setType(1);
        UserDao.add(user);
        return "redirect:/user.do?method=index";
    }
}
