package krd.bootcamp.snappfood.basket;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.snappfood.address.AddressDTO;
import krd.bootcamp.snappfood.common.BaseDTO;
import krd.bootcamp.snappfood.supplier.SupplierDTO;
import lombok.Data;


@Data
public class BasketDTO extends BaseDTO {


    @ApiModelProperty(required = true,hidden = false)
    private String paidPrice;

    @ApiModelProperty(required = true,hidden = false)
    private Boolean finalizeBasket;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierDTO supplier;

    @ApiModelProperty(required = true,hidden = false)
    private AddressDTO address;



}
