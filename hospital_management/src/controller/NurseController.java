package controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import model.Nurse;
import util.DataStore;

public class NurseController {

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtPhone;
	@FXML
	private TextField txtCredential;
	@FXML
	private TextArea txtResult;

	@FXML
	private void registerNurse() {
		Nurse nurse = new Nurse(txtName.getText(), txtPhone.getText(), txtCredential.getText());
		DataStore.getNurses().add(nurse);
		txtResult.setText("Nurse registered:\n" + nurse);
	}

	@FXML
	private void listNurses() {
		StringBuilder sb = new StringBuilder();
		for (Nurse n : DataStore.getNurses()) {
			sb.append(n).append("\n");
		}
		txtResult.setText(sb.toString());
	}
}
