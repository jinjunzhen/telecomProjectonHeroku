package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.beans.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
}