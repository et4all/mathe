package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import app.Application;
import app.PanelType;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private final Application app;
	private int stdWidth = 500;
	private int stdHeight = 300;
	private JPanel contentPanel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu optionsMenu;
	private JMenuItem closeMenuItem;
	private JMenuItem addMenuItem;
	private JMenuItem subMenuItem;
	private JMenuItem mulMenuItem;
	private JMenuItem divMenuItem;
	private BorderLayout guiLayout;
	private ExercisePanel currentPanel = null;
	private JPanel menueLeiste;
	private JPanel statusLeiste;

	public GUI(Application application) {
		this.app = application;
		init();
	}

	private void init() {
		this.guiLayout = new BorderLayout();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace(); // TODO
		}
		this.setSize(stdWidth, stdHeight);
		this.setMinimumSize(new Dimension(stdWidth, stdHeight));
		this.setLocationRelativeTo(null);
		this.setTitle("Mathe");

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
				showPanel(PanelType.ADDITION);
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
		this.setJMenuBar(menuBar);

		contentPanel = new JPanel(guiLayout);
		menueLeiste = new JPanel();
		menueLeiste.setPreferredSize(new Dimension(100, 50));
		contentPanel.add(menueLeiste, BorderLayout.LINE_START);
		int antworten = 0;
		JLabel statTextAntworten = new JLabel("Antworten: " + Integer.toString(antworten));
		statTextAntworten.setPreferredSize(new Dimension(100, 20));
		statusLeiste = new JPanel();
		statusLeiste.setLayout(new BoxLayout(statusLeiste, BoxLayout.LINE_AXIS));
		statusLeiste.setPreferredSize((new Dimension(400, 20)));
		statusLeiste.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.LIGHT_GRAY));
		statusLeiste.add(statTextAntworten);
		statusLeiste.add(new JSeparator(SwingConstants.VERTICAL));
		//statusleiste.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		contentPanel.add(statusLeiste, BorderLayout.PAGE_END);
		this.setContentPane(contentPanel);
	}

	private void showPanel(PanelType type) {
		ExercisePanel panel = app.getSuchExercisePanel(type);
		app.setCurrentPanel(panel);
		contentPanel.add(panel, BorderLayout.CENTER);
		contentPanel.revalidate();
	}
	
	public void showWindow() {
		this.setVisible(true);
	}
	
	public Application getApplication() {
		return app;
	}
	
}
