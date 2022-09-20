package krd.bootcamp.snappfood.item;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.category.CategoryDTO;
import krd.bootcamp.snappfood.suplier_category.SupplierCategory;
import krd.bootcamp.snappfood.suplier_category.SupplierCategoryDTO;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T04:52:07-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toItem(ItemDTO itemDTO) {
        if ( itemDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( itemDTO.getId() );
        item.setVersion( itemDTO.getVersion() );
        item.setCreatedData( itemDTO.getCreatedData() );
        item.setCreatedBy( itemDTO.getCreatedBy() );
        item.setLastModifiedData( itemDTO.getLastModifiedData() );
        item.setLastModifiedBy( itemDTO.getLastModifiedBy() );
        item.setName( itemDTO.getName() );
        item.setPrice( itemDTO.getPrice() );
        item.setImage( itemDTO.getImage() );
        item.setDescription( itemDTO.getDescription() );
        item.setSupplierCategory( supplierCategoryDTOToSupplierCategory( itemDTO.getSupplierCategory() ) );

        return item;
    }

    @Override
    public ItemDTO toItemDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId( item.getId() );
        itemDTO.setVersion( item.getVersion() );
        itemDTO.setCreatedData( item.getCreatedData() );
        itemDTO.setCreatedBy( item.getCreatedBy() );
        itemDTO.setLastModifiedData( item.getLastModifiedData() );
        itemDTO.setLastModifiedBy( item.getLastModifiedBy() );
        itemDTO.setName( item.getName() );
        itemDTO.setPrice( item.getPrice() );
        itemDTO.setImage( item.getImage() );
        itemDTO.setDescription( item.getDescription() );
        itemDTO.setSupplierCategory( supplierCategoryToSupplierCategoryDTO( item.getSupplierCategory() ) );

        return itemDTO;
    }

    @Override
    public List<Item> toItems(List<ItemDTO> itemDTOS) {
        if ( itemDTOS == null ) {
            return null;
        }

        List<Item> list = new ArrayList<Item>( itemDTOS.size() );
        for ( ItemDTO itemDTO : itemDTOS ) {
            list.add( toItem( itemDTO ) );
        }

        return list;
    }

    @Override
    public List<ItemDTO> toItemsDTOs(List<Item> items) {
        if ( items == null ) {
            return null;
        }

        List<ItemDTO> list = new ArrayList<ItemDTO>( items.size() );
        for ( Item item : items ) {
            list.add( toItemDTO( item ) );
        }

        return list;
    }

    protected Category categoryDTOToCategory(CategoryDTO categoryDTO) {
        if ( categoryDTO == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDTO.getId() );
        category.setVersion( categoryDTO.getVersion() );
        category.setCreatedData( categoryDTO.getCreatedData() );
        category.setCreatedBy( categoryDTO.getCreatedBy() );
        category.setLastModifiedData( categoryDTO.getLastModifiedData() );
        category.setLastModifiedBy( categoryDTO.getLastModifiedBy() );
        category.setTitle( categoryDTO.getTitle() );
        category.setLogo( categoryDTO.getLogo() );

        return category;
    }

    protected Supplier supplierDTOToSupplier(SupplierDTO supplierDTO) {
        if ( supplierDTO == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setId( supplierDTO.getId() );
        supplier.setVersion( supplierDTO.getVersion() );
        supplier.setCreatedData( supplierDTO.getCreatedData() );
        supplier.setCreatedBy( supplierDTO.getCreatedBy() );
        supplier.setLastModifiedData( supplierDTO.getLastModifiedData() );
        supplier.setLastModifiedBy( supplierDTO.getLastModifiedBy() );
        supplier.setName( supplierDTO.getName() );
        supplier.setUsername( supplierDTO.getUsername() );
        supplier.setPassword( supplierDTO.getPassword() );
        supplier.setLogo( supplierDTO.getLogo() );
        supplier.setAbout( supplierDTO.getAbout() );
        supplier.setDeliveryPrice( supplierDTO.getDeliveryPrice() );
        supplier.setCategory( categoryDTOToCategory( supplierDTO.getCategory() ) );

        return supplier;
    }

    protected SupplierCategory supplierCategoryDTOToSupplierCategory(SupplierCategoryDTO supplierCategoryDTO) {
        if ( supplierCategoryDTO == null ) {
            return null;
        }

        SupplierCategory supplierCategory = new SupplierCategory();

        supplierCategory.setId( supplierCategoryDTO.getId() );
        supplierCategory.setVersion( supplierCategoryDTO.getVersion() );
        supplierCategory.setCreatedData( supplierCategoryDTO.getCreatedData() );
        supplierCategory.setCreatedBy( supplierCategoryDTO.getCreatedBy() );
        supplierCategory.setLastModifiedData( supplierCategoryDTO.getLastModifiedData() );
        supplierCategory.setLastModifiedBy( supplierCategoryDTO.getLastModifiedBy() );
        supplierCategory.setTitle( supplierCategoryDTO.getTitle() );
        supplierCategory.setSupplier( supplierDTOToSupplier( supplierCategoryDTO.getSupplier() ) );

        return supplierCategory;
    }

    protected CategoryDTO categoryToCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( category.getId() );
        categoryDTO.setVersion( category.getVersion() );
        categoryDTO.setCreatedData( category.getCreatedData() );
        categoryDTO.setCreatedBy( category.getCreatedBy() );
        categoryDTO.setLastModifiedData( category.getLastModifiedData() );
        categoryDTO.setLastModifiedBy( category.getLastModifiedBy() );
        categoryDTO.setTitle( category.getTitle() );
        categoryDTO.setLogo( category.getLogo() );

        return categoryDTO;
    }

    protected SupplierDTO supplierToSupplierDTO(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setId( supplier.getId() );
        supplierDTO.setVersion( supplier.getVersion() );
        supplierDTO.setCreatedData( supplier.getCreatedData() );
        supplierDTO.setCreatedBy( supplier.getCreatedBy() );
        supplierDTO.setLastModifiedData( supplier.getLastModifiedData() );
        supplierDTO.setLastModifiedBy( supplier.getLastModifiedBy() );
        supplierDTO.setName( supplier.getName() );
        supplierDTO.setUsername( supplier.getUsername() );
        supplierDTO.setPassword( supplier.getPassword() );
        supplierDTO.setLogo( supplier.getLogo() );
        supplierDTO.setAbout( supplier.getAbout() );
        supplierDTO.setDeliveryPrice( supplier.getDeliveryPrice() );
        supplierDTO.setCategory( categoryToCategoryDTO( supplier.getCategory() ) );

        return supplierDTO;
    }

    protected SupplierCategoryDTO supplierCategoryToSupplierCategoryDTO(SupplierCategory supplierCategory) {
        if ( supplierCategory == null ) {
            return null;
        }

        SupplierCategoryDTO supplierCategoryDTO = new SupplierCategoryDTO();

        supplierCategoryDTO.setId( supplierCategory.getId() );
        supplierCategoryDTO.setVersion( supplierCategory.getVersion() );
        supplierCategoryDTO.setCreatedData( supplierCategory.getCreatedData() );
        supplierCategoryDTO.setCreatedBy( supplierCategory.getCreatedBy() );
        supplierCategoryDTO.setLastModifiedData( supplierCategory.getLastModifiedData() );
        supplierCategoryDTO.setLastModifiedBy( supplierCategory.getLastModifiedBy() );
        supplierCategoryDTO.setTitle( supplierCategory.getTitle() );
        supplierCategoryDTO.setSupplier( supplierToSupplierDTO( supplierCategory.getSupplier() ) );

        return supplierCategoryDTO;
    }
}
