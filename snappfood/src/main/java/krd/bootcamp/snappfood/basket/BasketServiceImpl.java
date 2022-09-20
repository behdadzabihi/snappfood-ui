package krd.bootcamp.snappfood.basket;

import krd.bootcamp.snappfood.address.Address;
import krd.bootcamp.snappfood.address.AddressService;
import krd.bootcamp.snappfood.common.exception.NotFoundException;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService{


    private final SupplierService supplierService;
    private final BasketRepository repository;

    private final AddressService addressService;

    @Override
    public Basket save(Basket basket) {
        Long suppId=basket.getSupplier().getId();
        Supplier supplier=supplierService.findById(suppId);
        basket.setSupplier(supplier);

        Long adId=basket.getAddress().getId();
        Address address=addressService.findById(adId);
        basket.setAddress(address);

        return repository.save(basket);
    }

    @Override
    public Basket update(Basket basket) {
        Basket lastBasket=findById(basket.getId());
        lastBasket.setPaidPrice(basket.getPaidPrice());
        lastBasket.setFinalizeBasket(basket.getFinalizeBasket());
        return repository.save(lastBasket);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Basket findById(Long id) {
        Optional<Basket> basketOptional=repository.findById(id);
        if(!basketOptional.isPresent()){
            throw new NotFoundException("Not Found Basket");
        }
        return basketOptional.get();
    }

    @Override
    public Page<Basket> findAll(Integer page, Integer size) {
        return  repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Page<Basket> findAllByAddressId(Integer page, Integer size, Long addressId) {
        return repository.findAllByAddress_id(PageRequest.of(page,size),addressId);
    }


}
