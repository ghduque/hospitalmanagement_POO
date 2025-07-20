package model;

public class Doctor extends Employee {
	private String crm;
	private String specialty;

	public Doctor(String name, String phone, String credential, String crm, String specialty) {
		super(name, phone, credential);
		this.crm = crm;
		this.specialty = specialty;
	}

	public String getCrm() {
		return crm;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public void attendPatient(Patient p) {
		System.out.println(name + " is attending the patient " + p.getName());
	}

	@Override
	public String toString() {
		return String.format("Doctor: %s, CRM: %s, Speciality: %s, Credential: %s", name, crm, specialty, credential);
	}
}