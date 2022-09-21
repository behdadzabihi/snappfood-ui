package krd.bootcamp.snappfood.address;

import krd.bootcamp.snappfood.common.exception.NotFoundException;
import krd.bootcamp.snappfood.user.UserApp;
import krd.bootcamp.snappfood.user.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{
    private final AddressRepository repository;
    private final UserAppService userAppService;

    @Override
    public Address save(Address address) {
        Long id=address.getUserApp().getId();
        UserApp userApp=userAppService.findById(id);
        address.setUserApp(userApp);
        return repository.save(address);
    }

    @Override
    public Page<Address> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }


    @Override
    public Address findById(Long id) {
        Optional<Address> addressOptional=repository.findById(id);
        if(!addressOptional.isPresent()){
            throw new NotFoundException("NOT FOUND ADDRESS");
        }
        return addressOptional.get();
    }

    @Override
    public Page<Address> findAllByUserAppId(Integer page, Integer size, Long userAppId) {
        return repository.findAllByUserApp_Id(PageRequest.of(page,size),userAppId);
    }

    @Override
    public Address update(Address address) {
        Address lastAddress=findById(address.getId());
        lastAddress.setTitle(address.getTitle());
        lastAddress.setPhoneNumber(address.getPhoneNumber());
        lastAddress.setLocation(address.getLocation());
        UserApp userApp=userAppService.findById(address.getUserApp().getId());
        lastAddress.setUserApp(userApp);
        return repository.save(lastAddress);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
