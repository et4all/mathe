package app;

import gui.Addition;
import gui.ExercisePanel;
import gui.GUI;

public class Application {
	private GUI gui;
	private ApplicationSettings settings;
	
	public Application() {
		this.gui = new GUI(this);
		this.settings = new ApplicationSettings();
	}
	
	public void startApplication() {
		gui.showWindow();
	}
	
	public ApplicationSettings getSettings() {
		return settings;
	}

	public ExercisePanel getSuchExercisePanel(PanelType type) {
		ExercisePanel panel = settings.getSuchPanel(type);
		if (panel == null) {
			panel = createNewExercisePanel(type);
		}
		return panel;
	}
	
	private ExercisePanel createNewExercisePanel(PanelType type) {
		ExercisePanel panel = null;
		switch (type) {
		case ADDITION:
			panel = new Addition();
			break;
		default: // TODO es soll kein default geben
			break;
		}
		settings.addExercisePanel(panel);
		return panel;
	}
	
	public void setCurrentPanel(ExercisePanel panel) {
		if (settings.getPanels().contains(panel)) {
			settings.setCurrentPanel(panel);
		}
		else {
			settings.addExercisePanel(panel);
			settings.setCurrentPanel(panel);
		}
	}
	
}
