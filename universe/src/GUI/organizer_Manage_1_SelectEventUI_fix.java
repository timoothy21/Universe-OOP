package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSet;

import code.DesignController;
import code.Organizer;
import code.sqlConnector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.BorderFactory;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class organizer_Manage_1_SelectEventUI_fix extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private static DesignController designControl = new DesignController();
	static Organizer organizers;
	private JTable table;
	sqlConnector connection = new sqlConnector();
	String category;
	String harga;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					organizer_Manage_1_SelectEventUI_fix frame = new organizer_Manage_1_SelectEventUI_fix(organizers);
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
	public organizer_Manage_1_SelectEventUI_fix(Organizer organizers) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(249, 247, 247));
		panel_1.setBounds(10, 11, 566, 391);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(33, 215, 255));
		panel_2.setBounds(0, 0, 566, 50);
		panel_1.add(panel_2);
		
		JLabel lbl_judul = new JLabel("Choose Event");
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_judul.setBounds(226, 11, 126, 25);
		panel_2.add(lbl_judul);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(219, 226, 239));
		panel_4.setBounds(10, 89, 115, 256);
		panel_1.add(panel_4);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(132, 131, 206));
		panel_5_1.setBounds(0, 0, 114, 30);
		panel_4.add(panel_5_1);
		
		JLabel lbl_judul_profile = new JLabel("Profile");
		lbl_judul_profile.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul_profile.setForeground(new Color(249, 247, 247));
		lbl_judul_profile.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_judul_profile.setBackground(Color.BLACK);
		panel_5_1.add(lbl_judul_profile);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(249, 247, 247));
		panel_10.setBounds(13, 41, 90, 90);
		panel_4.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_img_organizer = new JLabel("New label");
		lbl_img_organizer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_10.add(lbl_img_organizer, BorderLayout.CENTER);
		lbl_img_organizer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(249, 247, 247));
		panel_3.setBounds(7, 142, 101, 31);
		panel_4.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFullName = new JLabel(organizers.getFullName());
		panel_3.add(lblFullName, BorderLayout.CENTER);
		lblFullName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(249, 247, 247));
		panel_3_1.setBounds(7, 177, 101, 31);
		panel_4.add(panel_3_1);
		panel_3_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUsername = new JLabel(organizers.getUsername());
		panel_3_1.add(lblUsername, BorderLayout.CENTER);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(249, 247, 247));
		panel_3_1_1.setBounds(7, 213, 101, 31);
		panel_4.add(panel_3_1_1);
		panel_3_1_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEmail = new JLabel(organizers.getEmail());
		panel_3_1_1.add(lblEmail, BorderLayout.CENTER);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBackground(new Color(33, 215, 255));
		panel_5_1_1.setBounds(10, 55, 114, 30);
		panel_1.add(panel_5_1_1);
		
		JLabel lbl_user_role = new JLabel("ORGANIZER");
		lbl_user_role.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_user_role.setForeground(new Color(249, 247, 247));
		lbl_user_role.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_user_role.setBackground(Color.BLACK);
		panel_5_1_1.add(lbl_user_role);
		
		JButton btnBack = new JButton("< Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(203, 229, 255));
		btnBack.setBounds(10, 355, 115, 23);
		panel_1.add(btnBack);
		
		designControl.setNoBorderButton(btnBack);
		btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		organizer_0_DashboardUI_fix frame = new organizer_0_DashboardUI_fix(organizers);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 54, 422, 293);
		panel_1.add(scrollPane);
		
		table = new JTable();
		model = connection.showEventEnrolledOrganizer(table, organizers);
//		table = new JTable(connection.getTableData(), connection.getTableColumn());
		scrollPane.setViewportView(table);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.setBorderPainted(false);
		btnSelect.setBackground(new Color(203, 229, 255));
		btnSelect.setBounds(441, 356, 115, 23);
		panel_1.add(btnSelect);
		
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = table.getSelectedRow();
	
				String[] result = new String[model.getColumnCount()];
				for(int i = 0; i < model.getColumnCount(); i++) {
					result[i] = (String) table.getModel().getValueAt(j, i);
					System.out.println(result[i]);
				}
				
        		organizer_Manage_2_DeleteUpdateEventUI_fix frame = new organizer_Manage_2_DeleteUpdateEventUI_fix(organizers, result);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
				
			}
		});
	}

}