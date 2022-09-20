package krd.bootcamp.snappfood.item;

import krd.bootcamp.snappfood.common.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ItemService {

    Item save(Item item);

    Item update(Item item);

    void delete(Long id);

    Item findById(Long id);

    Page<Item> findAllBySupplierCategoryId(Integer page, Integer size, Long supplierCategoryId);

    Page<Item> search(List<SearchCriteria> searchCriteria,Integer page, Integer size);

    Page<Item> findAll(Integer page, Integer size);
}
