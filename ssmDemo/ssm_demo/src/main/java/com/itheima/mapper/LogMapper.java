package com.itheima.mapper;

import com.itheima.domain.Log;
import org.apache.ibatis.annotations.Insert;

public interface LogMapper {

    @Insert("insert into t_log values(#{id},#{name},#{time},#{url},#{cost})")
    void insert (Log log);
}
