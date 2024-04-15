package com.atguigu.boot3.ssm.mapper;

import com.atguigu.boot3.ssm.bean.Tuser;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 1、每个方法都在Mapper文件中有一个sql标签对应
     * 2、所有参数都应该用@Param进行签名，以后使用指定的名字在sql中取值
     * @param id
     * @return
     */
    Tuser getUserById(@Param("id") Long id);
}
