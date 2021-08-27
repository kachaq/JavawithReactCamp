package eCommerce.business.concretes;

import eCommerce.business.abstracts.CustomerCheckService;
import eCommerce.business.abstracts.CustomerService;
import eCommerce.business.abstracts.VerificationService;
import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.entities.concretes.Customer;

public class CustomerManager implements CustomerService{

	CustomerCheckService checkService;
	VerificationService verificationService;
	CustomerDao customerDao;
	
	public CustomerManager(CustomerCheckService checkService,
			VerificationService verificationService, CustomerDao customerDao) {
		this.checkService = checkService;
		this.customerDao = customerDao;
		this.verificationService = verificationService;

	}

	@Override
	public void s�gnIn(Customer customer) {
		
		verificationService.verifyMail(customer.getEmail());
		
		if(customerDao.getEmail(customer.getEmail()) && 
				customerDao.getPassword(customer.getPassword()) &&
				 verificationService.checkVerifyAccount(customer.getEmail() ) == true) {
				
				System.out.println("Basarili bir sekilde giris yapildi. Hosgeldin :"+customer.getName() + customer.getSurname());
		}
		else if(verificationService.checkVerifyAccount(customer.getEmail()) == false) {
			System.out.println("Kullan�c� bilgileri dogru fakat email dogrulamas� yapilmamis ! ");
		}
		else {
			System.out.println("Girdiginiz bilgilerden baz�lar� yanl�s, lutfen kontrol ediniz ! ");
		}
		
	}

	@Override
	public void s�gnUp(Customer customer) {
		if(checkService.isValid(customer) == true) {
			System.out.println("Basarili bir sekilde kay�t olundu : "+customer.getName() +customer.getSurname());
			verificationService.sendToVerifyMail(customer.getEmail());
			customerDao.add(customer);
		}
		
		
	}

	
	


	
}
