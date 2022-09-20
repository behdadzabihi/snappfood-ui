package krd.bootcamp.snappfood.user;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-20T04:52:07-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Oracle Corporation)"
)
@Component
public class UserAppMapperImpl implements UserAppMapper {

    @Override
    public UserApp toUserApp(UserAppDTO userAppDTO) {
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

    @Override
    public UserAppDTO toUserAppDTO(UserApp userApp) {
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

    @Override
    public List<UserApp> toUserApps(List<UserAppDTO> userAppDTOS) {
        if ( userAppDTOS == null ) {
            return null;
        }

        List<UserApp> list = new ArrayList<UserApp>( userAppDTOS.size() );
        for ( UserAppDTO userAppDTO : userAppDTOS ) {
            list.add( toUserApp( userAppDTO ) );
        }

        return list;
    }

    @Override
    public List<UserAppDTO> toUserAppDTOs(List<UserApp> userApps) {
        if ( userApps == null ) {
            return null;
        }

        List<UserAppDTO> list = new ArrayList<UserAppDTO>( userApps.size() );
        for ( UserApp userApp : userApps ) {
            list.add( toUserAppDTO( userApp ) );
        }

        return list;
    }
}
