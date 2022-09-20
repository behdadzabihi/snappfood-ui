package krd.bootcamp.snappfood.category;

import krd.bootcamp.snappfood.common.BaseEntity;
import krd.bootcamp.snappfood.supplier.Supplier;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
@Table(name = "tbl_category")
@Data
@Audited
public class Category extends BaseEntity {

    @NotNull
    private String title;

    @NotNull
    private String logo;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "category",cascade = CascadeType.ALL)
    private List<Supplier> suppliers;


}
