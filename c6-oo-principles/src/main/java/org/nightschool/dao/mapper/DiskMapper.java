package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nightschool.model.Disk;

import java.util.List;

public interface DiskMapper
{
    @Select("Select * from item")
    public List<Disk> getDisks();

    @Insert("insert into item(name, category, imgurl, description, price, count) values( #{name}, #{category}, #{imgurl}, #{description}, #{price}, #{count})")
    public int add(Disk disk);

    @Select("Select * from item where name = #{name}")
    public Disk getByName(@Param("name") String name);

    @Select("Select * from item where id = #{id}")
    public Disk getById(@Param("id") int id);
}
