package krd.bootcamp.snappfood.basket;

import krd.bootcamp.snappfood.address.Address;
import krd.bootcamp.snappfood.common.BaseEntity;
import krd.bootcamp.snappfood.basket_item.BasketItem;
import krd.bootcamp.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Table(name = "tbl_basket")
@Data
@Audited
public class Basket extends BaseEntity {


    @NotNull
    @Column(name = "paid_price")
    private String paidPrice;

    @NotNull
    @JoinColumn(name = "finalize_basket")
    private Boolean finalizeBasket;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "basket",cascade = CascadeType.ALL)
    private List<BasketItem> basketItems;




}
