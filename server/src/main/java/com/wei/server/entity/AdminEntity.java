package com.wei.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_admin")
@ApiModel(value = "AdminEntity对象", description = "")
public class AdminEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("姓名")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("手机号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("住宅电话")
    @TableField("telephone")
    private String telephone;

    @ApiModelProperty("联系地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("是否启用")
    @TableField("enabled")
    private Boolean enabled;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("`password`")
    private String password;

    @ApiModelProperty("用户头像")
    @TableField("userFace")
    private String userFace;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


}
