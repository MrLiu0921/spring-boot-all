package top.zzliup.testjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzliup.testjpa.repository.StudentRepository;

import javax.annotation.Resource;

/**
 * @author: Liupan on 2019-10-25 17:21
 */
@Controller
public class StudentController {

    @Resource
    private StudentRepository studentRepository;

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll() {
        return  studentRepository.findAll().toString();
    }
}
