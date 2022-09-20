package krd.bootcamp.snappfood.suplier_category;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.snappfood.common.BaseDTO;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierDTO;
import lombok.Data;


@Data
public class SupplierCategoryDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private SupplierDTO supplier;
}
