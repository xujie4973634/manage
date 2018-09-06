package com.hemai.manage.model;

import com.hemai.manage.base.model.BaseModel;

import javax.persistence.*;

/**
 * @author com.hemai.www
 * @描述:TODO()
 * @date: Created in 20:39 2018/8/14
 */
@Entity
@Table(name = "t_history")
public class History extends BaseModel {

    public static final String _client = "client.id" ;


    /**
     * 客户姓名
     */
    @Column
    private  String clientName ;

    /**
     *   客户状态
     */
    @Column
    private String clientStatus ;


    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client ;

    /**
     * 客户详情描述
     */
    @Column
    private String clientDetails ;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(String clientStatus) {
        this.clientStatus = clientStatus;
    }

    public String getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(String clientDetails) {
        this.clientDetails = clientDetails;
    }
}
