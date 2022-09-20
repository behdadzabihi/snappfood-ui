package krd.bootcamp.snappfood.address;

import krd.bootcamp.snappfood.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address/")
@AllArgsConstructor
public class AddressController {

    private final AddressService service;

    private final AddressMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO addressDTO){
        Address address=mapper.toAddress(addressDTO);
        service.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/all/{page}/{size}")
    public ResponseEntity<PagingData<AddressDTO>> getAll(@PathVariable Integer page,@PathVariable Integer size){
        Page<Address> addressPage=service.findAll(page,size);
        int total=addressPage.getTotalPages();
        List<Address> addresses=addressPage.getContent();
        List<AddressDTO> addressDTOS=mapper.toAddressDTOS(addresses);
        PagingData<AddressDTO> addressDTOPagingData=new PagingData<>(page,total,addressDTOS);
        return ResponseEntity.ok(addressDTOPagingData);
    }

    @GetMapping("/v1/all-by-user/{page}/{size}/{userId}")
    public ResponseEntity<PagingData<AddressDTO>> getAllByUser(@PathVariable Integer page,@PathVariable Integer size,@PathVariable Long userId){
        Page<Address> addressPage=service.findAllByUserAppId(page,size, userId);
        int total=addressPage.getTotalPages();
        List<Address> addresses=addressPage.getContent();
        List<AddressDTO> addressDTOS=mapper.toAddressDTOS(addresses);
        PagingData<AddressDTO> addressDTOPagingData=new PagingData<>(page,total,addressDTOS);
        return ResponseEntity.ok(addressDTOPagingData);
    }

    @PutMapping("/v1")
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO){
        Address address=mapper.toAddress(addressDTO);
        service.update(address);
        return ResponseEntity.ok(addressDTO);
    }

    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
