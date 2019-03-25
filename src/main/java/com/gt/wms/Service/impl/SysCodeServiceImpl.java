package com.gt.wms.Service.impl;

import com.gt.wms.Dao.SysCodeDao;
import com.gt.wms.Entity.SysCode;
import com.gt.wms.Service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rio on 2019/3/25.
 */
@Service
public class SysCodeServiceImpl implements SysCodeService {

    @Autowired
    private SysCodeDao sysCodeDao;

    @Override
    public List<SysCode> getSysCodeList(SysCode sysCode) {
        return sysCodeDao.getSysCodeList(sysCode);
    }
}
