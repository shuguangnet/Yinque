package com.example.demo.mapper;

import com.example.demo.entity.News;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {
    @Select("select  * from  news")
    List<News> findAll();
}
