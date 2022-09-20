package krd.bootcamp.snappfood.category;

import krd.bootcamp.snappfood.basket.Basket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
    Page<Category> findAll(Pageable pageable);
}
