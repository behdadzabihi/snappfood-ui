package krd.bootcamp.snappfood.address;

import krd.bootcamp.snappfood.basket.Basket;
import krd.bootcamp.snappfood.common.BaseEntity;
import krd.bootcamp.snappfood.user.UserApp;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.annotations.Comment;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_address")
@Data
@Audited
public class Address extends BaseEntity {

    @NotNull
    private String title;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column(name = "user_location")
    private Point<G2D> location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "address",cascade = CascadeType.ALL)
    private List<Basket> baskets;
}
