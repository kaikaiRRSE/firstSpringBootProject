package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/stu")
public class StuController {
    /**
     * 分页查询学生
     * @return
     */
    @RequestMapping(value = "/stuList")
    @ResponseBody
    public String demo(){
        return "Hello World";
    }
}
