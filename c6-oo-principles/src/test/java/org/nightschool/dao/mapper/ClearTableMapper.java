package org.nightschool.dao.mapper;

import org.apache.ibatis.annotations.Delete;

public interface ClearTableMapper {

    @Delete("delete from databasechangelog where 1 =1 ")
    int clearChangeLog();

    @Delete("delete from databasechangeloglock where 1 =1 ")
    int clearChangelogLock();

    @Delete("drop table item")
    int clearItem();

    @Delete("drop sequence item_id_seq")
    int clearItemSequence();
}
