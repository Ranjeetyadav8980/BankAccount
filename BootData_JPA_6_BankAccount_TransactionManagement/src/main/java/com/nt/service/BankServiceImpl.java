package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankeRepo;

@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	private IBankeRepo bankRepo;
	@Override
	public String openAccount(BankAccount account) {
			account.setCreateBy(System.getProperty("user.name"));
		long acno=bankRepo.save(account).getAccno();
				return "open your Accoutn  in the Bank ......."+acno;
	}
	//====================  WithDraw   =================================
	/*	@Override
		public String wirhDraw(long acno, double amount) {
			BankAccount bank=bankRepo.findById(acno).orElseThrow(()-> new RuntimeException());
			
			bank.setBalace(bank.getBalace()-amount);
			bank.setUpdateBy(System.getProperty("user.name"));
			bankRepo.save(bank);
			return amount+"  ...  Amount is WithDraw int Bank Account nuber  ..."+acno;
		}*/
	@Override
	public BankAccount showAccountDetails(long acno) {
		BankAccount bank=bankRepo.findById(acno).orElseThrow(()-> new RuntimeException("invalid account "));
		return bank;
	}
	@Override
	public String deposite(long acno, double amount) {
		BankAccount account=bankRepo.findById(acno).orElseThrow(()-> new RuntimeException("invalid account "));
		account.setBalace(account.getBalace()+amount);
		account.setUpdateBy(System.getProperty("user.name"));
		bankRepo.save(account);
		return amount+"amount is the deposit in to the account number  ....."+acno;
	}
	@Override
	//@Transactional(propagation = Propagation.MANDATORY)
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
		//@Transactional(propagation =Propagation.REQUIRED)
	//@Transactional(propagation =Propagation.NESTED)
	//@Transactional(propagation =Propagation.NEVER)
	@Transactional(propagation =Propagation.REQUIRES_NEW)
	public String transferMoney(long srcAcno, long destAcno, double amount) {
	//wirhDraw(srcAcno,amount);
	deposite(destAcno,amount);
		return amount+"amount is transfered from  ..  "+srcAcno +"   ...   to    ......."+destAcno;
	}
}
