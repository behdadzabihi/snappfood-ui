package krd.bootcamp.snappfood.suplier_category;

import krd.bootcamp.snappfood.common.BaseEntity;
import krd.bootcamp.snappfood.item.Item;
import krd.bootcamp.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_supplier_category")
@Data
@Audited
public class SupplierCategory extends BaseEntity {

    @NotNull
    private String title;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "supplierCategory",cascade = CascadeType.ALL)
    private List<Item> items;



}
