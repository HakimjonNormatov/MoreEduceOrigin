package org.example.moreeduceorigin.repository;

import org.example.moreeduceorigin.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
