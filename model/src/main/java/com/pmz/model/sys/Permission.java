package com.pmz.model.sys;

import com.pmz.model.base.proxy.DataEntity;
import org.apache.ibatis.type.Alias;

/**
 * Created by Administrator on 2016/12/30.
 */
@Alias("permission")
public class Permission extends DataEntity<Permission>{
    private static final long servialVersionUID = 1l;
    public static final Integer MENU = 1;
    public static final Integer BUTTON = 2;
    public static final Integer DATA = 3;

    private Permission parent;
    private String name;
    private String permission;
    private String href;
    private Integer no;
    private String route;
    private Integer permissionType;
    private Integer menuType;
    private String icon;
    private Integer sort;

    public Permission getParent() {
        return parent;
    }

    public void setParent(Permission parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
