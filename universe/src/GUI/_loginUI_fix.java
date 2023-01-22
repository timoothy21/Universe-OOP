package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.management.remote.rmi.RMIServer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import code.Admin;
import code.DesignController;
import code.Organizer;
import code.User;
import code.sqlConnector;
//import testing.UserData;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;

public class _loginUI_fix extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JPasswordField textField_password;
	private static DesignController designControl = new DesignController();
	sqlConnector connection = new sqlConnector();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_loginUI_fix frame = new _loginUI_fix();
					frame.setVisible(true);
					designControl.setFrametoCenterOfScreen(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void checkUser() {
		String getUsername = textField_username.getText();
		String getPassword = textField_password.getText();
		
//		System.out.println(getUsername);
//		System.out.println(getPassword);
		
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			String querrySQL = "SELECT * FROM Account WHERE username = '" + getUsername + "' AND password = '" + getPassword + "'";
			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
			if(rs.next()) {
				// berhasil login 
//				System.out.println("masuk sini123 asik");
				System.out.println(rs.getString(6));
				
				if(rs.getString(6).contentEquals("User")) {
					User users = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					System.out.println("ini user");
					user_0_DashboardUI_fix frame = new user_0_DashboardUI_fix(users);
	        		frame.setVisible(true);
	        		designControl.setFrametoCenterOfScreen(frame);
	        		dispose();
				} else if(rs.getString(6).contentEquals("Admin")) {
					Admin admins = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					System.out.println("ini admin");
					admin_0_DashboardUI_fix frame = new admin_0_DashboardUI_fix(admins);
	        		frame.setVisible(true);
	        		designControl.setFrametoCenterOfScreen(frame);
	        		dispose();
				} else if(rs.getString(6).contentEquals("Organizer")) {
					Organizer organizers = new Organizer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
					System.out.println("ini organizer");
					organizer_0_DashboardUI_fix frame = new organizer_0_DashboardUI_fix(organizers);
	        		frame.setVisible(true);
	        		designControl.setFrametoCenterOfScreen(frame);
	        		dispose();
				}
				
			}else {
				// gagal login
				JOptionPane.showMessageDialog(null, "Invalid username or password!", "Error!", JOptionPane.ERROR_MESSAGE);
				textField_username.setText("");
				textField_password.setText("");
				textField_username.requestFocus();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		/*
		 * Login Title
		 */
		contentPane.setLayout(null);
		
		/*
		 * Username Label
		 */
		
		/*
		 * Username Field
		 */
		
		/*
		 * Password Label
		 */
		
		/*
		 * Password Field
		 */
		
		/*
		 * Login Button
		 */
		
		/*
		 * Back Button
		 */
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 247, 247));
		panel_1.setBounds(10, 11, 566, 391);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 566, 50);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(33, 215, 255));
		panel_1.add(panel_2);
		
		JLabel lbl_judul = new JLabel("Login");
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_judul.setBounds(232, 11, 93, 25);
		panel_2.add(lbl_judul);
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_username.setBounds(284, 123, 200, 14);
		panel_1.add(lbl_username);
		textField_username = new JTextField();
		textField_username.setBounds(284, 148, 200, 20);
		panel_1.add(textField_username);
		designControl.setNoBorderField(textField_username);
		textField_username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					textField_password.requestFocus();
				}
			}
		});
		textField_username.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_username.getText().equals("Input your username ...")) {
					textField_username.setText(null);
					textField_username.requestFocus();
					designControl.removePlaceHolderStyle(textField_username);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textField_username.getText().length() == 0) {
					textField_username.setText("Input your username ...");
					designControl.addPlaceHolderStyle(textField_username);
				}
			}
		});
		textField_username.setColumns(10);
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_password.setBounds(284, 179, 200, 14);
		panel_1.add(lbl_password);
		textField_password = new JPasswordField();
		textField_password.setBounds(284, 204, 200, 20);
		panel_1.add(textField_password);
		designControl.setNoBorderField(textField_password);
		textField_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				}
			}
		});
		textField_password.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField_password.getText().equals("Input your password ...")) {
					textField_password.setText(null);
					textField_password.requestFocus();
					textField_password.setEchoChar('*');
					designControl.removePlaceHolderStyle(textField_password);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textField_password.getText().length() == 0) {
					designControl.addPlaceHolderStyle(textField_password);
					textField_password.setText("Input your password ...");
					textField_password.setEchoChar((char)0);
				}
			}
		});
		textField_password.setEchoChar((char)0);
		JButton btn_login = new JButton("Login");
		btn_login.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_login.setForeground(new Color(249, 247, 247));
		btn_login.setBackground(new Color(0, 76, 152));
		
		btn_login.setBorderPainted(false);
		btn_login.setBounds(284, 243, 200, 23);
		panel_1.add(btn_login);
		designControl.setNoBorderButton(btn_login);
		
//		perlu check user ini role nya apa
//		di sini baru arahin dulu ke dashboard role admin aja
		
		btn_login.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		checkUser();
        	}
        });
		
		
		JButton btn_back = new JButton("< Back");
		btn_back.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_back.setBorderPainted(false);
		btn_back.setBackground(new Color(203, 229, 255));
		btn_back.setBounds(27, 342, 100, 23);
		panel_1.add(btn_back);
		designControl.setNoBorderButton(btn_back);
		btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		_homeUI_fix frame = new _homeUI_fix();
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		
		JLabel lbl_img_universe = new JLabel("New label");
		lbl_img_universe.setBounds(82, 153, 173, 139);
		lbl_img_universe.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbl_img_universe);
		
        lbl_img_universe.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_img_universe.setHorizontalAlignment(SwingConstants.LEFT);
        Image img_profile = new ImageIcon(this.getClass().getResource("/img/logo_universe_transparant.png")).getImage();
        img_profile = img_profile.getScaledInstance(lbl_img_universe.getWidth(), lbl_img_universe.getHeight(), Image.SCALE_SMOOTH);
        lbl_img_universe.setIcon(new ImageIcon(img_profile));
		
		JLabel title = new JLabel("UNIVERSE");
		title.setBounds(82, 103, 173, 50);
		title.setFont(new Font("Broadway", Font.PLAIN, 32));
		panel_1.add(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(219, 226, 239));
		panel.setBounds(265, 103, 240, 189);
		panel_1.add(panel);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
	}


	public _loginUI_fix() {
//		connection.openConnection();
		init();
	}
}
