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
@TableName("t_employee_train")
@ApiModel(value = "EmployeeTrainEntity对象", description = "")
public class EmployeeTrainEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("员工编号")
    @TableField("eid")
    private Integer eid;

    @ApiModelProperty("培训日期")
    @TableField("trainDate")
    private LocalDate trainDate;

    @ApiModelProperty("培训内容")
    @TableField("trainContent")
    private String trainContent;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
