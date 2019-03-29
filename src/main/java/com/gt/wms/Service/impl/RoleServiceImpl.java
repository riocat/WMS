package com.gt.wms.Service.impl;

import com.gt.wms.Dao.RoleDao;
import com.gt.wms.Entity.Permission;
import com.gt.wms.Entity.User;
import com.gt.wms.Service.RoleService;
import com.gt.wms.util.PermissionComparator;
import com.gt.wms.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by rio on 2019/3/26.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Permission> getMenuByRole(User puser) {
        List<Permission> base = roleDao.getMenuByRole(puser);
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
            sortList(p.getSubPermissions());
        }
    }

    public static void main(String[] args) {
        List keys = new ArrayList();
        keys.add(2);
        keys.add(1);
        keys.add(4);
        keys.add(3);

        Collections.sort(keys);

        System.out.println(keys.toArray());

        Collections.reverse(keys);

        System.out.println(keys.toArray());
    }

}
