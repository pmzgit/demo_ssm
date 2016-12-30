package com.pmz.model.base.proxy;

import com.pmz.model.sys.User;

import java.util.Date;

/**
 * Created by pmz on 16-12-25.
 */
public abstract class DataEntity<T> extends BaseEntity<T>{
    private static final long serialVersionUID = 1L;

    protected String remarks;
    protected User createBy;
    protected Date createDate;
    protected User updateBy;
    protected User updateDate;
    protected String delFlag;

    public DataEntity(){
        super();
        this.delFlag = DEL_FLAG_NORMAL;
    }

    public DataEntity(String id){
        super(id);
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    public User getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(User updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
