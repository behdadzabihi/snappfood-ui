package krd.bootcamp.snappfood.basket_item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketItemRepository extends PagingAndSortingRepository<BasketItem,Long> {

    Page<BasketItem> findAllByItem_Id(Pageable pageable,Long ItemId);

    Page<BasketItem> findAllByBasket_Id(Pageable pageable,Long BasketId);

    Page<BasketItem> findAll(Pageable pageable);
}
