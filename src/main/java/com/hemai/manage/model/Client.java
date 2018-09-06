package com.hemai.manage.model;

import com.hemai.manage.base.model.BaseModel;

import javax.persistence.*;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 16:47 2018/8/2
 */
@Entity
@Table(name = "t_client")
public class Client extends BaseModel {

    public static final String _user = "user.id";
    public static final String _name = "name";
    public static final String _company = "company";
    public static final String _demand = "demand";
    public static final String _phone = "phone";
    public static final String _source = "source";
    public static final String _details = "details";
    public static final String _status = "status";


    public enum Status{
        NOT_START("未启动"), UNDERWAY("跟进中"), WIN("已完成"), FAILED("已放弃");

        private final String text;

        private Status(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    /**
     * 客户姓名
     */
    @Column
    private String name ;

    /**
     *客户所属公司
     */
    @Column
    private String company ;

    /**
     *客户需求
     */
    @Column
    private String demand ;

    /**
     *客户电话
     */
    @Column
    private String phone ;

    /**
     *客户来源
     */
    @Column
    private String source ;

    /**
     *  客户备注
     */
    @Column
    private String details ;

    /**
     *客户状态
     */
    @Column
    @Enumerated(EnumType.STRING)
    private Status status ;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
