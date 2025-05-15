package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.TestDto;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Test;
import org.example.moreeduceorigin.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {

    @Autowired
    TestRepo testRepo;

    public List<Test> getAll(){
        return testRepo.findAll();
    }

    public Test getById(Long id){
        return testRepo.findById(id).get();
    }
    public Result create(TestDto testDto){
        Test test = new Test();
        test.setName(testDto.getName());
        test.setStatus(testDto.getStatus());
        test.setDescription(testDto.getDescription());
        testRepo.save(test);
        return  new Result( true , "Success");
    }
    public Result update(Long id , TestDto testDto){
        Optional<Test> byId = testRepo.findById(id);
        Test test = byId.get();
        test.setName(testDto.getName());
        test.setStatus(testDto.getStatus());
        test.setDescription(testDto.getDescription());
        testRepo.save(test);
        return  new Result( true , "Success");
    }
    public Result delete(Long id){
        testRepo.deleteById(id);
        return  new Result( true , "Success");
    }
}
