package com.hemai.manage.model;

import com.hemai.manage.base.model.BaseModel;

import javax.persistence.*;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 17:08 2018/8/1
 */
@Entity
@Table(name = "t_user")
public class User extends BaseModel {

    public static final String _name = "name";
    public static final String _loginName = "loginName";
    public static final String _loginPass = "loginPass";

    @Column
    private String name ;

    @Column
    private String loginName ;

    @Column
    private String loginPass ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }
}
