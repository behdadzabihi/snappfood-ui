package krd.bootcamp.snappfood.user;

import krd.bootcamp.snappfood.supplier.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAppRepository extends PagingAndSortingRepository<UserApp,Long> {

    Page<UserApp> findAll(Pageable pageable);


}
