package by.epam_tc.oop_basics.payment.entity;

import java.io.Serializable;
import java.util.*;

import by.epam_tc.oop_basics.payment.logic.PaymentLogic;

public class Payment implements Serializable {

	private static final long serialVersionUID = -6477879453285071519L;
	private List<PayItem> purchases = new ArrayList<PayItem>();

	public static class PayItem implements Serializable {
		
		private static final long serialVersionUID = 4375886674534269379L;
		private double price;
		private String name;

		public PayItem(double price, String name) {
			super();
			this.price = price;
			this.name = name;
		}
		
		public PayItem() {
			this(0, "");
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			PayItem other = (PayItem) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "PayItem [price=" + price + ", name=" + name + "]";
		}
	}

	public Payment() {

	}

	public Payment(PayItem... items) {
		for (var item : items) {
			purchases.add(item);
		}
	}

	public List<PayItem> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<PayItem> purchases) {
		this.purchases = purchases;
	}

	public double getTotalPrice() {
		return PaymentLogic.countPrice(this);
	}

	@Override
	public String toString() {
		return "Payment [purchases=" + purchases + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((purchases == null) ? 0 : purchases.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (purchases == null) {
			if (other.purchases != null)
				return false;
		} else if (!purchases.equals(other.purchases))
			return false;
		return true;
	}

}
