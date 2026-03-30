package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankService;

@Component
public class IBankRunner  implements CommandLineRunner{
	
	@Autowired
	private IBankService bankService;

	@Override
	public void run(String... args) throws Exception {
		
		BankAccount bank=new BankAccount("Randeep","UP",90000.00);
		String msg=bankService.openAccount(bank);
		System.out.println("   ......   You Account is the Open  int Bank   ..."+msg);
		

		
			/*String msg=bankService.wirhDraw(1000000001, 8500);
			System.out.println(msg);
			BankAccount account=bankService.showAccountDetails(1000000001);
			System.out.println(" Account created   "+account.getCreateionTime() +"    .....   Last accesed on   ...  "+account.getLastAccessTime()
			+"     .........   modified for   ::   ......"+account.getUpdationCount()+"       Time   ");
		System.out.println("  Tranjection is the sucessfully is the creating");
		
		
		String msg=bankService.deposite(1000000001, 15003);
		System.out.println(msg);
		BankAccount account=bankService.showAccountDetails(1000000001);
		System.out.println("Account created    "+account.getCreateionTime()+"     Last accessed on   ......"+account.getLastAccessTime()+
				"  ..........   modified for ....."+account.getUpdationCount()+"      Time");
		
		*/
	/*	
		try {
			String msg=bankService.transferMoney(1000000000, 1000000001, 9000);
			System.out.println(msg);
			BankAccount account=bankService.showAccountDetails(1000000001);
			System.out.println(" Account created .....   "+account.getCreateionTime()+"   Last accessed on .............   "+account.getLastAccessTime()
			+" ..........  modified for .........."+account.getUpdationCount()+"   Time");
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
}
	
	

}
