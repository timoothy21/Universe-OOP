package GUI;

import java.awt.EventQueue;
import javax.swing.border.Border;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.DesignController;
import code.Organizer;
import code.sqlConnector;

import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class organizer_Manage_3_UpdateEventUI_fix extends JFrame {

	private JPanel contentPane;
	private static DesignController designControl = new DesignController();
	static Organizer organizers;
	private JTextField textField_event_name;
	private JTextField textField_maxCapacity;
	private JTextField textField_event_category;
	private JTextField textField_fee;
	private JTextField textField_event_desc;
	private JTextField textField_step_by_step;
	static String[] result;
	sqlConnector connection = new sqlConnector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					organizer_Manage_3_UpdateEventUI_fix frame = new organizer_Manage_3_UpdateEventUI_fix(organizers, result);
					frame.setVisible(true);
					designControl.setFrametoCenterOfScreen(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public organizer_Manage_3_UpdateEventUI_fix(Organizer organizers, String[] result) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(249, 247, 247));
		panel_2.setBounds(10, 11, 566, 391);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(33, 215, 255));
		panel_3.setBounds(0, 0, 566, 50);
		panel_2.add(panel_3);
		
		JLabel lbl_judul = new JLabel("Update Event");
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_judul.setBounds(223, 11, 115, 25);
		panel_3.add(lbl_judul);
		
		JButton btn_back = new JButton("< Back");
		btn_back.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_back.setBorderPainted(false);
		btn_back.setBackground(new Color(203, 229, 255));
		btn_back.setBounds(10, 346, 100, 23);
		panel_2.add(btn_back);
		
		designControl.setNoBorderButton(btn_back);
		btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		organizer_Manage_2_DeleteUpdateEventUI_fix frame = new organizer_Manage_2_DeleteUpdateEventUI_fix(organizers, result);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		JButton btn_save = new JButton("SAVE");
		btn_save.setForeground(new Color(249, 247, 247));
		btn_save.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_save.setBorderPainted(false);
		btn_save.setBackground(new Color(0, 76, 152));
		btn_save.setBounds(456, 346, 100, 23);
		panel_2.add(btn_save);
		
		designControl.setNoBorderButton(btn_save);
		btn_save.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		connection.openConnection();
        		
        		String querrySQL = "UPDATE event SET "
        				+ "eventCategory = ?," 
        				+ " Capacity = ?,"
        				+ " fee = ?,"
        				+ " steps = ?,"
        				+ " eventTitle = ?,"
        				+ " eventDesc = ?"
        				+ " WHERE id_event = ?;";
        		
        		Object[] values = {
        				textField_event_category.getText(),
        				Integer.parseInt(textField_maxCapacity.getText()),
        				textField_fee.getText(),
        				textField_step_by_step.getText(),
        				textField_event_name.getText(),
        				textField_event_desc.getText(),
        				Integer.parseInt(result[1])
        		};
        		
        		
        		// id event = result[1]
        		
        		connection.updateEvent(querrySQL, values.length, values);
        		
        		organizer_0_DashboardUI_fix frame = new organizer_0_DashboardUI_fix(organizers);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(219, 226, 239));
		panel_6.setBounds(10, 61, 546, 274);
		panel_2.add(panel_6);
		
		JLabel lbl_event_title = new JLabel("Event Title");
		lbl_event_title.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_title.setBounds(30, 25, 83, 20);
		panel_6.add(lbl_event_title);
		
		textField_event_name = new JTextField(result[8]);
		textField_event_name.setColumns(10);
		textField_event_name.setBounds(30, 45, 213, 28);
		panel_6.add(textField_event_name);
		
		textField_maxCapacity = new JTextField(result[5]);
		textField_maxCapacity.setColumns(10);
		textField_maxCapacity.setBounds(30, 148, 213, 28);
		panel_6.add(textField_maxCapacity);
		
		JLabel lbl_event_category = new JLabel("Event Category");
		lbl_event_category.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_category.setBounds(30, 78, 111, 14);
		panel_6.add(lbl_event_category);
		
		textField_event_category = new JTextField(result[3]);
		textField_event_category.setColumns(10);
		textField_event_category.setBounds(30, 96, 213, 28);
		panel_6.add(textField_event_category);
		
		JLabel lbl_fee = new JLabel("Fee");
		lbl_fee.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_fee.setBounds(30, 182, 83, 14);
		panel_6.add(lbl_fee);
		
		textField_fee = new JTextField(result[6]);
		textField_fee.setColumns(10);
		textField_fee.setBounds(30, 198, 213, 28);
		panel_6.add(textField_fee);
		
		JLabel lbl_event_desc = new JLabel("Description");
		lbl_event_desc.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_desc.setBounds(277, 28, 83, 14);
		panel_6.add(lbl_event_desc);
		
		textField_event_desc = new JTextField(result[9]);
		textField_event_desc.setColumns(10);
		textField_event_desc.setBounds(277, 45, 243, 52);
		panel_6.add(textField_event_desc);
		
		JLabel lbl_maxCapacity = new JLabel("Max Capacity");
		lbl_maxCapacity.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_maxCapacity.setBounds(30, 130, 83, 14);
		panel_6.add(lbl_maxCapacity);
		
		textField_step_by_step = new JTextField(result[7]);
		textField_step_by_step.setColumns(10);
		textField_step_by_step.setBounds(277, 124, 242, 52);
		panel_6.add(textField_step_by_step);
		
		JLabel lbl_event_step_by_step = new JLabel("Step by Step");
		lbl_event_step_by_step.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_step_by_step.setBounds(277, 106, 83, 14);
		panel_6.add(lbl_event_step_by_step);
		
		JTextArea txtrDescription = new JTextArea((String) null);
		txtrDescription.setLineWrap(true);
		txtrDescription.setBounds(277, 96, 243, -51);
		panel_6.add(txtrDescription);
		Image upimg = new ImageIcon(this.getClass().getResource("/img/img_remback.png")).getImage();
	}

}
