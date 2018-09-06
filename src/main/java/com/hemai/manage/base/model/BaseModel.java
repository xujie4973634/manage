package com.hemai.manage.base.model;

import javax.persistence.*;
import java.util.Date;

/**
 * 所有实体类的父类,包含所有实体的公共属性
 *
 * @author TaoFaDeng@HF
 * @since 2016年07月05日15:46:16
 */
@MappedSuperclass
public class BaseModel {
    public static final String _id = "id";
    public static final String _createBy = "createBy";
    public static final String _updateBy = "updateBy";
    public static final String _createTime = "createTime";
    public static final String _updateTime = "updateTime";
    public static final String _startTime = "startTime";
    public static final String _endTime = "endTime";
    public static final String _point = ".";

    public enum OptType {
        DELETE("删除"), UPDATE("修改"), ADD("新增"), VIEW("预览");
        private String text;

        OptType(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 主键
     */
    @Id
    @Column(nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建人
     */
    @Column(length = 32, nullable = false, updatable = false)
    private Long createBy;

    /**
     * 最后更新人
     */
    @Column(length = 32, nullable = false)
    private Long updateBy;

    /**
     * 创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createTime;

    /**
     * 最后更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updateTime;

    /**
     * 操作类型
     */
    @Transient
    private OptType optType;

    @Transient
    private String StartTime;

    @Transient
    private String endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public OptType getOptType() {
        return optType;
    }

    public void setOptType(OptType optType) {
        this.optType = optType;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}