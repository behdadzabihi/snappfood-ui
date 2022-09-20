package krd.bootcamp.snappfood.item;

import krd.bootcamp.snappfood.common.PagingData;
import krd.bootcamp.snappfood.common.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item/")
@AllArgsConstructor
public class ItemController {

    private final ItemService service;

    private final ItemMapper mapper;


   @PostMapping("/v1")
   public ResponseEntity<ItemDTO> save(@RequestBody ItemDTO itemDTO){
       Item item=mapper.toItem(itemDTO);
       service.save(item);
       return ResponseEntity.status(HttpStatus.CREATED).build();
   }

    @PutMapping("/v1")
    public ResponseEntity<ItemDTO> update(@RequestBody ItemDTO itemDTO){
        Item item=mapper.toItem(itemDTO);
        service.update(item);
        return ResponseEntity.ok(itemDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<ItemDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<Item> itemPage=service.findAll(page,size);
        int total=itemPage.getTotalPages();
        List<Item> items=itemPage.getContent();
        List<ItemDTO> itemDTOS=mapper.toItemsDTOs(items);
        PagingData<ItemDTO> itemDTOPagingData=new PagingData<>(total,page,itemDTOS);
        return ResponseEntity.ok(itemDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<ItemDTO> getById(@PathVariable Long id){
        Item item=service.findById(id);
        ItemDTO itemDTO=mapper.toItemDTO(item);
        return ResponseEntity.ok(itemDTO);
    }

    @GetMapping("/v1/all-by-supplier-category/{page}/{size}/{supplierCategoryId}")
    public ResponseEntity<PagingData<ItemDTO>> getAllBySupplierCategoryId(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Long supplierCategoryId){
        Page<Item> itemPage=service.findAllBySupplierCategoryId(page,size,supplierCategoryId);
        int total=itemPage.getTotalPages();
        List<Item> items=itemPage.getContent();
        List<ItemDTO> itemDTOS=mapper.toItemsDTOs(items);
        PagingData<ItemDTO> itemDTOPagingData=new PagingData<>(total,page,itemDTOS);
        return ResponseEntity.ok(itemDTOPagingData);
    }

    @PostMapping("/v1/filter-by-item/{page}/{size}")
    public ResponseEntity<PagingData<ItemDTO>> searchItem(@RequestBody List<SearchCriteria> searchCriteria,@PathVariable Integer page,@PathVariable Integer size){
       Page<Item> itemPage=service.search(searchCriteria,page,size);
        int total=itemPage.getTotalPages();
        List<Item> items=itemPage.getContent();
        List<ItemDTO> itemDTOS=mapper.toItemsDTOs(items);
        PagingData<ItemDTO> itemDTOPagingData=new PagingData<>(total,page,itemDTOS);
        return ResponseEntity.ok(itemDTOPagingData);
    }

}
