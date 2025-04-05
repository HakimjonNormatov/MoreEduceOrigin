package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.StudentDto;
import org.example.moreeduceorigin.model.Address;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Students;
import org.example.moreeduceorigin.repository.AddressRepo;
import org.example.moreeduceorigin.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    AddressRepo addressRepo;

    public List<Students>getAllStudents(){
        return studentRepo.findAll();
    }

    public Students getById(Long id){
        return studentRepo.findById(id).get();
    }

    public Result createStudent(StudentDto studentDto){

        boolean exists = studentRepo.existsByEmailAndUsername(studentDto.getEmail(), studentDto.getUsername());
        if (exists){
            return new Result(false , "This email or username already existed");
        }
        Students students = new Students();
        students.setEmail(studentDto.getEmail());
        students.setUsername(studentDto.getUsername());
        students.setAge(studentDto.getAge());
        students.setPhonenumber(studentDto.getPhonenumber());
        students.setPassword(studentDto.getPassword());
        students.setRepassword(studentDto.getRepassword());
        Address address = new Address();
        address.setCity(studentDto.getCity());
        address.setRegion(studentDto.getRegion());
        Address save = addressRepo.save(address);
        students.setAddress_id(save);
        studentRepo.save(students);
        return new Result(true , "Created");
    }

    public Result updateStudent(Long id , StudentDto studentDto){
        Optional<Students> byId = studentRepo.findById(id);
        if (byId.isPresent()){
            Students students = new Students();
            students.setEmail(studentDto.getEmail());
            students.setUsername(studentDto.getUsername());
            students.setAge(studentDto.getAge());
            students.setPhonenumber(studentDto.getPhonenumber());
            students.setPassword(studentDto.getPassword());
            students.setRepassword(studentDto.getRepassword());
            Optional<Address> byId1 = addressRepo.findById(studentDto.getAddress_id());
            Address address = byId1.get();
            address.setCity(studentDto.getCity());
            address.setRegion(studentDto.getRegion());
            Address save = addressRepo.save(address);
            students.setAddress_id(save);
            studentRepo.save(students);
            return new Result(true , "Updated");
        }
        return new Result(false , "Not found");
    }

    public Result deleteStudent(Long id){
        studentRepo.deleteById(id);
        return new Result(true , "Deleted");
    }

}
