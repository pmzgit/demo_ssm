package com.pmz.model.sys;

import com.pmz.model.base.proxy.DataEntity;
import org.apache.ibatis.type.Alias;

/**
 * Created by Administrator on 2017/1/4.
 */
@Alias("identity")
public class Identity extends DataEntity<Identity> {

    private static final long servialVersionUID = 1l;

    private String name;
    private String code;
    private String desc;
    private String dataScope;
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identity identity = (Identity) o;

        if (!getCode().equals(identity.getCode())) return false;
        if (getDataScope() != null ? !getDataScope().equals(identity.getDataScope()) : identity.getDataScope() != null)
            return false;
        return getStatus().equals(identity.getStatus());

    }

    @Override
    public int hashCode() {
        int result = getCode().hashCode();
        result = 31 * result + (getDataScope() != null ? getDataScope().hashCode() : 0);
        result = 31 * result + getStatus().hashCode();
        return result;
    }

}
