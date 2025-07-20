package application;

import java.util.*;

import model.CleaningStaff;
import model.Doctor;
import model.Nurse;
import model.Patient;
import model.Receptionist;

public class Main {
	private static List<Patient> patients = new ArrayList<>();
	private static List<Doctor> doctors = new ArrayList<>();
	private static List<Nurse> nurses = new ArrayList<>();
	private static List<Receptionist> receptionists = new ArrayList<>();
	private static List<CleaningStaff> cleaningStaff = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;

		do {
			System.out.println("\n=== MENU ===");
			System.out.println("1. Register Patient");
			System.out.println("2. Register Doctor");
			System.out.println("3. Register Nurse");
			System.out.println("4. Register Receptionist");
			System.out.println("5. Register Cleaning Staff");
			System.out.println("6. List Patients");
			System.out.println("7. List Doctors");
			System.out.println("8. List Nurses");
			System.out.println("9. List Receptionists");
			System.out.println("10. List Cleaning Staff");
			System.out.println("0. Exit");
			System.out.print("Option: ");
			option = sc.nextInt();
			sc.nextLine();

			switch (option) {
			case 1 -> {
				System.out.print("ID: ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Phone: ");
				String phone = sc.nextLine();
				System.out.print("Health Plan ID: ");
				String healthPlanId = sc.nextLine();
				Patient p = new Patient(name, phone, id, healthPlanId);
				patients.add(p);
				System.out.println("Patient registered.");
			}
			case 2 -> {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Phone: ");
				String phone = sc.nextLine();
				System.out.print("Credential: ");
				String credential = sc.nextLine();
				System.out.print("CRM: ");
				String crm = sc.nextLine();
				System.out.print("Specialty: ");
				String specialty = sc.nextLine();
				doctors.add(new Doctor(name, phone, credential, crm, specialty));
			}
			case 3 -> {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Phone: ");
				String phone = sc.nextLine();
				System.out.print("Credential: ");
				String credential = sc.nextLine();
				nurses.add(new Nurse(name, phone, credential));
			}
			case 4 -> {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Phone: ");
				String phone = sc.nextLine();
				System.out.print("Credential: ");
				String credential = sc.nextLine();
				receptionists.add(new Receptionist(name, phone, credential));
			}
			case 5 -> {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Phone: ");
				String phone = sc.nextLine();
				System.out.print("Credential: ");
				String credential = sc.nextLine();
				cleaningStaff.add(new CleaningStaff(name, phone, credential));
			}
			case 6 -> {
				if (patients.isEmpty()) {
					System.out.println("No patients registered.");
				} else {
					patients.forEach(System.out::println);
				}
			}
			case 7 -> {
				if (doctors.isEmpty()) {
					System.out.println("No doctors registered.");
				} else {
					doctors.forEach(System.out::println);
				}
			}
			case 8 -> {
				if (nurses.isEmpty()) {
					System.out.println("No nurses registered.");
				} else {
					nurses.forEach(System.out::println);
				}
			}
			case 9 -> {
				if (receptionists.isEmpty()) {
					System.out.println("No receptionists registered.");
				} else {
					receptionists.forEach(System.out::println);
				}
			}
			case 10 -> {
				if (cleaningStaff.isEmpty()) {
					System.out.println("No cleaning staff registered.");
				} else {
					cleaningStaff.forEach(System.out::println);
				}
			}
			case 0 -> System.out.println("Shutting down...");
			default -> System.out.println("Invalid option.");
			}
		} while (option != 0);
	}
}
