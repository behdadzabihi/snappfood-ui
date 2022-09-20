package krd.bootcamp.snappfood.category;

import krd.bootcamp.snappfood.basket.BasketService;
import krd.bootcamp.snappfood.common.PagingData;
import krd.bootcamp.snappfood.suplier_category.SupplierCategory;
import krd.bootcamp.snappfood.suplier_category.SupplierCategoryDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category/")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;

    private final CategoryMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO){
        Category category=mapper.toCategory(categoryDTO);
        service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO){
        Category category=mapper.toCategory(categoryDTO);
        service.update(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<CategoryDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Category> categoryPage=service.findAll(page,size);
        int total=categoryPage.getTotalPages();
        List<Category> categories=categoryPage.getContent();
        List<CategoryDTO> categoryDTOS=mapper.toCategoryDTOs(categories);
        PagingData<CategoryDTO> categoryDTOPagingData=new PagingData<>(total,page,categoryDTOS);
        return ResponseEntity.ok(categoryDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id){
        Category category=service.findById(id);
        CategoryDTO categoryDTO=mapper.toCategoryDTo(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("v1")
    public ResponseEntity<List<CategoryDTO>> getAll(){
        List<Category> categories=service.getAll();
        List<CategoryDTO> categoryDTOS=mapper.toCategoryDTOs(categories);
        return ResponseEntity.ok(categoryDTOS);
    }
}
