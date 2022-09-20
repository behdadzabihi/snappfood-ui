package krd.bootcamp.snappfood.address;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import krd.bootcamp.snappfood.user.UserApp;
import krd.bootcamp.snappfood.user.UserAppDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T04:52:07-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setLocation( convertLocationDtoToLocation( addressDTO.getLocationDTO() ) );
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

    @Override
    public AddressDTO toAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setLocationDTO( convertlLocationToLocationDTO( address.getLocation() ) );
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

    @Override
    public List<Address> toAddresses(List<AddressDTO> addressDTOS) {
        if ( addressDTOS == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTOS.size() );
        for ( AddressDTO addressDTO : addressDTOS ) {
            list.add( toAddress( addressDTO ) );
        }

        return list;
    }

    @Override
    public List<AddressDTO> toAddressDTOS(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toAddressDTO( address ) );
        }

        return list;
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
}
