package org.example.moreeduceorigin.controller;

import org.example.moreeduceorigin.dto.AddressDto;
import org.example.moreeduceorigin.model.Address;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address>getAll(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    public HttpEntity<?>add(@RequestBody AddressDto addressDto){
        Result result = addressService.addAddress(addressDto);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public HttpEntity<?>put(@RequestBody AddressDto addressDto , @PathVariable Long id){
        Result result = addressService.updateAddress(addressDto, id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?>delete(@PathVariable Long id){
        Result result = addressService.deleteAddress(id);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

}
