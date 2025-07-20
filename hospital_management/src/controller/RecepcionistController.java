package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import model.Receptionist;
import util.DataStore;

public class RecepcionistController {

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtPhone;
	@FXML
	private TextField txtCredential;
	@FXML
	private TextArea txtResult;

	@FXML
	private void registerReceptionist() {
		Receptionist r = new Receptionist(txtName.getText(), txtPhone.getText(), txtCredential.getText());
		DataStore.getReceptionists().add(r);
		txtResult.setText("Receptionist registered:\n" + r);
	}

	@FXML
	private void listReceptionists() {
		StringBuilder sb = new StringBuilder();
		for (Receptionist r : DataStore.getReceptionists()) {
			sb.append(r).append("\n");
		}
		txtResult.setText(sb.toString());
	}
}
