package com.gt.wms.Dao.impl;

import com.gt.wms.Dao.SysCodeDao;
import com.gt.wms.Entity.SysCode;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rio on 2019/3/25.
 */
@Repository
public class SysCodeDaoImpl implements SysCodeDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<SysCode> getSysCodeList(SysCode sysCode) {
        return sqlSession.selectList("getSysCodeList", sysCode);
    }
}
