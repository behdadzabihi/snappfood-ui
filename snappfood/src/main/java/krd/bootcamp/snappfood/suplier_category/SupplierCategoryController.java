package krd.bootcamp.snappfood.suplier_category;

import krd.bootcamp.snappfood.common.PagingData;
import krd.bootcamp.snappfood.supplier.Supplier;
import krd.bootcamp.snappfood.supplier.SupplierDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/supplier_category")
@AllArgsConstructor
public class SupplierCategoryController {

    private final SupplierCategoryService service;

    private final SupplierCategoryMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<SupplierCategoryDTO> save(@RequestBody SupplierCategoryDTO supplierCategoryDTO){
        SupplierCategory supplierCategory=mapper.toSupplierCategory(supplierCategoryDTO);
        service.save(supplierCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<SupplierCategoryDTO> update(@RequestBody SupplierCategoryDTO supplierCategoryDTO){
        SupplierCategory supplierCategory=mapper.toSupplierCategory(supplierCategoryDTO);
        service.update(supplierCategory);
        return ResponseEntity.ok(supplierCategoryDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<SupplierCategoryDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<SupplierCategory> supplierCategoryPage=service.findAll(page,size);
        int total=supplierCategoryPage.getTotalPages();
        List<SupplierCategory> supplierCategories=supplierCategoryPage.getContent();
        List<SupplierCategoryDTO> supplierCategoryDTOS=mapper.toSupplierCategoryDTOs(supplierCategories);
        PagingData<SupplierCategoryDTO> supplierCategoryDTOPagingData=new PagingData<>(total,page,supplierCategoryDTOS);
        return ResponseEntity.ok(supplierCategoryDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<SupplierCategoryDTO> getById(@PathVariable Long id){
        SupplierCategory supplierCategory=service.findById(id);
        SupplierCategoryDTO supplierCategoryDTO=mapper.toSupplierCategoryDTO(supplierCategory);
        return ResponseEntity.ok(supplierCategoryDTO);
    }

    @GetMapping("/v1/all-by-supplier/{page}/{size}/{id}")
    public ResponseEntity<PagingData<SupplierCategoryDTO>> getAllBySupplierId(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long id){
        Page<SupplierCategory> supplierCategoryPage=service.findAllBySupplierId(page,size,id);
        int total=supplierCategoryPage.getTotalPages();
        List<SupplierCategory> supplierCategories=supplierCategoryPage.getContent();
        List<SupplierCategoryDTO> supplierCategoryDTOS=mapper.toSupplierCategoryDTOs(supplierCategories);
        PagingData<SupplierCategoryDTO> supplierCategoryDTOPagingData=new PagingData<>(total,page,supplierCategoryDTOS);
        return ResponseEntity.ok(supplierCategoryDTOPagingData);
    }


}
