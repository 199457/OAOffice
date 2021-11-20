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
@TableName("t_menu_role")
@ApiModel(value = "MenuRoleEntity对象", description = "")
public class MenuRoleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("菜单id")
    @TableField("mid")
    private Integer mid;

    @ApiModelProperty("权限id")
    @TableField("rid")
    private Integer rid;


}
