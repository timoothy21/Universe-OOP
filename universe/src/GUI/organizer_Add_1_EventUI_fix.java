package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.DesignController;
import code.Event;
import code.Organizer;
import code.sqlConnector;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class organizer_Add_1_EventUI_fix extends JFrame {

	private JPanel contentPane;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lbl_judul;
	private JPanel panel_4;
	private JLabel lbl_icon_upload;
	private JButton btn_back;
	private JButton btn_add;
	private static DesignController designControl = new DesignController();
	static Organizer organizers;
	private JLabel lbl_event_title;
	private JTextField textField_event_title;
	private JTextField textField_maxCapacity;
	private JLabel lbl_event_category;
	private JTextField textField_category;
	private JLabel lbl_fee;
	private JTextField textField_fee;
	private JLabel lbl_event_desc;
	private JTextField textField_desc;
	private JLabel lbl_maxCapacity;
	private JTextField textField_step_by_step;
	private JLabel lbl_event_step_by_step;
	private JTextArea txtrDescription;
	private Event event;
	sqlConnector connection = new sqlConnector();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					organizer_Add_1_EventUI_fix frame = new organizer_Add_1_EventUI_fix(organizers);
					frame.setVisible(true);
					designControl.setFrametoCenterOfScreen(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void getEventData(Organizer organizers) {
		event = new Event(
			organizers.getFullName(),
			textField_category.getText(),
			textField_maxCapacity.getText(),
			0,
			textField_fee.getText(),
			textField_step_by_step.getText(),
			textField_event_title.getText(),
			textField_desc.getText()
				); 
	}
	
	void addEvent(Organizer organizers) {
		getEventData(organizers);
		connection.openConnection();
		
		String sqlQuerry = "INSERT INTO Event(id_account, organizerName, eventCategory, quota, Capacity, fee, steps, eventTitle, eventDesc) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] row = {
				organizers.getID(),
				organizers.getFullName(),
				textField_category.getText(),
				0,
				Integer.parseInt(textField_maxCapacity.getText()),
				textField_fee.getText(),
				textField_step_by_step.getText(),
				textField_event_title.getText(),
				textField_desc.getText()
		};
		connection.addDatatoServerEvent(sqlQuerry, row.length, row);
		dispose();
		organizer_0_DashboardUI_fix frame = new organizer_0_DashboardUI_fix(organizers);
		frame.setVisible(true);
		designControl.setFrametoCenterOfScreen(frame);
	}
	/**
	 * Create the frame.
	 */
	public organizer_Add_1_EventUI_fix(Organizer organizers) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(249, 247, 247));
		panel_2.setBounds(10, 11, 566, 391);
		contentPane.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(33, 215, 255));
		panel_3.setBounds(0, 0, 566, 50);
		panel_2.add(panel_3);
		
		lbl_judul = new JLabel("Create New Event");
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_judul.setBounds(206, 11, 158, 25);
		panel_3.add(lbl_judul);
		
		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(219, 226, 239));
		panel_4.setBounds(10, 61, 546, 274);
		panel_2.add(panel_4);
		
		lbl_event_title = new JLabel("Event Title");
		lbl_event_title.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_title.setBounds(31, 26, 83, 20);
		panel_4.add(lbl_event_title);
		
		textField_event_title = new JTextField();
		textField_event_title.setColumns(10);
		textField_event_title.setBounds(31, 46, 213, 28);
		panel_4.add(textField_event_title);
		
		textField_maxCapacity = new JTextField();
		textField_maxCapacity.setColumns(10);
		textField_maxCapacity.setBounds(31, 149, 213, 28);
		panel_4.add(textField_maxCapacity);
		
		lbl_event_category = new JLabel("Event Category");
		lbl_event_category.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_category.setBounds(31, 79, 111, 14);
		panel_4.add(lbl_event_category);
		
		textField_category = new JTextField();
		textField_category.setColumns(10);
		textField_category.setBounds(31, 97, 213, 28);
		panel_4.add(textField_category);
		
		lbl_fee = new JLabel("Fee");
		lbl_fee.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_fee.setBounds(31, 183, 83, 14);
		panel_4.add(lbl_fee);
		
		textField_fee = new JTextField();
		textField_fee.setColumns(10);
		textField_fee.setBounds(31, 199, 213, 28);
		panel_4.add(textField_fee);
		
		lbl_event_desc = new JLabel("Description");
		lbl_event_desc.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_desc.setBounds(278, 29, 83, 14);
		panel_4.add(lbl_event_desc);
		
		textField_desc = new JTextField();
		textField_desc.setColumns(10);
		textField_desc.setBounds(278, 46, 243, 52);
		panel_4.add(textField_desc);
		
		lbl_maxCapacity = new JLabel("Max Capacity");
		lbl_maxCapacity.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_maxCapacity.setBounds(31, 131, 83, 14);
		panel_4.add(lbl_maxCapacity);
		
		textField_step_by_step = new JTextField();
		textField_step_by_step.setColumns(10);
		textField_step_by_step.setBounds(278, 125, 242, 52);
		panel_4.add(textField_step_by_step);
		
		lbl_event_step_by_step = new JLabel("Step by Step");
		lbl_event_step_by_step.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_step_by_step.setBounds(278, 107, 83, 14);
		panel_4.add(lbl_event_step_by_step);
		
		txtrDescription = new JTextArea((String) null);
		txtrDescription.setLineWrap(true);
		txtrDescription.setBounds(278, 97, 243, -51);
		panel_4.add(txtrDescription);
		Image upimg = new ImageIcon(this.getClass().getResource("/img/img_remback.png")).getImage();
		
		btn_back = new JButton("< Back");
		btn_back.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_back.setBorderPainted(false);
		btn_back.setBackground(new Color(203, 229, 255));
		btn_back.setBounds(10, 346, 100, 23);
		panel_2.add(btn_back);
		
		designControl.setNoBorderButton(btn_back);
		btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		organizer_0_DashboardUI_fix frame = new organizer_0_DashboardUI_fix(organizers);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		btn_add = new JButton("+ ADD");
		btn_add.setForeground(new Color(249, 247, 247));
		btn_add.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_add.setBorderPainted(false);
		btn_add.setBackground(new Color(0, 76, 152));
		btn_add.setBounds(456, 346, 100, 23);
		panel_2.add(btn_add);
		
		designControl.setNoBorderButton(btn_add);
		btn_add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		addEvent(organizers);
//        		organizer_0_DashboardUI_fix frame = new organizer_0_DashboardUI_fix(organizers);
//        		frame.setVisible(true);
//        		designControl.setFrametoCenterOfScreen(frame);
//        		dispose();
        	}
        });
	}
}