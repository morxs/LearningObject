package com.rudsu.learnobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Person implements Comparable <Person> {
	private String name;
	private String email;
	private Bill bill = new Bill();
	private float discount_per_person = 0;
	
	private static int person_index = 0;
	
	public List<Bill> list_bill = new ArrayList<Bill>();
	
	public Person() {
	}
	
	public Person(String _name) {
		if (_name != null) {
			setName(_name);
		}
		else {
			setName("person" + person_index);
		}
		person_index += 1;
	}
	


	public Person(String _name, String _email, float _discount) {
		if (_name != null) {
			setName(_name);
		}
		if (_email != null) {
			setEmail(_email);
		}
		if (_discount != 0f) {
			setDiscount_per_person(_discount);
		}
		person_index += 1;
	}
	
	public void AddBill() {
		list_bill.add(bill = new Bill());
		DoSort();
	}
	
	public void AddBill(String _description, float _amount) {
		list_bill.add(bill = new Bill(_description, _amount));
		DoSort();
	}
	
	public void AddBill(String _description, float _amount, float _discount) {
		list_bill.add(bill = new Bill(_description, _amount, _discount));
		DoSort();
	}
	
	// getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public float getDiscount_per_person() {
		return discount_per_person;
	}

	public void setDiscount_per_person(float discount_per_person) {
		this.discount_per_person = discount_per_person;
		
		for (Iterator<Bill> b = list_bill.iterator(); b.hasNext();) {
			Bill bill1 = b.next();
			bill1.setPerson_discount(discount_per_person);
		}
	}

	
	private void DoSort() {
		Collections.sort(list_bill);
	}
	
	@Override
	public int compareTo(Person o) {
		if (this.name.compareTo(o.name) < 0)
			return -1;
		else
			if (this.name.compareTo(o.name) == 0)
				return 0;
			else
				return 1;
	}
}
