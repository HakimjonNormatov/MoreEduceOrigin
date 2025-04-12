package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.dto.LoginDto;
import org.example.moreeduceorigin.model.Login;
import org.example.moreeduceorigin.model.Result;
import org.example.moreeduceorigin.repository.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;

    public Result CreateLogin(LoginDto loginDto){
        boolean exists = loginRepo.existsByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (exists){
            Login login = new Login();
            login.setEmail(loginDto.getEmail());
            login.setPassword(loginDto.getPassword());
            loginRepo.save(login);
            return new Result(true , "Qaytganingizdan hursandmiz ! ");
        }
        return new Result(false, "Topilmadi");
    }

}
