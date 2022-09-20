package krd.bootcamp.snappfood.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ItemRepository extends PagingAndSortingRepository<Item,Long>, JpaSpecificationExecutor<Item> {

    Page<Item> findAllBySupplierCategory_Id(Pageable pageable,Long supplierCategoryId);

    Page<Item> findAll(Pageable pageable);

    Page<Item> findAll(Specification<Item> specification, Pageable pageable);
}
