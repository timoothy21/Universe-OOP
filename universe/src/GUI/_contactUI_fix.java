package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import code.DesignController;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class _contactUI_fix extends JFrame {

	private JPanel contentPane;
	private static DesignController designControl = new DesignController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_contactUI_fix frame = new _contactUI_fix();
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
	public _contactUI_fix() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JButton btn_back = new JButton("< Back");
//		btn_back.setBounds(27, 227, 71, 25);
//		btn_back.setFont(new Font("Segoe UI", Font.BOLD, 12));
//		btn_back.setBorderPainted(false);
//		btn_back.setBackground(new Color(203, 229, 255));
//		contentPane.add(btn_back);
//		
//		designControl.setNoBorderButton(btn_back);
//		btn_back.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				_homeUI_fix frame = new _homeUI_fix();
//				frame.setVisible(true);
//				designControl.setFrametoCenterOfScreen(frame);
//				dispose();
//			}
//		});
//		
//		JLabel lblNewLabel = new JLabel("CONTACT US");
//		lblNewLabel.setBounds(192, 48, 83, 14);
//		contentPane.add(lblNewLabel);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//			
//		JList list = new JList();
//		list.setToolTipText("sdcc");
//		list.setBackground(new Color(0, 0, 0));
//		list.setBounds(348, 176, 80, -98);
//		contentPane.add(list);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(192, 192, 192));
//		panel.setBounds(0, 0, 438, 23);
//		contentPane.add(panel);
//		
//		JLabel lblNewLabel = new JLabel("Contact Us");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNewLabel.setBounds(182, 25, 83, 17);
//		contentPane.add(lblNewLabel);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(Color.LIGHT_GRAY);
//		panel_1.setBounds(10, 53, 199, 201);
//		contentPane.add(panel_1);
//		panel_1.setLayout(null);
//		
//		JTextPane textPane = new JTextPane();
//		textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		textPane.setForeground(new Color(63, 114, 175));
//		textPane.setBackground(new Color(192, 192, 192));
//		textPane.setText("+62-831-3716-8027");
//		textPane.setBounds(46, 167, 111, 23);
//		panel_1.add(textPane);
//		
//		JTextPane txtpnHowCanWe = new JTextPane();
//		txtpnHowCanWe.setBounds(54, 52, 103, 23);
//		panel_1.add(txtpnHowCanWe);
//		txtpnHowCanWe.setFont(new Font("Tahoma", Font.BOLD, 12));
//		txtpnHowCanWe.setBackground(new Color(192, 192, 192));
//		txtpnHowCanWe.setText("Talk to Sales");
//		
//		JTextPane txtpnContactUsWith = new JTextPane();
//		txtpnContactUsWith.setBounds(10, 85, 179, 69);
//		panel_1.add(txtpnContactUsWith);
//		txtpnContactUsWith.setBackground(new Color(192, 192, 192));
//		txtpnContactUsWith.setText("Interested in working with\n UNIVERSE? Contact "
//				+ "the admin\n with the following "
//				+ "number for\n further discussion.");
//		
//		Image upimg = new ImageIcon(this.getClass().getResource("/img/logotelepon_pic.png")).getImage();
//		JLabel lblNewLabel_3 = new JLabel("");
//		lblNewLabel_3.setBounds(71, 10, 50, 43);
//		panel_1.add(lblNewLabel_3);
//		upimg = upimg.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
//		lblNewLabel_3.setIcon(new ImageIcon(upimg));
//	
//		SimpleAttributeSet bSet = new SimpleAttributeSet();
//		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
//		StyledDocument doc = txtpnContactUsWith.getStyledDocument();
//		doc.setParagraphAttributes(25, 200, bSet, false);
//		
//		JPanel panel_1_1 = new JPanel();
//		panel_1_1.setBackground(Color.LIGHT_GRAY);
//		panel_1_1.setBounds(229, 53, 199, 201);
//		contentPane.add(panel_1_1);
//		panel_1_1.setLayout(null);
//		
//		JTextPane txtpnContactCustomerSupporter = new JTextPane();
//		txtpnContactCustomerSupporter.setBounds(7, 52, 210, 23);
//		txtpnContactCustomerSupporter.setText("Contact Customer Supporter");
//		txtpnContactCustomerSupporter.setFont(new Font("Tahoma", Font.BOLD, 12));
//		txtpnContactCustomerSupporter.setBackground(Color.LIGHT_GRAY);
//		panel_1_1.add(txtpnContactCustomerSupporter);
//		
//		JTextPane txtpnDoYouHave = new JTextPane();
//		txtpnDoYouHave.setBounds(10, 85, 179, 69);
//		txtpnDoYouHave.setText(" Do you have any problem?\n"
//				+ "We'd love to hear from you ");
//		txtpnDoYouHave.setBackground(Color.LIGHT_GRAY);
//		panel_1_1.add(txtpnDoYouHave);
//		
//		JButton btnNewButton = new JButton("Whatsapp");
//		btnNewButton.setForeground(new Color(0, 0, 0));
//		btnNewButton.setBackground(new Color(63, 114, 175));
//		btnNewButton.setBounds(49, 167, 100, 23);
//		panel_1_1.add(btnNewButton);
//		
//		Image upimg2 = new ImageIcon(this.getClass().getResource("/img/logowhatsapp_pic.png")).getImage();
//		JLabel lblNewLabel_5 = new JLabel("");
//		lblNewLabel_5.setBounds(73, 10, 43, 43);
//		panel_1_1.add(lblNewLabel_5);
//		upimg2 = upimg2.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH);
//		lblNewLabel_5.setIcon(new ImageIcon(upimg2));
//		
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Desktop.getDesktop().browse(new URL("https://wa.me/6283137168027?text=Halo%20Customer%20Supporter%20UNIVERSE,%20minta%20tolong%20dibantu%20dengan%20kendala%20saya%20yaitu ").toURI());
//				}catch(Exception ex) {
//					
//				}
//			}
//		});
//		
//		SimpleAttributeSet bSet2 = new SimpleAttributeSet();
//		StyleConstants.setAlignment(bSet2, StyleConstants.ALIGN_CENTER);
//		StyledDocument doc2 = txtpnDoYouHave.getStyledDocument();
//		doc2.setParagraphAttributes(25, 200, bSet2, false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
		JList list = new JList();
		list.setToolTipText("sdcc");
		list.setBackground(new Color(0, 0, 0));
		list.setBounds(348, 176, 80, -98);
		contentPane.add(list);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 438, 23);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Contact Us");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(182, 25, 83, 17);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 53, 199, 201);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(203, 229, 255));
		btnNewButton_1.setBounds(7, 172, 100, 23);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                _homeUI_fix frame = new _homeUI_fix();
                frame.setVisible(true);
                designControl.setFrametoCenterOfScreen(frame);
            }
        });
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPane.setForeground(new Color(63, 114, 175));
		textPane.setBackground(new Color(192, 192, 192));
		textPane.setText("+62-831-3716-8027");
		textPane.setBounds(46, 140, 111, 23);
		panel_1.add(textPane);
		
		JTextPane txtpnHowCanWe = new JTextPane();
		txtpnHowCanWe.setBounds(54, 53, 103, 23);
		panel_1.add(txtpnHowCanWe);
		txtpnHowCanWe.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnHowCanWe.setBackground(new Color(192, 192, 192));
		txtpnHowCanWe.setText("Talk to Sales");
		
		JTextPane txtpnContactUsWith = new JTextPane();
		txtpnContactUsWith.setBounds(10, 75, 179, 69);
		panel_1.add(txtpnContactUsWith);
		txtpnContactUsWith.setBackground(new Color(192, 192, 192));
		txtpnContactUsWith.setText("Interested in working with\n UNIVERSE? Contact "
				+ "the admin\n with the following "
				+ "number.");
		
		Image upimg = new ImageIcon(this.getClass().getResource("/img/logotelepon_pic.png")).getImage();
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(73, 7, 50, 43);
		panel_1.add(lblNewLabel_3);
		upimg = upimg.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(upimg));
	
		SimpleAttributeSet bSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		StyledDocument doc = txtpnContactUsWith.getStyledDocument();
		doc.setParagraphAttributes(25, 200, bSet, false);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(229, 53, 199, 201);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JTextPane txtpnContactCustomerSupporter = new JTextPane();
		txtpnContactCustomerSupporter.setBounds(7, 53, 210, 23);
		txtpnContactCustomerSupporter.setText("Contact Customer Supporter");
		txtpnContactCustomerSupporter.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnContactCustomerSupporter.setBackground(Color.LIGHT_GRAY);
		panel_1_1.add(txtpnContactCustomerSupporter);
		
		JTextPane txtpnDoYouHave = new JTextPane();
		txtpnDoYouHave.setBounds(10, 75, 179, 69);
		txtpnDoYouHave.setText(" Do you have any problem?\n"
				+ "We'd love to hear from you. ");
		txtpnDoYouHave.setBackground(Color.LIGHT_GRAY);
		panel_1_1.add(txtpnDoYouHave);
		
		JButton btnNewButton = new JButton("Whatsapp");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setBounds(49, 140, 100, 23);
		panel_1_1.add(btnNewButton);
		
		Image upimg2 = new ImageIcon(this.getClass().getResource("/img/logowhatsapp_pic.png")).getImage();
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(73, 7, 43, 43);
		panel_1_1.add(lblNewLabel_5);
		upimg2 = upimg2.getScaledInstance(lblNewLabel_5.getWidth(), lblNewLabel_5.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_5.setIcon(new ImageIcon(upimg2));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://wa.me/6283137168027?text=Halo%20Customer%20Supporter%20UNIVERSE,%20minta%20tolong%20dibantu%20dengan%20kendala%20saya%20yaitu ").toURI());
				}catch(Exception ex) {
					
				}
			}
		});
		
		SimpleAttributeSet bSet2 = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet2, StyleConstants.ALIGN_CENTER);
		StyledDocument doc2 = txtpnDoYouHave.getStyledDocument();
		doc2.setParagraphAttributes(25, 200, bSet2, false);
	}

}
