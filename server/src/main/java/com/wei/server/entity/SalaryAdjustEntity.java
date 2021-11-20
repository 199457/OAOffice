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
@TableName("t_salary_adjust")
@ApiModel(value = "SalaryAdjustEntity对象", description = "")
public class SalaryAdjustEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工ID")
    @TableField("eid")
    private Integer eid;

    @ApiModelProperty("调薪日期")
    @TableField("asDate")
    private LocalDate asDate;

    @ApiModelProperty("调前薪资")
    @TableField("beforeSalary")
    private Integer beforeSalary;

    @ApiModelProperty("调后薪资")
    @TableField("afterSalary")
    private Integer afterSalary;

    @ApiModelProperty("调薪原因")
    @TableField("reason")
    private String reason;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
