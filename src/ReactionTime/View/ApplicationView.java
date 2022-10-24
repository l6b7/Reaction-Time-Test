package ReactionTime.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import ReactionTime.Controller.Controller;

public class ApplicationView {

	private final String WINDOW_NAME = "Reaction Time Test";
	private final Dimension WINDOW_SIZE = new Dimension(800, 600);
	private final Dimension PANEL_BAR_SIZE = new Dimension(0, 40);

	private final String CARD_NAME_START_PANEL = "startPanel";
	private final String CARD_NAME_GET_READY_PANEL = "getReadyPanel";
	private final String CARD_NAME_FALSE_START_PANEL = "falseStartPanel";
	private final String CARD_NAME_CLICK_PANEL = "clickPanel";

	private final String CARD_NAME_APP_PANEL = "appPanel";
	private final String CARD_NAME_RECORDS_PANEL = "RecordsPanel";

	private final Dimension BUTTON_SIZE = new Dimension(105, 30);
	private final Dimension BUTTON_SIZE_WIDE = new Dimension(120, 30);

	private final String BUTTON_NAME_GO_TO_APP = "Application";
	private final String BUTTON_NAME_REMOVE_LAST = "Remove Last";
	private final String BUTTON_NAME_REMOVE_ALL = "Remove All";
	private final String BUTTON_NAME_GO_TO_RECORDS = "Records";

	private final String LABEL_NAME_START_SCREEN = "Start";
	private final String LABEL_NAME_GET_READY_SCREEN = "Get Ready";
	private final String LABEL_NAME_FALSE_START_SCREEN = "Too Soon";
	private final String LABEL_NAME_CLICK_NOW_SCREEN = "Click Now";

	private final String FONT_NAME = "Arial";
	private final Color COLOR_BUTTON = new Color(50, 50, 50);
	private final Color COLOR_BUTTON_TEXT = new Color(200, 200, 200);
	private final Color COLOR_FONT_SCREEN = new Color(255, 255, 255, 150);

	private final int BUTTON_TEXT_SIZE = 15;
	private final int FONT_SIZE_SCREEN = 100;

	private final Color COLOR_SCREEN_BAR = new Color(0, 0, 0);
	private final Color COLOR_SCREEN_START = new Color(50, 180, 220);
	private final Color COLOR_SCREEN_GET_READY = new Color(160, 160, 160);
	private final Color COLOR_SCREEN_FALSE_START = new Color(230, 0, 0);
	private final Color COLOR_SCREEN_CLICK_NOW = new Color(20, 220, 0);
	private final Color COLOR_RECORDS_BACKGROUND = new Color(50, 180, 220);

	private Controller controller;
	private int randomDelayInMS;
	private int timeElapsedInMS = 0;
	private Timer randomDelayTimer;
	private Timer reactionTimeTimer;
	
	private JFrame frame;

	private CardLayout cardLayout;
	private JPanel pageController;

	private CardLayout appMidPanelCardLayout;
	private JPanel appMidPanelpageController;

	private JPanel appPanel;
	private JPanel topAppPanel;
	private JPanel midAppPanel;
	private JPanel botAppPanel;

	private JPanel recordsPanel;
	private JPanel topRecordsPanel;
	private JPanel midRecordsPanel;
	private JPanel botRecordsPanel;

	private JPanel startPanel;
	private JPanel getReadyPanel;
	private JPanel falseStartPanel;
	private JPanel clickPanel;

	private JButton goToRecordsButton;
	private JButton goToAppButton;
	private JButton RemoveLastRecordButton;
	private JButton RemoveAllRecordsButton;

	private JLabel startLabel;
	private JLabel getReadyLabel;
	private JLabel falseStartLabel;
	private JLabel clickNowLabel;
	
	
	
	
	
	
	
	
	
	
	

