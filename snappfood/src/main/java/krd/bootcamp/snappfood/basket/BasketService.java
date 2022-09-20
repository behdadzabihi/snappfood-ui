package krd.bootcamp.snappfood.basket;

import org.springframework.data.domain.Page;

public interface BasketService {

    Basket save(Basket basket);

    Basket update(Basket basket);

    void delete(Long id);

    Basket findById(Long id);

    Page<Basket> findAll(Integer page,Integer size);

    Page<Basket> findAllByAddressId(Integer page, Integer size, Long addressId);
}
