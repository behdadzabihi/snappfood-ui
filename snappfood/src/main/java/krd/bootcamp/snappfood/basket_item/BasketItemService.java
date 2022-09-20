package krd.bootcamp.snappfood.basket_item;

import org.springframework.data.domain.Page;

public interface BasketItemService {

    BasketItem save(BasketItem basketItem);

    BasketItem update(BasketItem basketItem);

    void delete(Long id);

    BasketItem findById(Long id);

    Page<BasketItem> findAllByItemId(Integer page, Integer size, Long productId);

    Page<BasketItem> findAllByBasketId(Integer page, Integer size, Long basketId);
    Page<BasketItem> findAll(Integer page, Integer size);
}
