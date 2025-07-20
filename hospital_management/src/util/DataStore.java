package util;

import model.Doctor;
import model.Nurse;
import model.Patient;
import model.Receptionist;
import model.CleaningStaff;
import java.util.ArrayList;
import java.util.List;

public class DataStore {
	public static final List<Patient> patients = new ArrayList<>();
	public static final List<Doctor> doctors = new ArrayList<>();
	public static final List<Nurse> nurses = new ArrayList<>();
	public static final List<Receptionist> receptionists = new ArrayList<>();
	public static final List<CleaningStaff> cleaningStaff = new ArrayList<>();

	public static List<Patient> getPatients() {
		return patients;
	}

	public static List<Doctor> getDoctors() {
		return doctors;
	}

	public static List<Nurse> getNurses() {
		return nurses;
	}

	public static List<Receptionist> getReceptionists() {
		return receptionists;
	}

	public static List<CleaningStaff> getCleaningStaff() {
		return cleaningStaff;
	}

	private static final DataStore instance = new DataStore();

	private DataStore() {
	}

	public static DataStore getInstance() {
		return instance;
	}

}
