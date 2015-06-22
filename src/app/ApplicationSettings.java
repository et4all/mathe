package app;

import gui.ExercisePanel;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

public class ApplicationSettings {
	private ArrayList<ExercisePanel> panelList = null;
	private JPanel currentPanel = null;
	private Date applicationStartTime = null;
	private Date applicationEndTime = null;

	public ApplicationSettings() {
		this.panelList = new ArrayList<ExercisePanel>();
		this.applicationStartTime = new Date();
	}
	
	public ArrayList<ExercisePanel> getPanels() {
		return panelList;
	}
	
	public ExercisePanel getSuchPanel(PanelType type) {
		for (int i=0;i<panelList.size();i++) {
			if (panelList.get(i).getPanelType().equals(type)) {
				return panelList.get(i);
			}
		}
		return null;
	}
	
	public void addExercisePanel(ExercisePanel panel) {
		panelList.add(panel);
	}
	
	public void setCurrentPanel(ExercisePanel panel) {
		currentPanel = panel;
	}

}
