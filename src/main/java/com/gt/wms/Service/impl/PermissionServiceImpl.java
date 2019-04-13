package com.gt.wms.Service.impl;

import com.gt.wms.Dao.PermissionDao;
import com.gt.wms.Entity.Permission;
import com.gt.wms.Service.PermissionService;
import com.gt.wms.util.PermissionComparator;
import com.gt.wms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by rio on 2019/3/28.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> getAllPermissionList(Map parMap) {
        return permissionDao.getAllPermissionList(parMap);
    }

    @Override
    public int getPageNum(Map parMap) {
        return permissionDao.getPageNum(parMap);
    }

    @Override
    public boolean uniqueCheck(Permission permission) {
        return permissionDao.uniqueCheck(permission) >= 1 ? false : true;
    }

    @Override
    public List<Permission> getSimplePermissionList() {
        return permissionDao.getSimplePermissionList();
    }

    @Override
    public List<Permission> getLevelPermissionList(List<Permission> base) {
        Map<Integer, Set> levels = new HashMap<Integer, Set>();
        for (Permission p : base) {
            if (levels.containsKey(Integer.parseInt(p.getLevel()))) {
                levels.get(Integer.parseInt(p.getLevel())).add(p);
            } else {
                Set set = new HashSet();
                set.add(p);
                levels.put(Integer.parseInt(p.getLevel()), set);
            }
        }

        List<Integer> keys = new ArrayList(levels.keySet());

        Collections.sort(keys);

        List<Permission> targetList = new ArrayList<Permission>();

        if (keys.size() > 0) {
            for (int i = keys.get(keys.size() - 2); i >= 1; i--) {
                Set baseLevel = levels.get(i);
                Set targetLevel = levels.get(i + 1);
                Iterator iteratorBase = baseLevel.iterator();
                while (iteratorBase.hasNext()) {
                    Permission bp = (Permission) iteratorBase.next();
                    Iterator iteratorSub = targetLevel.iterator();
                    while (iteratorSub.hasNext()) {
                        Permission sp = (Permission) iteratorSub.next();
                        if (StringUtil.checkStringEquals(bp.getId(), sp.getParent())) {
                            bp.getSubPermissions().add(sp);
                        }
                    }
                }
            }

            targetList = new ArrayList(levels.get(1));

            sortList(targetList);
        }
        return targetList;
    }

    private void sortList(List<Permission> targetList) {
        Collections.sort(targetList, new PermissionComparator());

        for (Permission p : targetList) {
            if (p.getSubPermissions().size() > 0)
                p.setIsParent(true);
            sortList(p.getSubPermissions());
        }
    }
}
