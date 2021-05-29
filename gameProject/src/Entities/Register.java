package Entities;

import Abstract.RegisterService;

public class Register implements RegisterService{

	@Override
	public void register(Gamer gamer) {
		System.out.println("Kay�t yap�ld� : " + gamer.getfirstName());
		
	}
	public void update()
	{
		System.out.println("Bilgiler g�ncellendi");
	}
	
	public void delete()
	{
		System.out.println("Kay�t silindi");
	}
 
}
