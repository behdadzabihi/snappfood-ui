package krd.bootcamp.snappfood.basket;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.bootcamp.snappfood.address.Address;
import krd.bootcamp.snappfood.address.AddressDTO;
import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.category.CategoryDTO;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierDTO;
import krd.bootcamp.snappfood.user.UserApp;
import krd.bootcamp.snappfood.user.UserAppDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T04:52:07-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class BasketMapperImpl implements BasketMapper {

    @Override
    public Basket toBasket(BasketDTO basketDTO) {
        if ( basketDTO == null ) {
            return null;
        }

        Basket basket = new Basket();

        basket.setId( basketDTO.getId() );
        basket.setVersion( basketDTO.getVersion() );
        basket.setCreatedData( basketDTO.getCreatedData() );
        basket.setCreatedBy( basketDTO.getCreatedBy() );
        basket.setLastModifiedData( basketDTO.getLastModifiedData() );
        basket.setLastModifiedBy( basketDTO.getLastModifiedBy() );
        basket.setPaidPrice( basketDTO.getPaidPrice() );
        basket.setFinalizeBasket( basketDTO.getFinalizeBasket() );
        basket.setSupplier( supplierDTOToSupplier( basketDTO.getSupplier() ) );
        basket.setAddress( addressDTOToAddress( basketDTO.getAddress() ) );

        return basket;
    }

    @Override
    public BasketDTO toBasketDTO(Basket basket) {
        if ( basket == null ) {
            return null;
        }

        BasketDTO basketDTO = new BasketDTO();

        basketDTO.setId( basket.getId() );
        basketDTO.setVersion( basket.getVersion() );
        basketDTO.setCreatedData( basket.getCreatedData() );
        basketDTO.setCreatedBy( basket.getCreatedBy() );
        basketDTO.setLastModifiedData( basket.getLastModifiedData() );
        basketDTO.setLastModifiedBy( basket.getLastModifiedBy() );
        basketDTO.setPaidPrice( basket.getPaidPrice() );
        basketDTO.setFinalizeBasket( basket.getFinalizeBasket() );
        basketDTO.setSupplier( supplierToSupplierDTO( basket.getSupplier() ) );
        basketDTO.setAddress( addressToAddressDTO( basket.getAddress() ) );

        return basketDTO;
    }

    @Override
    public List<Basket> toBaskets(List<BasketDTO> basketDTOS) {
        if ( basketDTOS == null ) {
            return null;
        }

        List<Basket> list = new ArrayList<Basket>( basketDTOS.size() );
        for ( BasketDTO basketDTO : basketDTOS ) {
            list.add( toBasket( basketDTO ) );
        }

        return list;
    }

    @Override
    public List<BasketDTO> toBasketDTOs(List<Basket> baskets) {
        if ( baskets == null ) {
            return null;
        }

        List<BasketDTO> list = new ArrayList<BasketDTO>( baskets.size() );
        for ( Basket basket : baskets ) {
            list.add( toBasketDTO( basket ) );
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

    protected UserApp userAppDTOToUserApp(UserAppDTO userAppDTO) {
        if ( userAppDTO == null ) {
            return null;
        }

        UserApp userApp = new UserApp();

        userApp.setId( userAppDTO.getId() );
        userApp.setVersion( userAppDTO.getVersion() );
        userApp.setCreatedData( userAppDTO.getCreatedData() );
        userApp.setCreatedBy( userAppDTO.getCreatedBy() );
        userApp.setLastModifiedData( userAppDTO.getLastModifiedData() );
        userApp.setLastModifiedBy( userAppDTO.getLastModifiedBy() );
        userApp.setUsername( userAppDTO.getUsername() );
        userApp.setPassword( userAppDTO.getPassword() );

        return userApp;
    }

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setVersion( addressDTO.getVersion() );
        address.setCreatedData( addressDTO.getCreatedData() );
        address.setCreatedBy( addressDTO.getCreatedBy() );
        address.setLastModifiedData( addressDTO.getLastModifiedData() );
        address.setLastModifiedBy( addressDTO.getLastModifiedBy() );
        address.setTitle( addressDTO.getTitle() );
        address.setPhoneNumber( addressDTO.getPhoneNumber() );
        address.setUserApp( userAppDTOToUserApp( addressDTO.getUserApp() ) );

        return address;
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

    protected UserAppDTO userAppToUserAppDTO(UserApp userApp) {
        if ( userApp == null ) {
            return null;
        }

        UserAppDTO userAppDTO = new UserAppDTO();

        userAppDTO.setId( userApp.getId() );
        userAppDTO.setVersion( userApp.getVersion() );
        userAppDTO.setCreatedData( userApp.getCreatedData() );
        userAppDTO.setCreatedBy( userApp.getCreatedBy() );
        userAppDTO.setLastModifiedData( userApp.getLastModifiedData() );
        userAppDTO.setLastModifiedBy( userApp.getLastModifiedBy() );
        userAppDTO.setUsername( userApp.getUsername() );
        userAppDTO.setPassword( userApp.getPassword() );

        return userAppDTO;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setVersion( address.getVersion() );
        addressDTO.setCreatedData( address.getCreatedData() );
        addressDTO.setCreatedBy( address.getCreatedBy() );
        addressDTO.setLastModifiedData( address.getLastModifiedData() );
        addressDTO.setLastModifiedBy( address.getLastModifiedBy() );
        addressDTO.setTitle( address.getTitle() );
        addressDTO.setPhoneNumber( address.getPhoneNumber() );
        addressDTO.setUserApp( userAppToUserAppDTO( address.getUserApp() ) );

        return addressDTO;
    }
}
