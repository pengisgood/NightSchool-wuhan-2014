package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.nightschool.model.CartItem;
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

    @Select("select * from cart_item where itemid = #{itemid}")
    public CartItem getCartItemId(@Param("itemid") int itemid);

    @Delete("delete from cart_item")
    void clearCartItem();

}
