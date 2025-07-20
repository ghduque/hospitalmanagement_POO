package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

	@FXML
	private void openDoctorScreen() throws Exception {
		openWindow("/view/doctor.fxml", "Doctor Management");
	}

	@FXML
	private void openPatientScreen() throws Exception {
		openWindow("/view/patient.fxml", "Patient Management");
	}

	@FXML
	private void openNurseScreen() throws Exception {
		openWindow("/view/nurse.fxml", "Nurse Management");
	}

	@FXML
	private void openReceptionistScreen() throws Exception {
		openWindow("/view/receptionist.fxml", "Receptionist Management");
	}

	private void openWindow(String path, String title) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(path));
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(new Scene(root));
		stage.show();
	}
}
