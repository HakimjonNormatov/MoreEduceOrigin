package org.example.moreeduceorigin.service;

import org.example.moreeduceorigin.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestRepo testRepo;


}
