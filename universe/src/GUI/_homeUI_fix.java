package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultSingleSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.DesignController;

import javax.swing.SpringLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class _homeUI_fix extends JFrame {

	private JPanel contentPane;
	private static DesignController designControl = new DesignController();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_homeUI_fix frame = new _homeUI_fix();
					frame.setVisible(true);
					designControl.setFrametoCenterOfScreen(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * About Us Button
		 */
		
		/*
		 * Contact Button
		 */
		
		/*
		 * Sign Up Button
		 */
		
		/*
		 * Sign In Button
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
        
        JLabel lbl_judul = new JLabel("Home");
        lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lbl_judul.setBounds(232, 11, 93, 25);
        panel_2.add(lbl_judul);
        panel_1.add(panel_2);
        
        JLabel lbl_img_universe = new JLabel("New label");
        lbl_img_universe.setBounds(102, 163, 173, 139);
        panel_1.add(lbl_img_universe);
        lbl_img_universe.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_img_universe.setHorizontalAlignment(SwingConstants.LEFT);
        Image img_profile = new ImageIcon(this.getClass().getResource("/img/logo_universe_transparant.png")).getImage();
        img_profile = img_profile.getScaledInstance(lbl_img_universe.getWidth(), lbl_img_universe.getHeight(), Image.SCALE_SMOOTH);
        lbl_img_universe.setIcon(new ImageIcon(img_profile));
        
        JLabel title = new JLabel("UNIVERSE");
        title.setBounds(102, 113, 173, 50);
        panel_1.add(title);
        title.setFont(new Font("Broadway", Font.PLAIN, 32));
        JButton btn_sign_up = new JButton("Sign Up");
        btn_sign_up.setForeground(new Color(249, 247, 247));
        btn_sign_up.setBorderPainted(false);
        btn_sign_up.setBackground(new Color(0, 76, 152));
        btn_sign_up.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_sign_up.setBounds(329, 263, 125, 39);
        panel_1.add(btn_sign_up);
        designControl.setNoBorderButton(btn_sign_up);
        JButton btn_sign_in = new JButton("Sign In");
        btn_sign_in.setForeground(new Color(249, 247, 247));
        btn_sign_in.setBorderPainted(false);
        btn_sign_in.setBackground(new Color(0, 76, 152));
        btn_sign_in.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_sign_in.setBounds(329, 213, 125, 39);
        panel_1.add(btn_sign_in);
        designControl.setNoBorderButton(btn_sign_in);
        JButton btn_contact = new JButton("Contact");
        btn_contact.setForeground(new Color(249, 247, 247));
        btn_contact.setBorderPainted(false);
        btn_contact.setBackground(new Color(0, 76, 152));
        btn_contact.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_contact.setBounds(329, 163, 125, 39);
        panel_1.add(btn_contact);
        designControl.setNoBorderButton(btn_contact);
        
        JButton btn_about_us = new JButton("About Us");
        btn_about_us.setBorderPainted(false);
        btn_about_us.setForeground(new Color(249, 247, 247));
        btn_about_us.setBackground(new Color(0, 76, 152));
        btn_about_us.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_about_us.setBounds(329, 113, 125, 39);
        panel_1.add(btn_about_us);
        designControl.setNoBorderButton(btn_about_us);
        btn_about_us.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		_aboutUsUI_fix frame = new _aboutUsUI_fix();
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
        btn_contact.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// contact page here
        		_contactUI_fix frame = new _contactUI_fix();
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
        btn_sign_in.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		_loginUI_fix frame = new _loginUI_fix();
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
        btn_sign_up.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		_registerUI_fix frame = new _registerUI_fix();
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
	}
	
	public _homeUI_fix() {
		init();
	}

}
