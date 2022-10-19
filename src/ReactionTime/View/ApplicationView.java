package ReactionTime.View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import ReactionTime.Controller.Controller;

public class ApplicationView {

	private JFrame testWindow;
	private JFrame resultsWindow;
	private Controller controller;

	public ApplicationView(Controller controller) {
		this.controller = controller;
		initializeTestView();
		initializeResultsView();
	}

	private void initializeTestView() {
		testWindow = new JFrame();
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		Button switchScreen = new Button("lib/game");
		Button click = new Button("click");

		testWindow.setTitle("Reaction Time Test");
		testWindow.setSize(400, 400);
		testWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		testWindow.getContentPane().setBackground(Color.GRAY);

		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		topPanel.setBackground(Color.BLACK);
		midPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		midPanel.setBackground(Color.WHITE);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		bottomPanel.setBackground(Color.BLACK);

		bottomPanel.add(click);
		topPanel.add(switchScreen);

		switchScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchView();
				
				
				if (midPanel.getBackground().equals(Color.WHITE)) {
					midPanel.setBackground(Color.GREEN);

				} else {
					midPanel.setBackground(Color.WHITE);
				}

				// window.getContentPane().setBackground(Color.RED);
			}
		});

		switchScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (midPanel.getBackground().equals(Color.WHITE)) {
					midPanel.setBackground(Color.GREEN);

				} else {
					midPanel.setBackground(Color.WHITE);
				}

				// window.getContentPane().setBackground(Color.RED);
			}
		});

		testWindow.add(topPanel, BorderLayout.NORTH);
		testWindow.add(midPanel, BorderLayout.CENTER);
		testWindow.add(bottomPanel, BorderLayout.SOUTH);

		testWindow.setVisible(true);
	}

	private void initializeResultsView() {
		resultsWindow = new JFrame();
		JPanel topPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel bottomPanel = new JPanel();

		Button switchScreen = new Button("lib/game");
		Button removeOne = new Button("removeOne");
		Button removeAll = new Button("removeAll");

		this.resultsWindow.setTitle("Reaction Time Test");
		this.resultsWindow.setSize(400, 400);
		this.resultsWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.resultsWindow.getContentPane().setBackground(Color.GRAY);

		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		topPanel.setBackground(Color.BLACK);
		midPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		midPanel.setBackground(Color.WHITE);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		bottomPanel.setBackground(Color.RED);

		topPanel.add(switchScreen);
		bottomPanel.add(removeOne, Component.LEFT_ALIGNMENT);
		bottomPanel.add(removeAll, Component.RIGHT_ALIGNMENT);

		resultsWindow.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setVisible(true);

		switchScreen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchView();
				if (midPanel.getBackground().equals(Color.WHITE)) {
					midPanel.setBackground(Color.GREEN);

				} else {
					midPanel.setBackground(Color.WHITE);
				}

				// window.getContentPane().setBackground(Color.RED);
			}
		});

		resultsWindow.add(topPanel, BorderLayout.NORTH);
		resultsWindow.add(midPanel, BorderLayout.CENTER);

		resultsWindow.setVisible(false);

	}

	private void switchView() {
		if (testWindow.isVisible()) {
			testWindow.setVisible(false);
			resultsWindow.setVisible(true);
		}
	else if (resultsWindow.isVisible()) {
			resultsWindow.setVisible(false);
			testWindow.setVisible(true);
		}
	}

}
