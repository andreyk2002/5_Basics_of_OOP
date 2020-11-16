package by.epam_tc.oop_basics.payment.logic;

import by.epam_tc.oop_basics.payment.entity.Buyer;
import by.epam_tc.oop_basics.payment.entity.Payment;

public class PaymentLogic {

	private static PaymentLogic instance = null;

	private PaymentLogic() {
	}

	public static PaymentLogic getInstance() {
		if (instance == null) {
			instance = new PaymentLogic();
		}
		return instance;
	}

	public void addItem(Payment payment, Payment.PayItem item) {
		payment.getPurchases().add(item);
	}

	public void addItem(Payment payment, double itemPrice, String itemName) {
		Payment.PayItem item = new Payment.PayItem(itemPrice, itemName);
		payment.getPurchases().add(item);
	}

	public void removeItem(Payment payment, Payment.PayItem item) {
		payment.getPurchases().remove(item);
	}

	public boolean buy(Payment payment, Buyer b) {
		if (b.getBalance() < payment.getTotalPrice()) {
			return false;
		}
		double newBalance = b.getBalance() - payment.getTotalPrice();
		
		b.setBalance(newBalance);
		b.getPurchases().add(payment);
		return true;
	}

	public static double countPrice(Payment p) {
		double totalPrice = 0;
		for (var item : p.getPurchases()) {
			totalPrice += item.getPrice();
		}
		return totalPrice;
	}

	public String getItemsList(Payment p) {
		StringBuilder strB = new StringBuilder();
		for (var item : p.getPurchases()) {
			strB.append(item.getName() + "; " + "cost : " + item.getPrice() + '\n');
		}
		return strB.toString();
	}

}
