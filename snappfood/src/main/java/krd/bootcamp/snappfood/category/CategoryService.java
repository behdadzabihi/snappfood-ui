package krd.bootcamp.snappfood.category;

import krd.bootcamp.snappfood.basket.Basket;
import krd.bootcamp.snappfood.suplier_category.SupplierCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    Category update(Category category);

    void delete(Long id);

    Category findById(Long id);

    Page<Category> findAll(Integer page,Integer size);

    List<Category> getAll();
}
