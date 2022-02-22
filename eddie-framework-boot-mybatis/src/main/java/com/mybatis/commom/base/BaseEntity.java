package com.mybatis.commom.base;

import java.io.Serializable;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "数据状态", description = "数据状态")
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -7582664785863208598L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "修改时间")
    private Date modifyDate;

    @ApiModelProperty(value = "创建者用户ID")
    private Long createrId;

    @ApiModelProperty(value = "修改人用户ID")
    private Long modifierId;
}