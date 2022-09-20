package krd.bootcamp.snappfood.item;

import krd.bootcamp.snappfood.suplier_category.SupplierCategoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {SupplierCategoryMapper.class})
public interface ItemMapper {

    Item toItem(ItemDTO itemDTO);

    ItemDTO toItemDTO(Item item);

    List<Item> toItems(List<ItemDTO> itemDTOS);

    List<ItemDTO> toItemsDTOs(List<Item> items);
}
