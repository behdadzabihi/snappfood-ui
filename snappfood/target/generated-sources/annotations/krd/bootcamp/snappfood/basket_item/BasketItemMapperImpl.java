package krd.bootcamp.snappfood.basket_item;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.bootcamp.snappfood.basket.BasketMapper;
import krd.bootcamp.snappfood.item.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T07:20:48-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class BasketItemMapperImpl implements BasketItemMapper {

    @Autowired
    private BasketMapper basketMapper;
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public BasketItem toBasketItem(BasketItemDTO basketItemDTO) {
        if ( basketItemDTO == null ) {
            return null;
        }

        BasketItem basketItem = new BasketItem();

        basketItem.setId( basketItemDTO.getId() );
        basketItem.setVersion( basketItemDTO.getVersion() );
        basketItem.setCreatedData( basketItemDTO.getCreatedData() );
        basketItem.setCreatedBy( basketItemDTO.getCreatedBy() );
        basketItem.setLastModifiedData( basketItemDTO.getLastModifiedData() );
        basketItem.setLastModifiedBy( basketItemDTO.getLastModifiedBy() );
        basketItem.setCount( basketItemDTO.getCount() );
        basketItem.setBasket( basketMapper.toBasket( basketItemDTO.getBasket() ) );
        basketItem.setItem( itemMapper.toItem( basketItemDTO.getItem() ) );

        return basketItem;
    }

    @Override
    public BasketItemDTO toBasketItemDTO(BasketItem basketItem) {
        if ( basketItem == null ) {
            return null;
        }

        BasketItemDTO basketItemDTO = new BasketItemDTO();

        basketItemDTO.setId( basketItem.getId() );
        basketItemDTO.setVersion( basketItem.getVersion() );
        basketItemDTO.setCreatedData( basketItem.getCreatedData() );
        basketItemDTO.setCreatedBy( basketItem.getCreatedBy() );
        basketItemDTO.setLastModifiedData( basketItem.getLastModifiedData() );
        basketItemDTO.setLastModifiedBy( basketItem.getLastModifiedBy() );
        basketItemDTO.setCount( basketItem.getCount() );
        basketItemDTO.setBasket( basketMapper.toBasketDTO( basketItem.getBasket() ) );
        basketItemDTO.setItem( itemMapper.toItemDTO( basketItem.getItem() ) );

        return basketItemDTO;
    }

    @Override
    public List<BasketItem> toBasketItems(List<BasketItemDTO> basketItemDTOS) {
        if ( basketItemDTOS == null ) {
            return null;
        }

        List<BasketItem> list = new ArrayList<BasketItem>( basketItemDTOS.size() );
        for ( BasketItemDTO basketItemDTO : basketItemDTOS ) {
            list.add( toBasketItem( basketItemDTO ) );
        }

        return list;
    }

    @Override
    public List<BasketItemDTO> toBasketItemDTOs(List<BasketItem> basketItems) {
        if ( basketItems == null ) {
            return null;
        }

        List<BasketItemDTO> list = new ArrayList<BasketItemDTO>( basketItems.size() );
        for ( BasketItem basketItem : basketItems ) {
            list.add( toBasketItemDTO( basketItem ) );
        }

        return list;
    }
}
