package krd.bootcamp.snappfood.user;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.snappfood.common.BaseDTO;
import lombok.Data;


@Data
public class UserAppDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String username;

    @ApiModelProperty(required = true,hidden = false)
    private String password;



}
