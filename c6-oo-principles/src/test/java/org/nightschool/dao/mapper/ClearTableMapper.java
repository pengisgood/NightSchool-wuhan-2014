package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Delete;

public interface ClearTableMapper {

    @Delete("delete from databasechangelog where 1 =1 ")
    int clearChangeLog();

    @Delete("delete from databasechangeloglock where 1 =1 ")
    int clearChangeLogLock();

    @Delete("drop table item")
    int dropItem();

    @Delete("drop sequence item_id_seq")
    int dropItemSequence();

    @Delete("drop table cart_item")
    int dropCartItem();
}
