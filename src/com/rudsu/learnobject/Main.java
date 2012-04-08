/**
 * 
 */
package com.rudsu.learnobject;

import java.util.Iterator;

/**
 * @author User
 *
 */
class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TotalBill customer = new TotalBill();
		//Person person = new Person();
		
		customer.AddPerson("budi");
		customer.AddPerson("koboy");
		customer.AddPerson("cici");
		
		int search_index;
		search_index = customer.search_by_name("koboy");
		
		if (search_index >= 0) {
			customer.list_person.get(search_index).AddBill("fanta", 6000, 10);
			customer.list_person.get(search_index).AddBill("indomie", 8000, 25);
			customer.list_person.get(search_index).AddBill("babi", 5000);
		}
		customer.list_person.get(search_index).setDiscount_per_person(10);
		customer.rename_person("cici", "zelda");
		
		for (Iterator<Person> p = customer.list_person.iterator(); p.hasNext();) {
			Person person1 = p.next();
			System.out.println(person1.getName());
			for (Iterator<Bill> b = person1.list_bill.iterator(); b.hasNext();) {
				Bill bill1 = b.next();
				System.out.print("* " + bill1.getDescription());
				System.out.println(" - Rp. " + String.format("%.2f", bill1.getSubtotal()) + " ,-");
			}
		}
	}

}
