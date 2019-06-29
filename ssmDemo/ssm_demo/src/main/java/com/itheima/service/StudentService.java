package com.itheima.service;

import com.itheima.domain.Student;

import java.util.List;

public interface StudentService {

    //添加类表信息
    public void save(Student student);

    //查询列表信息
    public List<Student> list();

    //查询一个
    public Student findOne(Integer id);

    //修改类表信息
    public void update(Student student);

    //删除列表信息
    public void del(Integer[] ids);
}

