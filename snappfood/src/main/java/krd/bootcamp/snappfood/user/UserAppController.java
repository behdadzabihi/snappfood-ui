package krd.bootcamp.snappfood.user;

import krd.bootcamp.snappfood.category.Category;
import krd.bootcamp.snappfood.category.CategoryDTO;
import krd.bootcamp.snappfood.common.PagingData;
import krd.bootcamp.snappfood.supplier.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user_app/")
@AllArgsConstructor
public class UserAppController {

    private final UserAppService service;

    private final UserAppMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<UserAppDTO> save(@RequestBody UserAppDTO userAppDTO){
        UserApp userApp=mapper.toUserApp(userAppDTO);
        service.save(userApp);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity<UserAppDTO> update(@RequestBody UserAppDTO userAppDTO){
        UserApp userApp=mapper.toUserApp(userAppDTO);
        service.update(userApp);
        return ResponseEntity.ok(userAppDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/{page}/{size}")
    public ResponseEntity<PagingData<UserAppDTO>> getAll(@PathVariable Integer page, @PathVariable Integer size){
        Page<UserApp> userAppPage=service.findAll(page,size);
        int total=userAppPage.getTotalPages();
        List<UserApp> userApps=userAppPage.getContent();
        List<UserAppDTO> userAppDTOS=mapper.toUserAppDTOs(userApps);
        PagingData<UserAppDTO> userAppDTOPagingData=new PagingData<>(total,page,userAppDTOS);
        return ResponseEntity.ok(userAppDTOPagingData);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<UserAppDTO> getById(@PathVariable Long id){
        UserApp userApp=service.findById(id);
        UserAppDTO userAppDTO=mapper.toUserAppDTO(userApp);
        return ResponseEntity.ok(userAppDTO);
    }

}
