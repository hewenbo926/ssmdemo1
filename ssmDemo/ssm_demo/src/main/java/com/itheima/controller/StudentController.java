package com.itheima.controller;

import com.itheima.domain.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 查询列表信息
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = studentService.list();
        //设置模型
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("list");
        return modelAndView;
    }

    /**
     * 添加列表信息
     * @param student
     * @return
     */
    @RequestMapping("/save")
    public String save(Student student){
        studentService.save(student);
        return "redirect:/student/list";
    }

    /**
     * 查询单个信息
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public String findOne(Integer id, Model model){
        Student student = studentService.findOne(id);
        model.addAttribute("student",student);
        return "update";
    }

    /**
     * 修改功能
     * @param student
     */
    @RequestMapping("/update")
    public String update(Student student){
        studentService.update(student);
        return "redirect:/student/list";
    }

    /**
     * 删除功能
     * @param ids
     * @return/
     */
    @RequestMapping("/del")
    public String del(Integer[] ids){
        System.out.println(Arrays.toString(ids));
        studentService.del(ids);
        return "redirect:/student/list";
    }

}
