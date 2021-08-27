package eCommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import eCommerce.business.abstracts.CustomerCheckService;
import eCommerce.entities.concretes.Customer;

public class CustomerCheckManager implements CustomerCheckService{

	List<String> eMail = new ArrayList<String>();
	
	@Override
	public boolean checkName(Customer customer) {
		if(customer.getName().isEmpty()) {
			System.out.println("Ad yeri bos b�rak�lamaz ! ");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkSurname(Customer customer) {
		if(customer.getSurname().isEmpty()) {
			System.out.println("Soyad yeri bos b�rak�lamaz ! ");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmail(Customer customer) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		
		if(customer.getEmail().isEmpty()) {
			System.out.println("Email alan� bo� b�rak�lamaz ! ");
			return false;
		}
		else if(pattern.matcher(customer.getEmail()).find() == false) {
			System.out.println("Girdiginiz email adresi yanl�s formatta girilmis. Ornek : ornek@gmail.com");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkPassword(Customer customer) {
		if(customer.getPassword().isEmpty()) {
			System.out.println("Sifre yeri bos b�rak�lamaz ! ");
			
			return false;
	       }
		else if(customer.getPassword().length() < 6) {
			System.out.println("Sifre uzunlugu 6'dan k�sa olamaz ! ");
			return false;
		}
		return true;
		
	}

	@Override
	public boolean uniqueEmail(Customer customer) {
		boolean result = true;
		if(eMail.contains(customer.getEmail()) ) {
			System.out.println("Bu email ile daha �nceden kay�t yap�lm�s ");
			result = false;
		}
		else {
			result = true;
			eMail.add(customer.getEmail());
		}
		return result;
	}

	@Override
	public boolean isValid(Customer customer) {
		
		if(checkName(customer) && checkSurname(customer) && checkEmail(customer) 
				&& checkPassword(customer) && uniqueEmail(customer) == true) {
			return true;
		}
		return false;
	}

}
