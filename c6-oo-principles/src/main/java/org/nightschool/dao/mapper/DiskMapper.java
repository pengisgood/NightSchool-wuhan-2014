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

    @Insert("insert into item(name, imgurl, description, price, count, category) values( #{name}, #{imgurl}, #{description}, #{price}, #{count}, #{category})")
    public int add(Disk disk);

    @Select("Select * from item where id = #{id}")
    public int getById(@Param("id") int id);
}
