package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Addition extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel zahl1 = new JLabel();
	private JLabel zahl2 = new JLabel();
	private JTextField antwort = new JTextField(5);
	private JLabel zeichen = new JLabel("+");
	private JLabel gleich = new JLabel("=");
	private JLabel check = null;
	private ImageIcon richtig = new ImageIcon("img/add.gif", "Richtig");
	private ImageIcon falsch = new ImageIcon("img/sub.gif", "Falsch");
	private JButton okButton = new JButton("Pr\u00fcfe");
	private JButton newExerciseButton = new JButton("Neue Aufgabe");
	private Random random = new Random();
	private boolean checked = false;
	private int min = 0;
	private int max = 10;
	private BorderLayout myLayout = new BorderLayout();
	private JPanel topPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel rightPanel = new JPanel();

	public Addition() {
		init();
	}

	private void init() {
		check = new JLabel(richtig);
		zahl1.setText(Integer.toString(getRandomInt(min, max)));
		zahl2.setText(Integer.toString(getRandomInt(min, max)));

		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
		
		int antworten = 0;
		JLabel statTextAntworten = new JLabel("Antworten: " + Integer.toString(antworten));
		statTextAntworten.setPreferredSize(new Dimension(100, 20));
		bottomPanel.add(statTextAntworten);
		//bottomPanel.add(statAntworten);
		//bottomPanel.add(Box.createHorizontalStrut(5));
		bottomPanel.add(new JSeparator(SwingConstants.VERTICAL));
		centerPanel.add(zahl1);
		centerPanel.add(zeichen);
		centerPanel.add(zahl2);
		centerPanel.add(gleich);
		centerPanel.add(antwort);
		centerPanel.add(okButton);
		centerPanel.add(newExerciseButton);
		
		this.setLayout(myLayout);
		topPanel.setPreferredSize((new Dimension(400, 20)));
		topPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		bottomPanel.setPreferredSize((new Dimension(400, 20)));
		bottomPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		leftPanel.setPreferredSize((new Dimension(50, 50)));
		leftPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		centerPanel.setPreferredSize((new Dimension(200, 50)));
		centerPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		rightPanel.setPreferredSize((new Dimension(50, 50)));
		rightPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		this.add(topPanel, BorderLayout.PAGE_START);
		this.add(bottomPanel, BorderLayout.PAGE_END);
		this.add(leftPanel, BorderLayout.LINE_START);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.LINE_END);

		antwort.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
			}
			@Override
			public void focusGained(FocusEvent e) {
				antwort.selectAll();
			}
		});

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkResult();
				antwort.requestFocus();
			}
		});

		newExerciseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setNewExercise();
			}
		});
	}

	private int getRandomInt(int von, int bis) {
		return (random.nextInt(bis - von + 1) + von);
	}

	private void checkResult() {
		try {
			int z1 = Integer.parseInt(zahl1.getText());
			int z2 = Integer.parseInt(zahl2.getText());
			int z3 = Integer.parseInt(antwort.getText());
			setResult((z1 + z2) == z3 ? true : false);
		} catch (NumberFormatException e) {
			setResult(false);
		}
	}

	public void setResult(boolean result) {
		if (checked) {
			rightPanel.remove(check);
			rightPanel.repaint();
		}
		checked = true;
		check = new JLabel(result ? richtig : falsch);
		rightPanel.add(check);
		this.revalidate();
	}

	public void setNewExercise() {
		rightPanel.remove(check);
		rightPanel.repaint();
		checked = false;
		zahl1.setText(Integer.toString(getRandomInt(min, max)));
		zahl2.setText(Integer.toString(getRandomInt(min, max)));
		antwort.setText("");
		antwort.requestFocus();
	}

}
