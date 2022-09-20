package krd.bootcamp.snappfood.basket_item;

import krd.bootcamp.snappfood.basket.Basket;
import krd.bootcamp.snappfood.common.BaseEntity;
import krd.bootcamp.snappfood.item.Item;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_basket_item")
@Data
@Audited
public class BasketItem extends BaseEntity {

    @NotNull
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
