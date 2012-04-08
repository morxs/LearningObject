package com.rudsu.learnobject;

public class Bill implements Comparable <Bill> {
	private String description;
	private float amount = 0;
	private float discount = 0;
	private float person_discount = 0;
	private float subtotal = 0;
	
	private static int bill_index = 0;
	
	public Bill() {
	}
	
	public Bill(String _description, float _amount) {
		if (_description != null) {
			setDescription(_description);
		}
		else {
			setDescription("bill" + bill_index);
		}
		
		if (_amount != 0) {
			setAmount(_amount);
		}
		else {
			setAmount(0);
		}

		bill_index += 1;
	}
	
	public Bill(String _description, float _amount, float _discount) {
		if (_description != null) {
			setDescription(_description);
		}
		else {
			setDescription("bill" + bill_index);
		}
		
		if (_amount != 0) {
			setAmount(_amount);
		}
		else {
			setAmount(0);
		}
		
		if (_discount != 0) {
			setDiscount(_discount);
		}
		else {
			setDiscount(0);
		}

		bill_index += 1;
	}
	
	// getter and setter
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
		calculate_subtotal();
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
		calculate_subtotal();
	}


	public void setPerson_discount(float person_discount) {
		this.person_discount = person_discount;
		calculate_subtotal();
	}
	
	public float getSubtotal() {
		return subtotal;
	}

	public void calculate_subtotal() {
		subtotal = amount * (1 - (discount / 100));
		subtotal = subtotal * (1 - (person_discount / 100));
	}
	
	@Override
	public int compareTo(Bill o) {
		if (this.description.compareTo(o.description) < 0)
			return -1;
		else
			if (this.description.compareTo(o.description) == 0)
				return 0;
			else
				return 1;
	}
}