package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import model.Patient;
import util.DataStore;

public class PatientController {

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtHealthPlanId;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtPhone;

	@FXML
	private TextArea txtResult;

	@FXML
	private void registerPatient() {

		String healthPlanId = txtHealthPlanId.getText();
		int id = Integer.parseInt(txtId.getText());
		Patient p = new Patient(txtName.getText(), txtPhone.getText(), id, healthPlanId);
		DataStore.getPatients().add(p);
		txtResult.setText("Patient registered:\n" + p);
	}

	@FXML
	private void listPatients() {
		StringBuilder sb = new StringBuilder();
		for (Patient p : DataStore.getPatients()) {
			sb.append(p).append("\n");
		}
		txtResult.setText(sb.toString());
	}
}