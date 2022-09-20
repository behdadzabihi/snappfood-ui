package krd.bootcamp.snappfood.basket;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends PagingAndSortingRepository<Basket,Long> {

    Page<Basket> findAll(Pageable pageable);

    Page<Basket> findAllByAddress_id(Pageable pageable, Long addressId);
}
