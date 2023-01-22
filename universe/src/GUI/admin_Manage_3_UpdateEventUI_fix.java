package GUI;

import java.awt.EventQueue;
import javax.swing.border.Border;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.Admin;
import code.DesignController;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class admin_Manage_3_UpdateEventUI_fix extends JFrame {

	private JPanel contentPane;
	private JTextField textField_event_name;
	private JTextField textField_maxCapacity;
	private JTextField textField_event_category;
	private JTextField textField_fee;
	private JLabel lbl_event_title;
	private JLabel lbl_event_category;
	private JLabel lbl_fee;
	private JTextField textField_event_desc;
	private JLabel lbl_maxCapacity;
	private JTextField textField_step_by_step;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lbl_judul;
	private JPanel panel_6;
	private JButton btn_back;
	private JButton btn_save;
	private static DesignController designControl = new DesignController();
	static Admin admins;
	private JLabel lbl_event_step_by_step;
	private JTextArea textArea;
	private JTextArea txtrDescription;
	static String[] result;
	sqlConnector connection = new sqlConnector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_Manage_3_UpdateEventUI_fix frame = new admin_Manage_3_UpdateEventUI_fix(admins, result);
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
	public admin_Manage_3_UpdateEventUI_fix(Admin admins, String[] result) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(249, 247, 247));
		panel_2.setBounds(10, 11, 566, 391);
		contentPane.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 566, 50);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(33, 215, 255));
		
		lbl_judul = new JLabel("Update Event");
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_judul.setBounds(223, 11, 115, 25);
		panel_3.add(lbl_judul);
		panel_2.setLayout(null);
		panel_2.add(panel_3);
		
		btn_back = new JButton("< Back");
		btn_back.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_back.setBorderPainted(false);
		btn_back.setBackground(new Color(203, 229, 255));
		btn_back.setBounds(10, 346, 100, 23);
		panel_2.add(btn_back);
		
		designControl.setNoBorderButton(btn_back);
		btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		admin_Manage_2_DeleteUpdateEventUI_fix frame = new admin_Manage_2_DeleteUpdateEventUI_fix(admins, result);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		btn_save = new JButton("SAVE");
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
        		
        		admin_0_DashboardUI_fix frame = new admin_0_DashboardUI_fix(admins);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(219, 226, 239));
		panel_6.setBounds(10, 61, 546, 274);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		lbl_event_title = new JLabel("Event Title");
		lbl_event_title.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_title.setBounds(23, 17, 83, 20);
		panel_6.add(lbl_event_title);
		
		textField_event_name = new JTextField(result[8]);
		textField_event_name.setBounds(23, 37, 213, 28);
		panel_6.add(textField_event_name);
		textField_event_name.setColumns(10);
		
		textField_maxCapacity = new JTextField(result[5]);
		textField_maxCapacity.setBounds(23, 140, 213, 28);
		panel_6.add(textField_maxCapacity);
		textField_maxCapacity.setColumns(10);
		
		lbl_event_category = new JLabel("Event Category");
		lbl_event_category.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_category.setBounds(23, 70, 111, 14);
		panel_6.add(lbl_event_category);
		
		textField_event_category = new JTextField(result[3]);
		textField_event_category.setBounds(23, 88, 213, 28);
		panel_6.add(textField_event_category);
		textField_event_category.setColumns(10);
		
		lbl_fee = new JLabel("Fee");
		lbl_fee.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_fee.setBounds(23, 174, 83, 14);
		panel_6.add(lbl_fee);
		
		textField_fee = new JTextField(result[6]);
		textField_fee.setBounds(23, 190, 213, 28);
		panel_6.add(textField_fee);
		textField_fee.setColumns(10);
		
		JLabel lbl_event_desc = new JLabel("Description");
		lbl_event_desc.setBounds(270, 20, 83, 14);
		panel_6.add(lbl_event_desc);
		lbl_event_desc.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		textField_event_desc = new JTextField(result[9]);
		textField_event_desc.setBounds(270, 37, 243, 52);
		panel_6.add(textField_event_desc);
		textField_event_desc.setColumns(10);
		
		lbl_maxCapacity = new JLabel("Max Capacity");
		lbl_maxCapacity.setBounds(23, 122, 83, 14);
		panel_6.add(lbl_maxCapacity);
		lbl_maxCapacity.setFont(new Font("Segoe UI", Font.BOLD, 12));
//		Image upimg = new ImageIcon(this.getClass().getResource("/img/img_remback.png")).getImage();
        
		textField_step_by_step = new JTextField(result[7]);
		textField_step_by_step.setBounds(270, 116, 242, 52);
		panel_6.add(textField_step_by_step);
		textField_step_by_step.setColumns(10);
		
		lbl_event_step_by_step = new JLabel("Step by Step");
		lbl_event_step_by_step.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_event_step_by_step.setBounds(270, 98, 83, 14);
		panel_6.add(lbl_event_step_by_step);
		
		txtrDescription = new JTextArea(result[8]);
		
		txtrDescription.setLineWrap(true);
		txtrDescription.setBounds(270, 88, 243, -51);
		panel_6.add(txtrDescription);
	}

}
