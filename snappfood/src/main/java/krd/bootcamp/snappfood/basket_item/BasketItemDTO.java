package krd.bootcamp.snappfood.basket_item;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.snappfood.basket.BasketDTO;
import krd.bootcamp.snappfood.common.BaseDTO;
import krd.bootcamp.snappfood.item.ItemDTO;
import lombok.Data;


@Data
public class BasketItemDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private Integer count;

    @ApiModelProperty(required = true,hidden = false)
    private BasketDTO basket;

    @ApiModelProperty(required = true,hidden = false)
    private ItemDTO item;
}
