package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.BankAccount;

public interface IBankeRepo extends JpaRepository<BankAccount,Long>{

}
