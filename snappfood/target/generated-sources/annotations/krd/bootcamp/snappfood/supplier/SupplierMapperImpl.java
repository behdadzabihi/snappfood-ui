package krd.bootcamp.snappfood.supplier;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.category.CategoryDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T04:52:07-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Override
    public Supplier toSupplier(SupplierDTO supplierDTO) {
        if ( supplierDTO == null ) {
            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setLocation( convertLocationDtoToLocation( supplierDTO.getLocationDTO() ) );
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

    @Override
    public SupplierDTO toSupplierDTO(Supplier supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setLocationDTO( convertlLocationToLocationDTO( supplier.getLocation() ) );
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

    @Override
    public List<Supplier> toSuppliers(List<SupplierDTO> supplierDTOS) {
        if ( supplierDTOS == null ) {
            return null;
        }

        List<Supplier> list = new ArrayList<Supplier>( supplierDTOS.size() );
        for ( SupplierDTO supplierDTO : supplierDTOS ) {
            list.add( toSupplier( supplierDTO ) );
        }

        return list;
    }

    @Override
    public List<SupplierDTO> toSupplierDTOs(List<Supplier> suppliers) {
        if ( suppliers == null ) {
            return null;
        }

        List<SupplierDTO> list = new ArrayList<SupplierDTO>( suppliers.size() );
        for ( Supplier supplier : suppliers ) {
            list.add( toSupplierDTO( supplier ) );
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
}
