package krd.bootcamp.snappfood.supplier;

import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.category.CategoryService;
import krd.bootcamp.snappfood.common.SearchCriteria;
import krd.bootcamp.snappfood.common.exception.NotFoundException;
import krd.bootcamp.snappfood.item.ItemSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository repository;

    private final CategoryService categoryService;

    @Override
    public Supplier save(Supplier supplier) {
        Long catId=supplier.getCategory().getId();
        Category category=categoryService.findById(catId);
        supplier.setCategory(category);
        return repository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        Supplier lastSupplier=findById(supplier.getId());
        lastSupplier.setName(supplier.getName());
        lastSupplier.setLogo(supplier.getLogo());
        lastSupplier.setUsername(supplier.getUsername());
        lastSupplier.setPassword(supplier.getPassword());
        lastSupplier.setDeliveryPrice(supplier.getDeliveryPrice());
        lastSupplier.setLocation(supplier.getLocation());
        Category category=categoryService.findById(supplier.getCategory().getId());
        lastSupplier.setCategory(category);
        return repository.save(lastSupplier);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Supplier findById(Long id) {
        Optional<Supplier> ProductItemService=repository.findById(id);
        if(!ProductItemService.isPresent()){
            throw new NotFoundException("Not Found Supplier");
        }
        return ProductItemService.get();
    }

    @Override
    public Page<Supplier> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Page<Supplier> findAllBySupplierTitle(Integer page, Integer size, String title) {
        return repository.findAllByCategoryTitle(PageRequest.of(page,size),title);
    }

    @Override
    public Page<Supplier> search(List<SearchCriteria> searchCriteria, Integer page, Integer size) {
        SupplierSpecification supplierSpecification=new SupplierSpecification();
        searchCriteria.forEach(searchCriteria1 -> supplierSpecification.add(searchCriteria1));
        return repository.findAll(supplierSpecification,PageRequest.of(page,size));
    }


}
