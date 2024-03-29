package com.wei.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author ChenZhen
 * @since 2021-11-20
 */
@Getter
@Setter
@TableName("t_employee_ec")
@ApiModel(value = "EmployeeEcEntity对象", description = "")
public class EmployeeEcEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工编号")
    @TableField("eid")
    private Integer eid;

    @ApiModelProperty("奖罚日期")
    @TableField("ecDate")
    private LocalDate ecDate;

    @ApiModelProperty("奖罚原因")
    @TableField("ecReason")
    private String ecReason;

    @ApiModelProperty("奖罚分")
    @TableField("ecPoint")
    private Integer ecPoint;

    @ApiModelProperty("奖罚类别，0：奖，1：罚")
    @TableField("ecType")
    private Integer ecType;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
