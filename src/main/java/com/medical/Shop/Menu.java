package com.medical.Shop;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.medical.Pharmacy.Doctor;
import com.medical.Pharmacy.Medicine;
import com.medical.Pharmacy.PharmacyProperties;

public class Menu {
	public static void showMenu() {
		ApplicationContext context = null;
		Scanner sc = new Scanner(System.in);
		try {
			context = new ClassPathXmlApplicationContext("Spring.xml");
			ShopOperations shopMedicine = context.getBean("shop", ShopOperations.class);
			OrderOperations orderOperations = context.getBean("orderOperations", OrderOperations.class);
			DoctorOperations doctorOp = context.getBean("doctorOp", DoctorOperations.class);
			PharmacyProperties properties = context.getBean("pharmacyProperties", PharmacyProperties.class);

			System.out.println("==================Welcome to Pharmacy Store====================");
			int key = 0;

			do {
				printMenu();
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					shopMedicine.sellMedicine();
					break;
				case 2:
					System.out.println("Enter Medicine name or brand to search in store.");
					String medicine = sc.nextLine();
					List<Medicine> medicineObj = shopMedicine.searchMedicine(medicine);
					if (medicineObj != null) {
						for (Medicine medicin : medicineObj) {
							System.out.println(medicin);
						}
					} else {
						System.out.println("No Medicine Found!");
					}
					break;
				case 3:
					System.out.println("Enter doctor name to search.");
					String doctorName = sc.nextLine();
					List<Doctor> doctors = doctorOp.searchDoctor(doctorName);
					if (doctors != null)
						for (Doctor doctor : doctors)
							System.out.println(doctor);
					break;
				case 4:
					orderOperations.placeOrder();
					break;
				case 5:
					orderOperations.deliveryReport();
					break;
				case 6:
					orderOperations.showPendingOrders();
					break;
				case 7:
					System.out.println(properties);
					break;
				case 8:
					shopMedicine.showAllMedicine();
					break;
				default:
					System.out.println("Plase select correct option");
				}
				System.out.println("Press any number to continue or o for exit from application");
				key = sc.nextInt();
				sc.nextLine();
			} while (key != 0);
			//doctorOp.showAllDoctors();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (context != null)
				((ClassPathXmlApplicationContext) context).close();
			if (sc != null) {
				sc.close();
			}
		}

	}

	private static void printMenu() {
		System.out.println("1.Sell Medicine");
		System.out.println("2.Search Medicine in store");
		System.out.println("3.Search Doctor in store");
		System.out.println("4.Place Order for medicine");
		System.out.println("5.Acknowledge order delivery");
		System.out.println("6.Show pending orders");
		System.out.println("7.Show Pharmacy store details");
		System.out.println("8.Show all medicines in Pharmacy store details");
		System.out.println("Please enter your choice");
	}

}
