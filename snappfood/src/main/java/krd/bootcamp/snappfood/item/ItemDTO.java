package krd.bootcamp.snappfood.item;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.snappfood.suplier_category.SupplierCategoryDTO;
import krd.bootcamp.snappfood.common.BaseDTO;
import lombok.Data;


@Data
public class ItemDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String name;

    @ApiModelProperty(required = true,hidden = false)
    private Integer price;

    @ApiModelProperty(required = true,hidden = false)
    private String image;

    @ApiModelProperty(required = true,hidden = false)
    private String description;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierCategoryDTO supplierCategory;
}
