package by.epam_tc.oop_basics.payment.view;

import by.epam_tc.oop_basics.payment.entity.*;
import by.epam_tc.oop_basics.payment.logic.*;

public class PaymentView {

	private PaymentLogic logic = PaymentLogic.getInstance();
	
	public void showBuyerInfo(Buyer b) {
		System.out.println("Balance : " + b.getBalance());
		
		if(b.getPurchases().isEmpty()) {
			System.out.println("Items list is empty now.");
			return;
		}
		System.out.println("payments : ");
		for (var el : b.getPurchases()) {
			System.out.println(logic.getItemsList(el));
			System.out.println();
		}
	}
	
	//я знаю, что создавать такие методы не совсем правильно, однако, думаю, здесь это всё же допустимо для большей наглядности
	public void buyAndShow(BuyFunc bf, Payment p, Buyer b) {
		if(!bf.buy(p, b)) {
			System.out.print("The client " + b.getName());
			System.out.println(" does not have enough funds. The payment is canceled\n");
		}else {
			System.out.print("Payment was successful : ");
			System.out.println(p.getTotalPrice() + " dollars were debited from the " + b.getName() + "'s card");
		}
	}
}
