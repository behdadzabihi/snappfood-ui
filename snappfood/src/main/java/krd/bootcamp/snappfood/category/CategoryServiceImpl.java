package krd.bootcamp.snappfood.category;

import krd.bootcamp.snappfood.basket.Basket;
import krd.bootcamp.snappfood.basket.BasketRepository;
import krd.bootcamp.snappfood.basket.BasketService;
import krd.bootcamp.snappfood.common.exception.NotFoundException;
import krd.bootcamp.snappfood.suplier_category.SupplierCategory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category lastCategory=findById(category.getId());
        lastCategory.setLogo(category.getLogo());
        lastCategory.setTitle(category.getTitle());
        return repository.save(lastCategory);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional=repository.findById(id);
        if(!categoryOptional.isPresent()){
            throw new NotFoundException("Not Found Category");
        }
        return categoryOptional.get();
    }

    @Override
    public Page<Category> findAll(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page,size));
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) repository.findAll();
    }
}
