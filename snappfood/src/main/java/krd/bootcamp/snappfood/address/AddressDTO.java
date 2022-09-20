package krd.bootcamp.snappfood.address;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.snappfood.common.BaseDTO;
import krd.bootcamp.snappfood.user.UserAppDTO;
import lombok.Data;



@Data
public class AddressDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;

    @ApiModelProperty(required = true,hidden = false)
    private LocationDTO locationDTO;

    @ApiModelProperty(required = true,hidden = false)
    private UserAppDTO userApp;
}
