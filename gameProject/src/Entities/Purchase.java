package Entities;

import Abstract.PurchaseService;

public class Purchase  implements PurchaseService {

	Game game;
	
	double campaign;
	double remainder;
	
	@Override
	public void Information(Game game,Campaign campaign2) {
		campaign = game.getPrice() - (campaign2.getDiscount()/100) * game.getPrice();
		System.out.println("Kampanya ad� : "+campaign2.getCampaignName());
		System.out.println(game.getGameName() +"Oyununun indirimden �nceki fiyat� : "+game.getPrice());
		System.out.println("Oyunun kampanyal� fiyat� : "+campaign);
	}
	
	
	@Override
	public void Buy(Gamer gamer) {
		remainder = gamer.getRemainder() - campaign;
		System.out.println("Oyun sat�n al�nd�. Kalan bakiyeniz :  "+remainder);
		
	}
	
}
