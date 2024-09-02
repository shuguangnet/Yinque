package com.example.demo.mapper;

import com.example.demo.entity.Forums;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ForumsMapper {
    @Select("select * from forum ")
    List<Forums> findAll();
}
