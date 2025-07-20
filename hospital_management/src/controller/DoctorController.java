package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import model.Doctor;
import util.DataStore;

public class DoctorController {

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtPhone;
	@FXML
	private TextField txtCredential;
	@FXML
	private TextField txtCRM;
	@FXML
	private TextField txtSpecialty;
	@FXML
	private TextArea txtResult;

	@FXML
	private void registerDoctor() {
		Doctor doctor = new Doctor(txtName.getText(), txtPhone.getText(), txtCredential.getText(), txtCRM.getText(),
				txtSpecialty.getText());
		DataStore.getDoctors().add(doctor);
		txtResult.setText("Doctor registered:\n" + doctor);
	}

	@FXML
	private void listDoctors() {
		StringBuilder sb = new StringBuilder();
		for (Doctor d : DataStore.getDoctors()) {
			sb.append(d).append("\n");
		}
		txtResult.setText(sb.toString());
	}
}
