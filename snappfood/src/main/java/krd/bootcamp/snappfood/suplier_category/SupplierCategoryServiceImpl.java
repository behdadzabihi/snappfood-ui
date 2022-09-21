package krd.bootcamp.snappfood.suplier_category;

import krd.bootcamp.snappfood.common.exception.NotFoundException;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SupplierCategoryServiceImpl implements SupplierCategoryService {

    private final SupplierCategoryRepository repository;

    private final SupplierService supplierService;

    @Override
    public SupplierCategory save(SupplierCategory supplierCategory) {
        Long suppId=supplierCategory.getSupplier().getId();
        Supplier supplier=supplierService.findById(suppId);
        supplierCategory.setSupplier(supplier);
        return repository.save(supplierCategory);
    }

    @Override
    public SupplierCategory update(SupplierCategory supplierCategory) {
        SupplierCategory lastSupplierCategory=findById(supplierCategory.getId());
        lastSupplierCategory.setTitle(supplierCategory.getTitle());
        Supplier supplier=supplierService.findById(supplierCategory.getSupplier().getId());
        lastSupplierCategory.setSupplier(supplier);
        return repository.save(lastSupplierCategory);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public SupplierCategory findById(Long id) {
        Optional<SupplierCategory> supplierCategoryOptional=repository.findById(id);
        if(!supplierCategoryOptional.isPresent()){
            throw new NotFoundException("Not Found Supplier");
        }
        return supplierCategoryOptional.get();
    }

    @Override
    public Page<SupplierCategory> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public Page<SupplierCategory> findAllBySupplierId(Integer page, Integer size, Long supplierId) {
        return repository.findAllBySupplier_Id(PageRequest.of(page,size),supplierId);
    }



}
