package krd.bootcamp.snappfood.supplier;

import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.category.CategoryDTO;
import krd.bootcamp.snappfood.common.PagingData;
import krd.bootcamp.snappfood.common.SearchCriteria;
import krd.bootcamp.snappfood.item.Item;
import krd.bootcamp.snappfood.item.ItemDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier/")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService service;

    private final SupplierMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity<SupplierDTO> save(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier=mapper.toSupplier(supplierDTO);
        service.save(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<SupplierDTO> update(@RequestBody SupplierDTO supplierDTO){
        Supplier supplier=mapper.toSupplier(supplierDTO);
        service.update(supplier);
        return ResponseEntity.ok(supplierDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<SupplierDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Supplier> supplierPage=service.findAll(page,size);
        int total=supplierPage.getTotalPages();
        List<Supplier> suppliers=supplierPage.getContent();
        List<SupplierDTO> supplierDTOS=mapper.toSupplierDTOs(suppliers);
        PagingData<SupplierDTO> supplierDTOPagingData=new PagingData<>(total,page,supplierDTOS);
        return ResponseEntity.ok(supplierDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<SupplierDTO> getById(@PathVariable Long id){
        Supplier supplier=service.findById(id);
        SupplierDTO supplierDTO=mapper.toSupplierDTO(supplier);
        return ResponseEntity.ok(supplierDTO);
    }

    @GetMapping("/v1/all-by-category-title/{page}/{size}/{title}")
    public ResponseEntity<PagingData<SupplierDTO>> getAllByCategoryTitle(@PathVariable Integer page, @PathVariable Integer size,@PathVariable String title){
        Page<Supplier> supplierPage=service.findAllBySupplierTitle(page,size,title);
        int total=supplierPage.getTotalPages();
        List<Supplier> suppliers=supplierPage.getContent();
        List<SupplierDTO> supplierDTOS=mapper.toSupplierDTOs(suppliers);
        PagingData<SupplierDTO> supplierDTOPagingData=new PagingData<>(total,page,supplierDTOS);
        return ResponseEntity.ok(supplierDTOPagingData);
    }

    @PostMapping("/v1/filter-by-serach/{page}/{size}")
    public ResponseEntity<PagingData<SupplierDTO>> searchItem(@RequestBody List<SearchCriteria> searchCriteria, @PathVariable Integer page, @PathVariable Integer size){
        Page<Supplier> supplierPage=service.search(searchCriteria,page,size);
        int total=supplierPage.getTotalPages();
        List<Supplier> suppliers=supplierPage.getContent();
        List<SupplierDTO> supplierDTOS=mapper.toSupplierDTOs(suppliers);
        PagingData<SupplierDTO> supplierDTOPagingData=new PagingData<>(total,page,supplierDTOS);
        return ResponseEntity.ok(supplierDTOPagingData);
    }
}
