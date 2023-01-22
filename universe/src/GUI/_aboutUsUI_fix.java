package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import code.DesignController;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class _aboutUsUI_fix extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private static DesignController designControl = new DesignController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_aboutUsUI_fix frame = new _aboutUsUI_fix();
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
	public _aboutUsUI_fix() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 120, 418, 134);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("< Back");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(203, 229, 255));
		btnNewButton_1.setBounds(10, 100, 100, 23);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                _homeUI_fix frame = new _homeUI_fix();
                frame.setVisible(true);
                designControl.setFrametoCenterOfScreen(frame);
            }
        });
		
		JTextPane txtpnUniverseuniversityStudent = new JTextPane();
		txtpnUniverseuniversityStudent.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnUniverseuniversityStudent.setBackground(new Color(192, 192, 192));
		txtpnUniverseuniversityStudent.setBounds(10, 35, 398, 70);
		txtpnUniverseuniversityStudent.setEditable(false);
		//		txtpnUniverseuniversityStudent.setAlignmentX(CENTER_ALIGNMENT);
		//		txtpnUniverseuniversityStudent.setAlignmentY(StyleConstants.ALIGN_CENTER);
				panel_1.add(txtpnUniverseuniversityStudent);
				txtpnUniverseuniversityStudent.setText("UNIVERSE (University Student Events) merupakan sebuah platform aplikasi\n"
						+ "yang berfungsi sebagai wadah bagi mahasiswa untuk memberikan informasi\n"
						+ "terkait event-event yang sedang diselenggarakan oleh beberapa universitas.");
				
				JLabel lblNewLabel_2 = new JLabel("UNIVERSE APP");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_2.setBounds(165, 11, 108, 14);
				panel_1.add(lblNewLabel_2);
				StyledDocument doc = txtpnUniverseuniversityStudent.getStyledDocument();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 438, 23);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("About Us");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(187, 30, 83, 17);
		contentPane.add(lblNewLabel);
		SimpleAttributeSet bSet = new SimpleAttributeSet();
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(25, 200, bSet, false);
		
		
		Image upimg = new ImageIcon(this.getClass().getResource("/img/logo_universe_transparant.png")).getImage();
		JLabel lblNewLabel_3 = new JLabel("");
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setBounds(165, 38, 100, 100);
		upimg = upimg.getScaledInstance(lblNewLabel_3.getWidth(), lblNewLabel_3.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel_3.setIcon(new ImageIcon(upimg));
	}

}
