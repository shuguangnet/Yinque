package com.example.demo.mapper;

import com.example.demo.entity.Videos;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VideosMapper {
    @Select("select  * from  videos")
    List<Videos> findAll();
}
