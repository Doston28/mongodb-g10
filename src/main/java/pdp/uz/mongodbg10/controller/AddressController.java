package pdp.uz.mongodbg10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.mongodbg10.AddressDto;
import pdp.uz.mongodbg10.model.Address;
import pdp.uz.mongodbg10.repository.AddressRepository;
import pdp.uz.mongodbg10.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public HttpEntity<?> getDistricts(){
        List<Address> addresses = addressService.getAddresses();
        return ResponseEntity.ok(addresses);
    }

    @PostMapping
    public HttpEntity<?> addDistrict(@RequestBody AddressDto addressDto){
        Address addAddress = addressService.addAddress(addressDto);
        return ResponseEntity.ok(addAddress);
    }
}
