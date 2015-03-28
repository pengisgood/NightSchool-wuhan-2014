package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.nightschool.model.Disk;

public interface ForTestsMapper {

    String CONFIG_PATH = "mybatis/testConfig.xml";

    @Delete("delete from databasechangelog")
    int clearChangeLog();

    @Delete("delete from databasechangeloglock")
    int clearChangeLogLock();

    @Delete("delete from item")
    int clearItem();

    @Delete("drop table item")
    int dropItem();

    @Delete("drop table cart_item")
    int dropCartItem();

    @Insert("insert into item(name, category, imgurl, description, price, count) values( #{name}, #{category}, #{imgurl}, #{description}, #{price}, #{count})")
    public int addDisk(Disk disk);
}
