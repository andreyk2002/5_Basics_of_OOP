package by.epam_tc.oop_basics.payment.main;

import by.epam_tc.oop_basics.payment.entity.Buyer;
import by.epam_tc.oop_basics.payment.entity.Payment;
import by.epam_tc.oop_basics.payment.logic.PaymentLogic;
import by.epam_tc.oop_basics.payment.view.PaymentView;

public class PaymentMain {

	public static void main(String... argc) {
		Buyer boris = new Buyer(100, "Boris");
		Payment guitarStuff = new Payment();

		PaymentLogic paymentsLogic = PaymentLogic.getInstance();
		PaymentView view = new PaymentView();

		paymentsLogic.addItem(guitarStuff, new Payment.PayItem(180, "Classic guitar"));
		paymentsLogic.addItem(guitarStuff, 5.50, "Guitar strings");

		view.buyAndShow(paymentsLogic::buy, guitarStuff, boris);
		view.showBuyerInfo(boris);
		boris.setBalance(250);
		view.buyAndShow(paymentsLogic::buy, guitarStuff, boris);
		view.showBuyerInfo(boris);

		Payment mobileAccessories = new Payment();
		paymentsLogic.addItem(mobileAccessories, 45.5, "Wireless headphones");
		paymentsLogic.addItem(mobileAccessories, 3.0, "USB-C charger");
		paymentsLogic.addItem(mobileAccessories, 4.5, "Protective case");
		view.buyAndShow(paymentsLogic::buy,mobileAccessories, boris);
		view.showBuyerInfo(boris);

	}
}
