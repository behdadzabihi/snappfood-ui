package krd.bootcamp.snappfood.user;

import krd.bootcamp.snappfood.address.Address;
import krd.bootcamp.snappfood.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
@Audited
public class UserApp extends BaseEntity {

    @NotNull
    @Column(name = "user_name")
    private String username;

    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "userApp",cascade = CascadeType.ALL)
    private List<Address> addresses;


}
