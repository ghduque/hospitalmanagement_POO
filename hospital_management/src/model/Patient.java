package model;

public class Patient extends Person {
	private int id;
	private String healthPlanId;
	private Doctor responsibleDoctor;
	private Nurse responsibleNurse;

	public Patient(String name, String phone, int id, String healthPlanId) {
		super(name, phone);
		this.id = id;
		this.healthPlanId = healthPlanId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHealthPlanId() {
		return healthPlanId;
	}

	public void setHealthPlanId(String healthPlanId) {
		this.healthPlanId = healthPlanId;
	}

	public void assignDoctor(Doctor doctor) {
		this.responsibleDoctor = doctor;
	}

	public void assignNurse(Nurse nurse) {
		this.responsibleNurse = nurse;
	}

	@Override
	public String toString() {
		return String.format("ID: %d, Name: %s, Phone: %s\n  Doctor: %s\n  Nurse: %s", id, name, phone,
				responsibleDoctor != null ? responsibleDoctor.getName() : "None",
				responsibleNurse != null ? responsibleNurse.getName() : "None");
	}
}
