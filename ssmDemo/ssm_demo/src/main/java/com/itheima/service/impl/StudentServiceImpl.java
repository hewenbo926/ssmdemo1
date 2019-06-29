package com.itheima.service.impl;

import com.itheima.domain.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 添加列表信息
     * @param student
     */
    @Override
    public void save(Student student) {

        studentMapper.save(student);
    }

    /**
     * 查询列表信息
     * @return
     */
    @Override
    public List<Student> list() {
        return studentMapper.findAll();
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @Override
    public Student findOne(Integer id) {
        return studentMapper.findOne(id);
    }

    /**
     * 修改列表信息
     * @param student
     */
    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    /**
     * 删除功能
     * @param ids
     */
    @Override
    public void del(Integer[] ids) {
        studentMapper.del(Arrays.asList(ids));

    }
}
