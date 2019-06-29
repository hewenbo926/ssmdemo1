package com.itheima.mapper;

import com.itheima.domain.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    /**
     * 添加类表信息
     * @param student
     */
    @Insert("insert into t_student values(#{id},#{name},#{sex},#{age},#{address})")
    public void save (Student student);

    /**
     * 查询列表信息
     * @return
     */
    @Select("select * from t_student")
    public List <Student> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    @Select("select * from t_student where id=#{id}")
    public Student findOne(Integer id);

    /**
     * 修改列表信息
     * @param student
     */

    @Update("update t_student set name=#{name},sex=#{sex},age=#{age},address=#{address} where id=#{id}")
    public void update(Student student);

    /**
     * 删除功能
     * @param ids
     */

   // public void del(Integer[] ids);
    public void del(List ids);
}
