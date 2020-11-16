package by.epam_tc.oop_basics.payment.entity;

import java.io.Serializable;
import java.util.*;

public class Buyer implements Serializable{
	
	private static final long serialVersionUID = -6662234087960469100L;
	private double balance;
	private String name;
	private List<Payment> payments;

	{
		payments = new ArrayList<Payment>();
	}

	public Buyer(double balance, String name) {
		super();
		this.balance = balance;
		this.name = name;
	}
	
	public Buyer() {
		this(0,"");
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Payment> getPurchases() {
		return payments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((payments == null) ? 0 : payments.hashCode());
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
		Buyer other = (Buyer) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (payments == null) {
			if (other.payments != null)
				return false;
		} else if (!payments.equals(other.payments))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Buyer [balance=" + balance + ", name=" + name + "]";
	}
}
