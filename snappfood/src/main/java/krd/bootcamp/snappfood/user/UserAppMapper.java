package krd.bootcamp.snappfood.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAppMapper {

    UserApp toUserApp(UserAppDTO userAppDTO);

    UserAppDTO toUserAppDTO(UserApp userApp);

    List<UserApp> toUserApps(List<UserAppDTO> userAppDTOS);

    List<UserAppDTO> toUserAppDTOs(List<UserApp> userApps);
}
