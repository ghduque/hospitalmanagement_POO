package model;

public class Nurse extends Employee {
	public Nurse(String name, String phone, String credential) {
		super(name, phone, credential);
	}

	public void preparePatient(Patient p) {
		System.out.println(name + " is preparing the patient " + p.getName());
	}

	@Override
	public String toString() {
		return String.format("Nurse: %s, Credential: %s", name, credential);
	}
}
