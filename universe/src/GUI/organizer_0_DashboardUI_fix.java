package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.DesignController;
import code.Organizer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


public class organizer_0_DashboardUI_fix extends JFrame {

	private JPanel contentPane;
	private JTable table_1;
	private JTextField txtWelcomeuser;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_4;
	private JButton btn_add;
	private JButton btn_search;
	private JPanel panel;
	private JPanel panel_3;
	private JPanel panel_fullName;
	private JLabel txtFullName;
	private JPanel panel_username;
	private JLabel txtUsername;
	private JPanel panel_email;
	private JLabel txtEmail;
	private JLabel lbl_img;
	private JButton btn_logout;
	private static DesignController designControl = new DesignController();
	static Organizer organizers;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					organizer_0_DashboardUI_fix frame = new organizer_0_DashboardUI_fix(organizers);
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
	public organizer_0_DashboardUI_fix(Organizer organizers) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtWelcomeuser = new JTextField();
		txtWelcomeuser.setHorizontalAlignment(SwingConstants.CENTER);
		txtWelcomeuser.setFont(new Font("Segoe UI", Font.BOLD, 12));
		txtWelcomeuser.setText("Welcome, " + organizers.getFullName() + "!");
		txtWelcomeuser.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtWelcomeuser.setBackground(new Color(33, 215, 255));
		txtWelcomeuser.setEditable(false);
		txtWelcomeuser.setBounds(237, 110, 262, 29);
		contentPane.add(txtWelcomeuser);
		txtWelcomeuser.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 247, 247));
		panel_1.setBounds(10, 11, 566, 391);
		contentPane.add(panel_1);
		
		JButton btn_manageEvent = new JButton("Manage Event");
		btn_manageEvent.setForeground(new Color(249, 247, 247));
		btn_manageEvent.setBackground(new Color(0, 76, 152));
		btn_manageEvent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_manageEvent.setBorderPainted(false);
		
		designControl.setNoBorderButton(btn_manageEvent);
		btn_manageEvent.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		organizer_Manage_1_SelectEventUI_fix frame = new organizer_Manage_1_SelectEventUI_fix(organizers);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(33, 215, 255));
		panel_2.setLayout(null);

		
		JLabel lbl_judul = new JLabel("Dashboard");
		lbl_judul.setBounds(232, 11, 93, 25);
		panel_2.add(lbl_judul);
		lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		
		panel_4 = new JPanel();
		
		btn_add = new JButton("Add Event");
		btn_add.setForeground(new Color(249, 247, 247));
		btn_add.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_add.setBorderPainted(false);
		btn_add.setBackground(new Color(0, 76, 152));
		
		designControl.setNoBorderButton(btn_add);
		btn_add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		organizer_Add_1_EventUI_fix frame = new organizer_Add_1_EventUI_fix(organizers);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		btn_search = new JButton("Search Event");
		btn_search.setForeground(new Color(249, 247, 247));
		btn_search.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_search.setBorderPainted(false);
		btn_search.setBackground(new Color(0, 76, 152));
		
		designControl.setNoBorderButton(btn_search);
		btn_search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		organizer_Search_1_SelectViewEventUI_fix frame = new organizer_Search_1_SelectViewEventUI_fix(organizers);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(219, 226, 239));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(249, 247, 247));
		panel_3.setBounds(13, 11, 83, 95);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		lbl_img = new JLabel("New label");
		lbl_img.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lbl_img.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lbl_img, BorderLayout.CENTER);
		
		panel_fullName = new JPanel();
		panel_fullName.setBackground(new Color(249, 247, 247));
		panel_fullName.setBounds(106, 11, 135, 23);
		panel.add(panel_fullName);
		
		txtFullName = new JLabel(organizers.getFullName());
		txtFullName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_fullName.add(txtFullName);
		
		panel_username = new JPanel();
		panel_username.setBackground(new Color(249, 247, 247));
		panel_username.setBounds(106, 45, 135, 23);
		panel.add(panel_username);
		
		txtUsername = new JLabel(organizers.getUsername());
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_username.add(txtUsername);
		
		panel_email = new JPanel();
		panel_email.setBackground(new Color(249, 247, 247));
		panel_email.setBounds(106, 79, 135, 23);
		panel.add(panel_email);
		
		txtEmail = new JLabel(organizers.getEmail());
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel_email.add(txtEmail);
		
		btn_logout = new JButton("Logout");
		btn_logout.setForeground(new Color(249, 247, 247));
		btn_logout.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_logout.setBorderPainted(false);
		btn_logout.setBackground(new Color(0, 76, 152));
		
		designControl.setNoBorderButton(btn_logout);
		btn_logout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		_homeUI_fix frame = new _homeUI_fix();
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btn_logout, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(btn_manageEvent, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(47)
							.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_search, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_manageEvent, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btn_logout, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(89))
		);
		panel_1.setLayout(gl_panel_1);
	}

}
