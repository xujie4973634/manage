package com.hemai.manage.model;

import javax.persistence.*;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 10:33 2018/8/30
 */
@Entity
@Table(name = "test")
public class Test {

    @Id
    @Column(nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name ;
    @Column
    private String phone ;
    @Column
    private int age ;
    @Column
    private String sex ;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