	public ApplicationView(Controller controller) {

		this.controller = controller;
		
		frame = createFrame(WINDOW_NAME, WINDOW_SIZE);

		initializePanels();
		initializeButtons();
		
		initializeTimers();
		setKeyListeners();
		setMouseActionListeners();
		setButtonActionListeners();
		
		setUpMidPanelCards();
		setUpFrameCards();
		
		setAppMidPanels();
		setAppPanelComponents();
		setRecordsPanelComponents();

		frame.setVisible(true);
	}


	private JFrame createFrame(String name, Dimension WINDOW_SIZE) {

		frame = new JFrame(name);
		frame.setSize(WINDOW_SIZE);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		return frame;
	}

	private void initializePanels() {

		pageController = new JPanel();
		appMidPanelpageController = new JPanel();

		appPanel = new JPanel();
		topAppPanel = new JPanel();
		midAppPanel = new JPanel();
		botAppPanel = new JPanel();

		recordsPanel = new JPanel();
		topRecordsPanel = new JPanel();
		midRecordsPanel = new JPanel();
		botRecordsPanel = new JPanel();

		startPanel = new JPanel();
		getReadyPanel = new JPanel();
		falseStartPanel = new JPanel();
		clickPanel = new JPanel();
	}

	private void initializeButtons() {

		goToAppButton 	=	createButton(BUTTON_NAME_GO_TO_APP, BUTTON_SIZE, BUTTON_TEXT_SIZE);
		goToRecordsButton = createButton(BUTTON_NAME_GO_TO_RECORDS, BUTTON_SIZE, BUTTON_TEXT_SIZE);
		RemoveLastRecordButton = createButton(BUTTON_NAME_REMOVE_LAST, BUTTON_SIZE_WIDE, BUTTON_TEXT_SIZE);
		RemoveAllRecordsButton = createButton(BUTTON_NAME_REMOVE_ALL, BUTTON_SIZE_WIDE, BUTTON_TEXT_SIZE);
	}

	private JButton createButton(String name, Dimension size, int textSize) {

		JButton button = new JButton(name);
		button.setPreferredSize(size);
		button.setBorder(new BevelBorder(0));
		
		button.setBorderPainted(true);
		button.setFocusable(false);
		
		button.setBackground(COLOR_BUTTON);

		button.setForeground(COLOR_BUTTON_TEXT);
		button.setFont(new Font(FONT_NAME, 1, textSize));

		return button;
	}

