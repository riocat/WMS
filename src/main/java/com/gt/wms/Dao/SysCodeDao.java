package com.gt.wms.Dao;

import com.gt.wms.Entity.SysCode;

import java.util.List;

/**
 * Created by rio on 2019/3/25.
 */
public interface SysCodeDao {

    List<SysCode> getSysCodeList(SysCode sysCode);
}
