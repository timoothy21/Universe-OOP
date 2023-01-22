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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class _1_punya_novel_aboutUs extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_1_punya_novel_aboutUs frame = new _1_punya_novel_aboutUs();
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
	public _1_punya_novel_aboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 438, 23);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("About App");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(180, 30, 83, 17);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(52, 135, 338, 100);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("UNIVERSE APP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(120, 5, 108, 14);
		panel_1.add(lblNewLabel_2);
		
		JTextPane txtpnUniverseuniversityStudent = new JTextPane();
		txtpnUniverseuniversityStudent.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnUniverseuniversityStudent.setBackground(new Color(192, 192, 192));
		txtpnUniverseuniversityStudent.setBounds(10, 30, 318, 70);
//		txtpnUniverseuniversityStudent.setAlignmentX(CENTER_ALIGNMENT);
//		txtpnUniverseuniversityStudent.setAlignmentY(StyleConstants.ALIGN_CENTER);
		panel_1.add(txtpnUniverseuniversityStudent);
		txtpnUniverseuniversityStudent.setText("UNIVERSE (University Student Events) merupakan\n"
				+ "sebuah platform aplikasi yang berfungsi sebagai wadah bagi\n"
				+ "mahasiswa untuk memberikan informasi terkait event-event\n"
				+ "yang sedang diselenggarakan oleh beberapa universitas.");
		SimpleAttributeSet bSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		StyledDocument doc = txtpnUniverseuniversityStudent.getStyledDocument();
		doc.setParagraphAttributes(25, 200, bSet, false);
		
		
		Image upimg = new ImageIcon(this.getClass().getResource("/img/logouniverse_pic.png")).getImage();
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setBounds(165, 45, 100, 100);
		upimg = upimg.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(upimg));
	}
}