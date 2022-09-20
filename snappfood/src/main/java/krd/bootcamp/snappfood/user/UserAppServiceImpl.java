package krd.bootcamp.snappfood.user;

import krd.bootcamp.snappfood.common.exception.NotFoundException;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierRepository;
import krd.bootcamp.snappfood.supplier.SupplierService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAppServiceImpl implements UserAppService {

    private final UserAppRepository repository;

    @Override
    public UserApp save(UserApp userApp) {
        return repository.save(userApp);
    }

    @Override
    public UserApp update(UserApp userApp) {
        UserApp lastUserApp=findById(userApp.getId());
        lastUserApp.setUsername(userApp.getUsername());
        lastUserApp.setPassword(userApp.getPassword());
        return repository.save(lastUserApp);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public UserApp findById(Long id) {
        Optional<UserApp> userAppOptional=repository.findById(id);
        if(!userAppOptional.isPresent()){
            throw new NotFoundException("Not Found Supplier");
        }
        return userAppOptional.get();
    }

    @Override
    public Page<UserApp> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }


}
