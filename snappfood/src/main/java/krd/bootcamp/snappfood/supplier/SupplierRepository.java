package krd.bootcamp.snappfood.supplier;

import krd.bootcamp.snappfood.item.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends PagingAndSortingRepository<Supplier,Long>, JpaSpecificationExecutor<Supplier> {

    Page<Supplier> findAllByCategoryTitle(Pageable pageable,String title);

    Page<Supplier> findAll(Pageable pageable);

    Page<Supplier> findAll(Specification<Supplier> specification, Pageable pageable);

}
