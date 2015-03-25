package org.nightschool.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.nightschool.model.Disk;

import java.util.List;

public interface DiskMapper
{
    @Select("Select * from item")
    public List<Disk> getDisks();

    @Insert("insert into item(id, name, imgUrl, description, price, count) values('100', #{name}, #{imgUrl}, #{desc}, #{price}, #{number})")
    public int insert(Disk disk);
}
