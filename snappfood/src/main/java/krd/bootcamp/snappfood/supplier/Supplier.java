package krd.bootcamp.snappfood.supplier;

import krd.bootcamp.snappfood.basket.Basket;
import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.common.BaseEntity;
import krd.bootcamp.snappfood.suplier_category.SupplierCategory;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_supplier")
@Data
@Audited
public class Supplier extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private String username;

    @NotNull
    private String password;


    @NotNull
    @Column(name = "supplier_location")
    private Point<G2D> location;

    @NotNull
    private String logo;

    @NotNull
    private String about;

    @NotNull
    @Column(name = "delivery_price")
    private String deliveryPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<SupplierCategory> supplierCategories;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<Basket> baskets;


}
