package model;

public class Receptionist extends Employee {
	public Receptionist(String name, String phone, String credential) {
		super(name, phone, credential);
	}

	public void registerPatient(Patient p) {
		System.out.println("Patient " + p.getName() + " registered by " + name);
	}

	@Override
	public String toString() {
		return String.format("Receptionist: %s, Credential: %s", name, credential);
	}
}
