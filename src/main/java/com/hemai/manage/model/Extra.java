package com.hemai.manage.model;

import com.hemai.manage.base.model.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 11:31 2018/8/24
 */
@Entity
@Table(name = "t_extra")
public class Extra extends BaseModel {

    @Column
    private String name ;

    @Column
    private int overtime ;

    @Column
    private String remark ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
