package gui;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import app.ExercisePanelSettings;
import app.PanelType;

public abstract class ExercisePanel extends JPanel {
	//private String panelName = null; // TODO entfernen?
	private PanelType panelType = null;
	private ExercisePanelSettings panelSettings = null;

	public ExercisePanel(PanelType type) {
		this.panelType = type;
	}

	public PanelType getPanelType() {
		return panelType;
	}
	
	public abstract JButton getDefaultPanelButton();

}
