package com.example.demo.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.Account;
import com.example.demo.beans.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>{

	Optional<Phone> findByPhoneNumber(String phoneNumber);

}
