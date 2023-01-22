package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class _1_punya_novel_ContactUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_1_punya_novel_ContactUs frame = new _1_punya_novel_ContactUs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public _1_punya_novel_ContactUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image img = new ImageIcon(this.getClass().getResource("logowhatsapp_pic.png")).getImage();
		
		JList list = new JList();
		list.setToolTipText("sdcc");
		list.setBackground(new Color(0, 0, 0));
		list.setBounds(348, 176, 80, -98);
		contentPane.add(list);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 438, 23);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Contact");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(180, 30, 83, 17);
		contentPane.add(lblNewLabel);
		
		Image upimg = new ImageIcon(this.getClass().getResource("/img/logouniverse_pic.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(155, 45, 100, 100);
		upimg = upimg.getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(upimg));
		
		JTextPane txtpnHowCanWe = new JTextPane();
		txtpnHowCanWe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnHowCanWe.setBackground(new Color(240, 240, 240));
		txtpnHowCanWe.setText("How Can We Help You?");
		txtpnHowCanWe.setBounds(10, 130, 165, 20);
		contentPane.add(txtpnHowCanWe);
		
		JTextPane txtpnContactUsWith = new JTextPane();
		txtpnContactUsWith.setBackground(new Color(240, 240, 240));
		txtpnContactUsWith.setText("Contact us with any questions or inquiries by click the button.\n"
				+ "We'd be happy to answer your questions and set up a meeting with you.");
		txtpnContactUsWith.setBounds(10, 160, 428, 55);
		contentPane.add(txtpnContactUsWith);
		
		JButton btnNewButton = new JButton("Contact Us");
//		btnNewButton.setIcon(new ImageIcon("C:\\Users\\USER\\Downloads\\logowhatsapp2_pic-removebg-preview2.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://wa.me/+6287820232260?text=Admin%20Annin").toURI());
				}catch(Exception ex) {
					
				}
			}
		});
		btnNewButton.setBounds(320, 225, 100, 23);
		contentPane.add(btnNewButton);
	}
}