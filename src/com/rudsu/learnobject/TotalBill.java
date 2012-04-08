package com.rudsu.learnobject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TotalBill {
	private Person person = new Person();
	private float tax = 0;
	private float service_charge = 0;
	private float other_charge = 0;
	private float grand_total = 0;
	private float total = 0;
	private float tax_amount = 0;
	private float service_charge_amount = 0;
	private float other_charge_amount = 0;
	
	public float getTotal() {
		return total;
	}

	public float getGrand_total() {
		return grand_total;
	}

	public float getTax_amount() {
		return tax_amount;
	}

	public float getService_charge_amount() {
		return service_charge_amount;
	}

	public float getOther_charge_amount() {
		return other_charge_amount;
	}

	public List<Person> list_person = new ArrayList<Person>();
	
	private int person_index = 0;
	
	public TotalBill() {
	}
	
	public void AddPerson(String _name) {
		list_person.add(person = new Person(_name));
		DoSort();
	}
	
	public void AddPerson() {
		list_person.add(person = new Person("person_" + person_index));
		person_index += 1;
		DoSort();
	}

	// getter and setter
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getService_charge() {
		return service_charge;
	}

	public void setService_charge(float service_charge) {
		this.service_charge = service_charge;
	}

	public float getOther_charge() {
		return other_charge;
	}

	public void setOther_charge(float other_charge) {
		this.other_charge = other_charge;
	}
	
	public int search_by_name(String _name) {
		Person search_person = new Person();
		
		search_person.setName(_name);
		return Collections.binarySearch(list_person, search_person);
	}
	
	public void rename_person(String _name0, String _name1) {
		int index_person = search_by_name(_name0);
		if (index_person >= 0) {
			list_person.get(index_person).setName(_name1);
			DoSort();
		}
	}
	
	public void calculate_total() {
		
	}
	
	public void DoSort() {
		Collections.sort(list_person);
	}
}
