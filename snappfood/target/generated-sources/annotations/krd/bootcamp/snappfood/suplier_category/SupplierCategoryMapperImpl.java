package krd.bootcamp.snappfood.suplier_category;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.category.CategoryDTO;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T04:52:07-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class SupplierCategoryMapperImpl implements SupplierCategoryMapper {

    @Override
    public SupplierCategory toSupplierCategory(SupplierCategoryDTO supplierCategoryDTO) {
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

    @Override
    public SupplierCategoryDTO toSupplierCategoryDTO(SupplierCategory supplierCategory) {
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

    @Override
    public List<SupplierCategory> toSupplierCategories(List<SupplierCategoryDTO> supplierCategoryDTOS) {
        if ( supplierCategoryDTOS == null ) {
            return null;
        }

        List<SupplierCategory> list = new ArrayList<SupplierCategory>( supplierCategoryDTOS.size() );
        for ( SupplierCategoryDTO supplierCategoryDTO : supplierCategoryDTOS ) {
            list.add( toSupplierCategory( supplierCategoryDTO ) );
        }

        return list;
    }

    @Override
    public List<SupplierCategoryDTO> toSupplierCategoryDTOs(List<SupplierCategory> supplierCategories) {
        if ( supplierCategories == null ) {
            return null;
        }

        List<SupplierCategoryDTO> list = new ArrayList<SupplierCategoryDTO>( supplierCategories.size() );
        for ( SupplierCategory supplierCategory : supplierCategories ) {
            list.add( toSupplierCategoryDTO( supplierCategory ) );
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
}
