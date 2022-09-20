package krd.bootcamp.snappfood.suplier_category;

import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierCategoryService {

    SupplierCategory save(SupplierCategory supplierCategory);

    SupplierCategory update(SupplierCategory supplierCategory);

    void delete(Long id);

    SupplierCategory findById(Long id);

    Page<SupplierCategory> findAll(Integer page,Integer size);

    Page<SupplierCategory> findAllBySupplierId(Integer page,Integer size,Long supplierId);


}
