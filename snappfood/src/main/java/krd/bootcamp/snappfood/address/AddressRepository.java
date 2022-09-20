package krd.bootcamp.snappfood.address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address,Long> {

    Page<Address> findAllByUserApp_Id(Pageable pageable,Long userAppId);

    Page<Address> findAll(Pageable pageable);
}
