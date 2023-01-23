package GUI;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.DefaultSingleSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.UserDataHandler;

import code.Account;
import code.DesignController;
import code.User;
import code.sqlConnector;

import java.awt.event.ActionListener;
import java.io.CharConversionException;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class _registerUI_fix extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField, confirmPasswordField;
	private JTextField usernameField, fullNameField, emailField;
	private JRadioButton userRadioButton, organizerRadioButton;
	
	private static DesignController designControl = new DesignController();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	sqlConnector connection = new sqlConnector();
	private Account account;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_registerUI_fix frame = new _registerUI_fix();
					frame.setVisible(true);
					designControl.setFrametoCenterOfScreen(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	String getRole() {
		if (userRadioButton.isSelected()) return "User";
		return "Organizer";
	}
	
	void getUserData() {
		account = new Account(
				0,
				fullNameField.getText(), 
				usernameField.getText(), 
				emailField.getText(), 
				passwordField.getText(), 
				getRole()
			);
	}
	
	void addUser() {
		
		getUserData();
		connection.openConnection();
		
		String sqlQuerry = "INSERT INTO Account(fullname, username, email, password, role) VALUES (?, ?, ?, ?, ?)";
		Object[] row = {
				account.getFullName(), 
				account.getUsername(), 
				account.getEmail(), 
				account.getPassword(), 
				account.getRole()
		};
		
		for (int i = 0; i < 5; i++)
			System.out.println(row[i]);
		
		boolean isExist = connection.checkUsername((String) row[1]);
		
		if(isExist) {
			JOptionPane.showMessageDialog(null, "Username already exist!");
		}
		else {
			connection.addDatatoServer(sqlQuerry, row.length, row); // Update to db
			dispose();
			_homeUI_fix frame = new _homeUI_fix();
			frame.setVisible(true);
			designControl.setFrametoCenterOfScreen(frame);			
		}
		
	}
	
	void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Panel 1
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(249, 247, 247));
		panel_1.setBounds(10, 11, 566, 391);
		contentPane.add(panel_1);
		
		// panel 2
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 566, 50);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(33, 215, 255));
		
		// Panel 3
		JPanel panel = new JPanel();
		panel.setBackground(new Color(219, 226, 239));
		panel.setBounds(45, 78, 478, 232);
		panel_1.add(panel);
		
		/*
		 * Register Account Title
		 */
		JLabel lbl_judul = new JLabel("Register Account");
		lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lbl_judul.setBounds(197, 11, 172, 25);
		panel_2.add(lbl_judul);
		panel_1.setLayout(null);
		panel_1.add(panel_2);
		panel.setLayout(null);
		
		/*
		 * Full Name Label
		 */
		JLabel fullNameLabel = new JLabel("Full Name");
		fullNameLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		fullNameLabel.setBounds(26, 28, 101, 14);
		panel.add(fullNameLabel);
		
		/*
		 * Full Name Field
		 */
		fullNameField = new JTextField("Input your full name ...");
		fullNameField.setBounds(26, 47, 200, 20);
		designControl.addPlaceHolderStyle(fullNameField);
		fullNameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					usernameField.requestFocus();
				}
			}
		});
		fullNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fullNameField.getText().equals("Input your full name ...")) {
					fullNameField.setText(null);
					fullNameField.requestFocus();
					designControl.removePlaceHolderStyle(fullNameField);
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (fullNameField.getText().length() == 0) {
					fullNameField.setText("Input your full name ...");
					designControl.addPlaceHolderStyle(fullNameField);
				}
			}
		});
		designControl.setNoBorderField(fullNameField);
		fullNameField.setColumns(10);
		panel.add(fullNameField);
		
		/*
		 * Username Label
		 */
		JLabel lblRegisterAccount = new JLabel("Username");
		lblRegisterAccount.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblRegisterAccount.setBounds(26, 78, 101, 14);
		panel.add(lblRegisterAccount);
		
		/*
		 * Username Field
		 */
		usernameField = new JTextField("Input your username ...");
		usernameField.setBounds(26, 97, 200, 20);
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					emailField.requestFocus();
				}
			}
		});
		usernameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (usernameField.getText().equals("Input your username ...")) {
					usernameField.setText(null);
					usernameField.requestFocus();
					designControl.removePlaceHolderStyle(usernameField);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (usernameField.getText().length() == 0) {
					usernameField.setText("Input your username ...");
					designControl.addPlaceHolderStyle(usernameField);
				}
			}
		});
		designControl.setNoBorderField(usernameField);
		usernameField.setColumns(10);
		panel.add(usernameField);
		
		/*
		 * Email Label
		 */
		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		emailLabel.setBounds(26, 123, 101, 14);
		panel.add(emailLabel);
		
		/*
		 * Email Field
		 */
		emailField = new JTextField("Input your email ...");
		emailField.setBounds(26, 142, 200, 20);
		emailField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					passwordField.requestFocus();
				}
			}
		});
		emailField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (emailField.getText().equals("Input your email ...")) {
					emailField.setText(null);
					emailField.requestFocus();
					designControl.removePlaceHolderStyle(emailField);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (emailField.getText().length() == 0) {
					emailField.setText("Input your email ...");
					designControl.addPlaceHolderStyle(emailField);
				}
			}
		});
		designControl.setNoBorderField(emailField);
		emailField.setColumns(10);
		panel.add(emailField);
		
		/*
		 * Password Label
		 */
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		passwordLabel.setBounds(240, 29, 111, 14);
		panel.add(passwordLabel);
		
		/*
		 * Password Field
		 */
		passwordField = new JPasswordField("Input your password ...");
		passwordField.setBounds(240, 47, 200, 20);
		designControl.addPlaceHolderStyle(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					confirmPasswordField.requestFocus();
				}
			}
		});
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (passwordField.getText().equals("Input your password ...")) {
					passwordField.setText(null);
					passwordField.requestFocus();
					passwordField.setEchoChar('*');
					designControl.removePlaceHolderStyle(passwordField);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (passwordField.getText().length() == 0) {
					designControl.addPlaceHolderStyle(passwordField);
					passwordField.setText("Input your password ...");
					passwordField.setEchoChar((char)0);
				}
			}
		});
		passwordField.setEchoChar((char)0);
		designControl.setNoBorderField(passwordField);
		passwordField.setColumns(10);
		panel.add(passwordField);
		
		/*
		 * Confirm Password Label
		 */
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		confirmPasswordLabel.setBounds(240, 78, 111, 14);
		panel.add(confirmPasswordLabel);
		
		/*
		 * Confirm Password Field
		 */
		confirmPasswordField = new JPasswordField("Input your confirm password ...");
		confirmPasswordField.setBounds(240, 97, 200, 20);
		confirmPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				}
			}
		});
		confirmPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (confirmPasswordField.getText().equals("Input your confirm password ...")) {
					confirmPasswordField.setText(null);
					confirmPasswordField.requestFocus();
					confirmPasswordField.setEchoChar('*');
					designControl.removePlaceHolderStyle(confirmPasswordField);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (confirmPasswordField.getText().length() == 0) {
					designControl.addPlaceHolderStyle(confirmPasswordField);
					confirmPasswordField.setText("Input your confirm password ...");
					confirmPasswordField.setEchoChar((char)0);
				}
			}
		});
		confirmPasswordField.setEchoChar((char)0);
		designControl.setNoBorderField(confirmPasswordField);
		confirmPasswordField.setColumns(10);
		panel.add(confirmPasswordField);
		
		/*
		 * 	Select Role Label
		 */
		JLabel lbl_select_role = new JLabel("Select Role");
		lbl_select_role.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lbl_select_role.setBounds(240, 124, 101, 14);
		panel.add(lbl_select_role);
		
		/*
		 * New User Radio Button
		 */
		userRadioButton = new JRadioButton("New User");
		userRadioButton.setBackground(new Color(255, 255, 255));
		userRadioButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		userRadioButton.setBounds(240, 141, 89, 20);
		panel.add(userRadioButton);
		buttonGroup.add(userRadioButton);
		
		/*
		 * Organizer Radio Button 
		 */
		organizerRadioButton = new JRadioButton("Organizer");
		organizerRadioButton.setBackground(new Color(255, 255, 255));
		organizerRadioButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		organizerRadioButton.setBounds(351, 141, 89, 20);
		panel.add(organizerRadioButton);
		buttonGroup.add(organizerRadioButton);
		
		/*
		 * Register Button
		 */
		JButton registerButton = new JButton("Register");
		registerButton.setForeground(new Color(249, 247, 247));
		registerButton.setBorderPainted(false);
		registerButton.setBackground(new Color(0, 76, 152));
		registerButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		registerButton.setBounds(158, 186, 141, 23);
		panel.add(registerButton);
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUser();
			}
		});
		designControl.setNoBorderButton(registerButton);
		
		/*
		 * Back Button
		 */
		JButton btn_back = new JButton("< Back");
		btn_back.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btn_back.setBorderPainted(false);
		btn_back.setBackground(new Color(203, 229, 255));
		btn_back.setBounds(10, 357, 100, 23);
		designControl.setNoBorderButton(btn_back);
		btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
				_homeUI_fix frame = new _homeUI_fix();
				frame.setVisible(true);
				designControl.setFrametoCenterOfScreen(frame);
        	}
        });
		panel_1.add(btn_back);
	}

	public _registerUI_fix() {
//		connection.openConnection();
		init();
	}
}
