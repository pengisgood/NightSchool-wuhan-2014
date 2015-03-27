package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Delete;

public interface ClearTableMapper {

    @Delete("delete from databasechangelog")
    int clearChangeLog();

    @Delete("delete from databasechangeloglock")
    int clearChangeLogLock();

    @Delete("drop table item")
    int dropItem();

    @Delete("drop table cart_item")
    int dropCartItem();
}
