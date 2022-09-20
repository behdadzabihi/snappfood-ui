package krd.bootcamp.snappfood.basket;

import krd.bootcamp.snappfood.address.AddressMapper;
import krd.bootcamp.snappfood.supplier.SupplierMapper;
import krd.bootcamp.snappfood.user.UserAppMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierMapper.class, AddressMapper.class})
public interface BasketMapper {

    Basket toBasket(BasketDTO basketDTO);

    BasketDTO toBasketDTO(Basket basket);

    List<Basket> toBaskets(List<BasketDTO> basketDTOS);

    List<BasketDTO> toBasketDTOs(List<Basket> baskets);
}
