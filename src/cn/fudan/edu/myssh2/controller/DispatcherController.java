package cn.fudan.edu.myssh2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sissors-CX on 2016-04-07.
 */
@Controller
@RequestMapping(value = "/")
public class DispatcherController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:user.do?method=index";
    }
}
