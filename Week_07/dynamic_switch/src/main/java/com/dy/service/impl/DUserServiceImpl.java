package com.dy.service.impl;

import com.dy.mapper.DUserMapper;
import com.dy.pojo.DUser;
import com.dy.service.DUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public class DUserServiceImpl implements DUserService {

    @Autowired
    private DUserMapper dUserMapper;


    @Override
    public void save() {
        DUser dUser =new DUser();
        dUser.setId( 1L );
        dUser.setName( "测试" );
        dUserMapper.insert( dUser );
    }

    @Override
    public DUser selectByPrimaryKey(Long id) {
        DUser dUser = dUserMapper.selectByPrimaryKey( 1L );
        return dUser;
    }
}
