package krd.bootcamp.snappfood.supplier;

import krd.bootcamp.snappfood.common.SearchCriteria;
import krd.bootcamp.snappfood.item.Item;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SupplierService {

    Supplier save(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(Long id);

    Supplier findById(Long id);

    Page<Supplier> findAll(Integer page,Integer size);

    Page<Supplier> findAllBySupplierTitle(Integer page, Integer size, String title);

    Page<Supplier> search(List<SearchCriteria> searchCriteria, Integer page, Integer size);

}
