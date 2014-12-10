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
	private JMenu optionsMenu;
	private JMenuItem closeMenuItem;
	private JMenuItem addMenuItem;
	private JMenuItem subMenuItem;
	private JMenuItem mulMenuItem;
	private JMenuItem divMenuItem;

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
		optionsMenu = new JMenu();
		closeMenuItem = new JMenuItem();
		addMenuItem = new JMenuItem();
		subMenuItem = new JMenuItem();
		mulMenuItem = new JMenuItem();
		divMenuItem = new JMenuItem();

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

		optionsMenu.setText("Optionen");

		addMenuItem.setText("Addition");
		addMenuItem.setToolTipText("Zahlen addieren");
		addMenuItem.setIcon(new ImageIcon("img/add.gif"));
		addMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO
			}
		});
		optionsMenu.add(addMenuItem);

		subMenuItem.setText("Subtraktion");
		subMenuItem.setToolTipText("Zahlen subtrahieren");
		subMenuItem.setIcon(new ImageIcon("img/sub.gif"));
		subMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO
			}
		});
		optionsMenu.add(subMenuItem);

		mulMenuItem.setText("Multiplikation");
		mulMenuItem.setToolTipText("Zahlen multiplizieren");
		mulMenuItem.setIcon(new ImageIcon("img/mul.gif"));
		mulMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO
			}
		});
		optionsMenu.add(mulMenuItem);

		divMenuItem.setText("Division");
		divMenuItem.setToolTipText("Zahlen dividieren");
		divMenuItem.setIcon(new ImageIcon("img/div.gif"));
		divMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO
			}
		});
		optionsMenu.add(divMenuItem);

		menuBar.add(fileMenu);
		menuBar.add(optionsMenu);
		setJMenuBar(menuBar);

		setVisible(true);
	}
}
