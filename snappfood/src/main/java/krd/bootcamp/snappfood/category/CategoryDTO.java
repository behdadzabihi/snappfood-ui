package krd.bootcamp.snappfood.category;

import io.swagger.annotations.ApiModelProperty;
import krd.bootcamp.snappfood.common.BaseDTO;
import krd.bootcamp.snappfood.common.BaseEntity;
import krd.bootcamp.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
public class CategoryDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String title;

    @ApiModelProperty(required = true,hidden = false)
    private String logo;




}
