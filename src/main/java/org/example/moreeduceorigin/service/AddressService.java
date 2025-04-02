package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.AddressDto;
import org.example.moreeduceorigin.model.Address;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;


    public List<Address>getAllAddresses(){
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id){
        return addressRepo.findById(id).get();
    }

    public Result addAddress(AddressDto addressDto){
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setRegion(addressDto.getRegion());
        addressRepo.save(address);
        return new Result(true , "Created");
    }

    public Result updateAddress(AddressDto addressDto , Long id){
        Optional<Address> byId = addressRepo.findById(id);
        Address address = byId.get();
        address.setCity(addressDto.getCity());
        address.setRegion(addressDto.getRegion());
        addressRepo.save(address);
        return new Result(true , "Updated");
    }

    public Result deleteAddress(Long id){
        addressRepo.deleteById(id);
        return new Result(true , "Deleted");
    }

}
