package krd.bootcamp.snappfood.basket_item;

import krd.bootcamp.snappfood.basket.BasketMapper;
import krd.bootcamp.snappfood.item.ItemMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring" , uses = {BasketMapper.class , ItemMapper.class})
public interface BasketItemMapper {

    BasketItem toBasketItem (BasketItemDTO basketItemDTO);

    BasketItemDTO toBasketItemDTO (BasketItem basketItem);

    List<BasketItem> toBasketItems(List<BasketItemDTO> basketItemDTOS);

    List<BasketItemDTO> toBasketItemDTOs(List<BasketItem> basketItems);
}
