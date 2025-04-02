package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.TeacherDto;
import org.example.moreeduceorigin.model.Address;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.model.Teacher;
import org.example.moreeduceorigin.repository.AddressRepo;
import org.example.moreeduceorigin.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepo teacherRepo;
    @Autowired
    AddressRepo addressRepo;

    public List<Teacher>getAllTeachers(){
        return teacherRepo.findAll();
    }

    public Teacher getTeacherById(Long id){
        return teacherRepo.findById(id).get();
    }

    public Result addTeacher(TeacherDto teacherDto){
        boolean exists = teacherRepo.existsByEmailAndUsername(teacherDto.getEmail(), teacherDto.getUsername());
        if(exists){
            return new Result(false , "This email or this username is already in use");
        }
        Teacher teacher = new Teacher();
        teacher.setOriginal_full_name(teacherDto.getOriginal_full_name());
        teacher.setEmail(teacherDto.getEmail());
        teacher.setPhonenumber(teacherDto.getPhonenumber());
        teacher.setUsername(teacherDto.getUsername());
        teacher.setAge(teacherDto.getAge());
        Address address = new Address();
        address.setCity(teacherDto.getCity());
        address.setRegion(teacherDto.getRegion());
        Address save = addressRepo.save(address);
        teacher.setAddress_Id(save);
        teacher.setPassword(teacherDto.getPassword());
        teacher.setRepassword(teacherDto.getRepassword());
        teacher.setFanlar(teacherDto.getFanlar());
        teacherRepo.save(teacher);
        return new Result(true , "Created");
    }

    public Result updateTeacher(TeacherDto teacherDto , Long id){
        Optional<Teacher> byId = teacherRepo.findById(id);
        if (byId.isPresent()) {
            Teacher teacher = byId.get();
            teacher.setOriginal_full_name(teacherDto.getOriginal_full_name());
            teacher.setEmail(teacherDto.getEmail());
            teacher.setPhonenumber(teacherDto.getPhonenumber());
            teacher.setUsername(teacherDto.getUsername());
            teacher.setAge(teacherDto.getAge());
            Optional<Address> byId1 = addressRepo.findById(id);
            Address address = byId1.get();
            address.setCity(teacherDto.getCity());
            address.setRegion(teacherDto.getRegion());
            Address save = addressRepo.save(address);
            teacher.setAddress_Id(save);
            teacher.setPassword(teacherDto.getPassword());
            teacher.setRepassword(teacherDto.getRepassword());
            teacher.setFanlar(teacherDto.getFanlar());
            teacherRepo.save(teacher);
            return new Result(true , "Updated");
        }
            return new Result(false , "Not found");
    }

    public Result deleteTeacher(Long id){
        teacherRepo.deleteById(id);
        return new Result(true , "Deleted");
    }

}
