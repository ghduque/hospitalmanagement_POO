package model;

public class CleaningStaff extends Employee {
	public CleaningStaff(String name, String phone, String credential) {
		super(name, phone, credential);
	}

	public void clean() {
		System.out.println(name + " is cleaning the room.");
	}

	@Override
	public String toString() {
		return String.format("Cleaning Staff: %s, Credential: %s", name, credential);
	}
}
