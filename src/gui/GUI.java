package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private int stdWidth = 500;
	private int stdHeight = 300;
	private JMenuBar menuBar;
	private JMenu fileMenu;

	private JMenuItem closeMenuItem;

	public GUI() {
		init();
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace(); // TODO
		}
		setSize(stdWidth, stdHeight);
		setLocationRelativeTo(null);
		setTitle("Mathe");

		menuBar = new JMenuBar();
		fileMenu = new JMenu();
		closeMenuItem = new JMenuItem();

		fileMenu.setText("Datei");
		closeMenuItem.setText("Beenden");
		closeMenuItem.setToolTipText("Programm beenden");
		closeMenuItem.setIcon(new ImageIcon("img/close.gif"));
		closeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
				dispose();
			}
		});
		fileMenu.add(closeMenuItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);

		setVisible(true);
	}
}
