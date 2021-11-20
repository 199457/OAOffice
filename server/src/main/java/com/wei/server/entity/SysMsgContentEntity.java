package com.wei.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("t_sys_msg_content")
@ApiModel(value = "SysMsgContentEntity对象", description = "")
public class SysMsgContentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    @TableField("title")
    private String title;

    @ApiModelProperty("内容")
    @TableField("message")
    private String message;

    @ApiModelProperty("创建时间")
    @TableField("createDate")
    private LocalDateTime createDate;


}
