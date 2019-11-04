package top.zzliup.hikar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.zzliup.hikar.dao.StudentDao;

import javax.annotation.Resource;

/**
 * @author: Liupan on 2019-10-25 16:26
 */
@Controller
public class StudentController {

    @Resource
    private StudentDao studentDao;

    @RequestMapping("findAll")
    @ResponseBody
    public String findAll(){
        return studentDao.findAll().toString();
    }
}
