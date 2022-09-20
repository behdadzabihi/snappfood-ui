package krd.bootcamp.snappfood.item;

import krd.bootcamp.snappfood.basket_item.BasketItem;
import krd.bootcamp.snappfood.suplier_category.SupplierCategory;
import krd.bootcamp.snappfood.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_item")
@Data
@Audited
public class Item extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private Integer price;

    @NotNull
    private String image;

    @NotNull
    private String description;


    @ManyToOne
    @JoinColumn(name = "supplier_category_id")
    private SupplierCategory supplierCategory;

   @OneToMany(fetch = FetchType.LAZY,mappedBy = "item",cascade = CascadeType.ALL)
    private List<BasketItem> basketItems;
}
