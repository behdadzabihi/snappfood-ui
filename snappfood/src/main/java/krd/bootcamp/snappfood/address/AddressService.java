package krd.bootcamp.snappfood.address;

import org.springframework.data.domain.Page;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AddressService {

    Address save(Address address);

    Page<Address> findAll(Integer page,Integer size);

    Address findById(Long id);

    Page<Address> findAllByUserAppId(Integer page,Integer size,Long userAppId);

    Address update(Address address);

    void delete(Long id);
}
