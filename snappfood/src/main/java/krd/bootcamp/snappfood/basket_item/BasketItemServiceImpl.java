package krd.bootcamp.snappfood.basket_item;

import krd.bootcamp.snappfood.basket.Basket;
import krd.bootcamp.snappfood.basket.BasketService;
import krd.bootcamp.snappfood.common.exception.NotFoundException;
import krd.bootcamp.snappfood.item.Item;
import krd.bootcamp.snappfood.item.ItemService;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketItemServiceImpl implements BasketItemService {

    private final BasketItemRepository repository;

    private final BasketService basketService;

    private final ItemService itemService;


    @Override
    public BasketItem save(BasketItem basketItem) {
            Long basketId=basketItem.getBasket().getId();
            Long iId=basketItem.getItem().getId();
            Basket basket=basketService.findById(basketId);
            Item item=itemService.findById(iId);
            basketItem.setBasket(basket);
            basketItem.setItem(item);
        return repository.save(basketItem);
    }

    @Override
    public BasketItem update(BasketItem basketItem) {
        BasketItem lastBasketItem=findById(basketItem.getId());
        lastBasketItem.setCount(basketItem.getCount());
        Basket basket=basketService.findById(basketItem.getBasket().getId());
        Item item=itemService.findById(basketItem.getItem().getId());
        lastBasketItem.setBasket(basket);
        lastBasketItem.setItem(item);
        return repository.save(lastBasketItem);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public BasketItem findById(Long id) {
        Optional<BasketItem> productItemOptional=repository.findById(id);
        if(!productItemOptional.isPresent()){
            throw new NotFoundException("Not Found Item");
        }
        return productItemOptional.get();
    }

    @Override
    public Page<BasketItem> findAllByItemId(Integer page, Integer size, Long itemId) {
        return  repository.findAllByItem_Id(PageRequest.of(page,size),itemId);
    }

    @Override
    public Page<BasketItem> findAllByBasketId(Integer page, Integer size, Long basketId) {
        return  repository.findAllByBasket_Id(PageRequest.of(page,size),basketId);
    }

    @Override
    public Page<BasketItem> findAll(Integer page, Integer size) {
        return  repository.findAll(PageRequest.of(page,size));
    }
}