	private void initializeTimers() {
		randomDelayTimer = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timeElapsedInMS = timeElapsedInMS + 100;
				if (timeElapsedInMS > randomDelayInMS) {
						appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_CLICK_PANEL);
						InitializeReactionSpeedTimer();
						reactionTimeTimer.start();
						randomDelayTimer.stop();
						timeElapsedInMS = 0;
				}
			}
		});
	}

	private void InitializeReactionSpeedTimer() {

		long initialTimeStamp = System.currentTimeMillis();
		reactionTimeTimer = new Timer(1, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickNowLabel.setText(Long.toString((System.currentTimeMillis() - initialTimeStamp)));
			}
		});
	}

	private void setKeyListeners() {
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					
					if (startPanel.isShowing()) {
						randomDelayInMS = controller.getRandomDelay();
						randomDelayTimer.start();
						appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_GET_READY_PANEL);
					}
					
					else if(getReadyPanel.isShowing()) {
						appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_FALSE_START_PANEL);
						timeElapsedInMS = 0;
						randomDelayTimer.stop();
						
					}
					
					else if(falseStartPanel.isShowing()) {
						randomDelayInMS = controller.getRandomDelay();
						randomDelayTimer.start();
						appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_GET_READY_PANEL);
						
					}
					
					else if (clickPanel.isShowing()) {
						reactionTimeTimer.stop();
						appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_START_PANEL);
						startLabel.setText(clickNowLabel.getText());
					}
					
				}
			}
		});
	}
	
	private void setMouseActionListeners() {
		startPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				randomDelayInMS = controller.getRandomDelay();
				randomDelayTimer.start();
				appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_GET_READY_PANEL);
				
			}
		});
		
		getReadyPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_FALSE_START_PANEL);
				timeElapsedInMS = 0;
				randomDelayTimer.stop();
			}
		});
		
		clickPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				reactionTimeTimer.stop();
				appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_START_PANEL);
				startLabel.setText(clickNowLabel.getText());
			}
		});
		
		falseStartPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				randomDelayInMS = controller.getRandomDelay();
				randomDelayTimer.start();
				appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_GET_READY_PANEL);
			}
		});
	}
	
	private void setButtonActionListeners() {
		RemoveLastRecordButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clearLastResult();
			}
		});

		RemoveAllRecordsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.clearResults();
			}
		});

		goToRecordsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pageController, CARD_NAME_RECORDS_PANEL);
			}
		});

		goToAppButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(pageController, CARD_NAME_APP_PANEL);
			}
		});
	}


	private void setUpMidPanelCards() {

		appMidPanelCardLayout = new CardLayout();
		appMidPanelpageController.setLayout(appMidPanelCardLayout);
		midAppPanel.setLayout(new BorderLayout());
		midAppPanel.add(appMidPanelpageController);
		
		appMidPanelpageController.add(startPanel, CARD_NAME_START_PANEL);
		appMidPanelpageController.add(getReadyPanel, CARD_NAME_GET_READY_PANEL);
		appMidPanelpageController.add(falseStartPanel, CARD_NAME_FALSE_START_PANEL);
		appMidPanelpageController.add(clickPanel, CARD_NAME_CLICK_PANEL);
		
		appMidPanelCardLayout.show(appMidPanelpageController, CARD_NAME_START_PANEL);
	}

	private void setUpFrameCards() {

		cardLayout = new CardLayout();
		pageController.setLayout(cardLayout);
		frame.add(pageController);
		
		pageController.add(appPanel, CARD_NAME_APP_PANEL);
		pageController.add(recordsPanel, CARD_NAME_RECORDS_PANEL);
		
		cardLayout.show(pageController, CARD_NAME_APP_PANEL);
		
	}

	private void setAppMidPanels() {

		startLabel = createLabel(LABEL_NAME_START_SCREEN);
		setPanel(startPanel, COLOR_SCREEN_START, startLabel);

		getReadyLabel = createLabel(LABEL_NAME_GET_READY_SCREEN);
		setPanel(getReadyPanel, COLOR_SCREEN_GET_READY, getReadyLabel);

		falseStartLabel = createLabel(LABEL_NAME_FALSE_START_SCREEN);
		setPanel(falseStartPanel, COLOR_SCREEN_FALSE_START, falseStartLabel);

		clickNowLabel = createLabel(LABEL_NAME_CLICK_NOW_SCREEN);
		setPanel(clickPanel, COLOR_SCREEN_CLICK_NOW, clickNowLabel);
	}

	private void setPanel(JPanel panel, Color bg, JLabel label) {

		panel.setBackground(bg);
		panel.setLayout(new BorderLayout());
		panel.add(label);
	}

	private JLabel createLabel(String name) {

		JLabel label = new JLabel(name);
		label.setForeground(COLOR_FONT_SCREEN);
		label.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE_SCREEN));
		label.setHorizontalAlignment(JLabel.CENTER);

		return label;
	}

	private void setAppPanelComponents() {

		appPanel.setLayout(new BorderLayout());
		topAppPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		topAppPanel.setBackground(COLOR_SCREEN_BAR);

		botAppPanel.setBackground(COLOR_SCREEN_BAR);

		topAppPanel.setPreferredSize(PANEL_BAR_SIZE);
		botAppPanel.setPreferredSize(PANEL_BAR_SIZE);

		topAppPanel.add(goToRecordsButton);

		appPanel.add(topAppPanel, BorderLayout.NORTH);
		appPanel.add(midAppPanel, BorderLayout.CENTER);
		appPanel.add(botAppPanel, BorderLayout.SOUTH);
	}

	private void setRecordsPanelComponents() {

		recordsPanel.setLayout(new BorderLayout());
		topRecordsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		botRecordsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		topRecordsPanel.setBackground(COLOR_SCREEN_BAR);
		midRecordsPanel.setBackground(COLOR_RECORDS_BACKGROUND);
		botRecordsPanel.setBackground(COLOR_SCREEN_BAR);

		topRecordsPanel.setPreferredSize(PANEL_BAR_SIZE);
		botRecordsPanel.setPreferredSize(PANEL_BAR_SIZE);

		/////////////////////////// new
		
		JTable tableL5 = new JTable(0,0);		
		tableL5.setForeground(Color.CYAN);
		tableL5.setBackground(Color.GRAY);
		
		DefaultTableModel model = (DefaultTableModel) tableL5.getModel();
		model.addColumn("History",controller.getAllRecords().toArray());
		tableL5.setModel(model);
		
		midRecordsPanel.setLayout(new BorderLayout());
		
		
		JPanel lleft = new JPanel();
		JPanel lright = new JPanel();
		JPanel lmid = new JPanel();
		
		JPanel mmTop = new JPanel();
		JPanel mmBot = new JPanel();

		
		mmTop.setLayout(new GridLayout(0,4,75,5));
		mmTop.setBackground(Color.GREEN);
		
		mmBot.setLayout(new BorderLayout());
		mmBot.setBackground(Color.MAGENTA);
		
		
		lmid.setLayout(new BorderLayout());
		
		JPanel lmidleft = new JPanel();
		JPanel lmidright = new JPanel();
		
		lleft.setBackground(Color.BLACK);
		lright.setBackground(Color.BLACK);
		lleft.setPreferredSize(new Dimension(40,0));
		lright.setPreferredSize(new Dimension(40,0));
		
		
		lmidleft.setBackground(Color.BLUE);
		lmidright.setBackground(Color.RED);
		lmidleft.setPreferredSize(new Dimension(200,0));
		
		JLabel label1 = new JLabel("current");
		JLabel label2 = new JLabel("avg 3");
		JLabel label3 = new JLabel("avg 5");
		JLabel label4 = new JLabel("avg 10");
		
		JLabel label5 = new JLabel("100");
		JLabel label6 = new JLabel("300");
		JLabel label7 = new JLabel("500");
		JLabel label8 = new JLabel("1000");
		
		
		mmTop.add(label1);
		mmTop.add(label2);
		mmTop.add(label3);
		mmTop.add(label4);
		
		mmTop.add(label5);
		mmTop.add(label6);
		mmTop.add(label7);
		mmTop.add(label8);
		
		lmidright.setLayout(new BorderLayout());
		
		
		 mmBot.add(new JLabel(new ImageIcon("Graph.PNG")),BorderLayout.CENTER);
		
		 
		 lmidleft.add(tableL5);		 
		lmidright.add(mmTop,BorderLayout.NORTH);
		lmidright.add(mmBot);
		
		lmid.add(lmidleft, BorderLayout.WEST);
		lmid.add(lmidright);
		
		
		midRecordsPanel.add(lleft, BorderLayout.WEST);
		midRecordsPanel.add(lright, BorderLayout.EAST);
		midRecordsPanel.add(lmid);

		/////////////////////////////////
		
		
		
		topRecordsPanel.add(goToAppButton);
		botRecordsPanel.add(RemoveLastRecordButton);
		botRecordsPanel.add(RemoveAllRecordsButton);

		recordsPanel.add(topRecordsPanel, BorderLayout.NORTH);
		recordsPanel.add(midRecordsPanel, BorderLayout.CENTER);
		recordsPanel.add(botRecordsPanel, BorderLayout.SOUTH);
	}

}