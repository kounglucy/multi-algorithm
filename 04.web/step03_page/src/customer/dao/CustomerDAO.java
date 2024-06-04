package customer.dao;

import java.util.ArrayList;

import customer.dto.Customer;

// service + dao + db
public class CustomerDAO {
	private static CustomerDAO instance = new CustomerDAO();
	public static CustomerDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<Customer> userData = new ArrayList<Customer>();
	
	static {
		userData.add(new Customer("it1", "it1", "S"));
		userData.add(new Customer("it2", "it2", "A"));
		userData.add(new Customer("it3", "it3", "B"));
		userData.add(new Customer("it4", "it4", "C"));
		userData.add(new Customer("it5", "it5", "D"));
	}
	
	public static ArrayList<Customer> getAllData() {
		return userData;
	}
	
	// 고객을 실제로 추가 하는 메소드
	public static void addCustomer(Customer newCustomer) {
		userData.add(newCustomer);
	}
	
	// 고객이 있는지 없는지 확인하는 메소드 
	public static boolean checkCustomer(Customer newCustomer) {
		for ( Customer customer : getAllData()) {
			if(customer.getId().equals(newCustomer.getId())) {
				return true;
			}
		}
		return false;
	}
}