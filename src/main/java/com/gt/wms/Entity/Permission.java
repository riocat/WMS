package com.gt.wms.Entity;

import com.gt.wms.util.StringUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rio on 2019/3/26.
 */
public class Permission implements Serializable {

    private String id;
    private String name;
    private String descript;
    private String type;
    private String level;
    private String parent;
    private String url;
    private String code;
    private String create_user;
    private Date create_time;
    private String update_user;
    private Date update_time;
    private String is_delete;
    private String delete_user;
    private Date delete_time;
    private int order;

    private Permission parentEntity;
    private List<Permission> subPermissions = new ArrayList<Permission>();

    private boolean isParent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    public String getDelete_user() {
        return delete_user;
    }

    public void setDelete_user(String delete_user) {
        this.delete_user = delete_user;
    }

    public Date getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(Date delete_time) {
        this.delete_time = delete_time;
    }

    public Permission getParentEntity() {
        return parentEntity;
    }

    public void setParentEntity(Permission parentEntity) {
        this.parentEntity = parentEntity;
    }

    public List<Permission> getSubPermissions() {
        return subPermissions;
    }

    public void setSubPermissions(List<Permission> subPermissions) {
        this.subPermissions = subPermissions;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj instanceof Permission) {
            Permission other = (Permission) obj;
            return StringUtil.checkStringEquals(this.getId(), other.getId());
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.getId() == null ? 31 * 17 : this.getId().hashCode();
    }

    public boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(boolean isParent) {
        this.isParent = isParent;
    }
}
