package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import java.awt.Checkbox;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import code.DesignController;
import code.User;
import code.sqlConnector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class user_Search_2_DetailEntrollEventUI_fix extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private static DesignController designControl = new DesignController();
	static User users;
	static String[] result;
	private sqlConnector connection = new sqlConnector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					user_Search_2_DetailEntrollEventUI_fix frame = new user_Search_2_DetailEntrollEventUI_fix(users, result);
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
	public user_Search_2_DetailEntrollEventUI_fix(User users, String[] result) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
        Image img_profile = new ImageIcon(this.getClass().getResource("/img/img_event.png")).getImage();
        
        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(249, 247, 247));
        panel_1_1.setBounds(10, 11, 566, 391);
        contentPane.add(panel_1_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(new Color(33, 215, 255));
        panel_2.setBounds(0, 0, 566, 50);
        panel_1_1.add(panel_2);
        
        JLabel lbl_judul = new JLabel("Detail Event");
        lbl_judul.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_judul.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lbl_judul.setBounds(218, 11, 115, 25);
        panel_2.add(lbl_judul);
        
        JButton btn_back = new JButton("< Back");
        btn_back.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_back.setBorderPainted(false);
        btn_back.setBackground(new Color(203, 229, 255));
        btn_back.setBounds(27, 342, 100, 23);
        panel_1_1.add(btn_back);
        
		designControl.setNoBorderButton(btn_back);
		btn_back.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		user_Search_1_SelectEventUI_fix frame = new user_Search_1_SelectEventUI_fix(users);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
        
        JButton btn_enroll = new JButton("ENROLL");
        btn_enroll.setForeground(new Color(249, 247, 247));
        btn_enroll.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_enroll.setBorderPainted(false);
        btn_enroll.setBackground(new Color(0, 76, 152));
        btn_enroll.setBounds(442, 343, 100, 23);
        panel_1_1.add(btn_enroll);
        
		designControl.setNoBorderButton(btn_enroll);
		btn_enroll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				connection.openConnection();
				
				Object[] row = {
						users.getID(),
						Integer.parseInt(result[1])
				};
				
				boolean isExist = connection.checkEnrolledEvent(users.getID(), (Integer) row[1]);
				
				if(isExist) {
					JOptionPane.showMessageDialog(null, "Event already enrolled!");
				}
				else {
					System.out.println( users.getID() + " || " + result[1]);
					
					String sqlQuerry = "INSERT INTO enrolledevent(id_account, id_event) VALUES (?, ?)";
					
					connection.addDatatoServerEnroll(sqlQuerry, row.length, row); // Update to db
					
					
					String querrySQL = "UPDATE event SET "
							+ "quota = ? WHERE id_event = ?";
//        		
					int updateQuota = Integer.parseInt(result[4]) + 1;
					
					connection.updateEvent2(querrySQL, 1, updateQuota, row[1]);
					
					user_0_DashboardUI_fix frame = new user_0_DashboardUI_fix(users);
//				user_Search_1_SelectEventUI_fix frame = new user_Search_1_SelectEventUI_fix(users);
					frame.setVisible(true);
					designControl.setFrametoCenterOfScreen(frame);
					dispose();					
				}
				
        	}
        });
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(219, 226, 239));
        panel_3.setBounds(27, 73, 513, 244);
        panel_1_1.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lbl_img_event = new JLabel("img_event");
        lbl_img_event.setBounds(228, 20, 69, 36);
        panel_3.add(lbl_img_event);
        lbl_img_event.setVerticalAlignment(SwingConstants.TOP);
        lbl_img_event.setHorizontalAlignment(SwingConstants.LEFT);
        img_profile = img_profile.getScaledInstance(lbl_img_event.getWidth(), lbl_img_event.getHeight(), Image.SCALE_SMOOTH);
        lbl_img_event.setIcon(new ImageIcon(img_profile));
        
        JPanel panel_event_title = new JPanel();
        panel_event_title.setLayout(null);
        panel_event_title.setBackground(Color.WHITE);
        panel_event_title.setBounds(10, 75, 238, 43);
        panel_3.add(panel_event_title);
        
        JTextArea textArea_event_title = new JTextArea(result[8]);
        textArea_event_title.setLineWrap(true);
        textArea_event_title.setEditable(false);
        textArea_event_title.setAlignmentX(0.5f);
        textArea_event_title.setBounds(5, 5, 228, 32);
        panel_event_title.add(textArea_event_title);
        
        JPanel panel_event_desc = new JPanel();
        panel_event_desc.setLayout(null);
        panel_event_desc.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel_event_desc.setBackground(Color.WHITE);
        panel_event_desc.setBounds(10, 129, 238, 104);
        panel_3.add(panel_event_desc);
        
        JTextArea textArea_event_desc = new JTextArea(result[9]);
        textArea_event_desc.setWrapStyleWord(true);
        textArea_event_desc.setLineWrap(true);
        textArea_event_desc.setEditable(false);
        textArea_event_desc.setBounds(5, 22, 228, 82);
        panel_event_desc.add(textArea_event_desc);
        
        JLabel lbl_event_desc = new JLabel("Event Description");
        lbl_event_desc.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_event_desc.setBounds(10, 5, 218, 14);
        panel_event_desc.add(lbl_event_desc);
        
        JPanel panel_organizer = new JPanel();
        panel_organizer.setLayout(null);
        panel_organizer.setBackground(Color.WHITE);
        panel_organizer.setBounds(264, 75, 116, 20);
        panel_3.add(panel_organizer);
        
        JLabel lbl_organizer = new JLabel(result[2]);
        lbl_organizer.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_organizer.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        lbl_organizer.setBounds(0, 0, 116, 20);
        panel_organizer.add(lbl_organizer);
        
        JPanel panel_event_category = new JPanel();
        panel_event_category.setLayout(null);
        panel_event_category.setBackground(Color.WHITE);
        panel_event_category.setBounds(264, 98, 116, 20);
        panel_3.add(panel_event_category);
        
        JLabel lbl_event_category = new JLabel(result[3]);
        lbl_event_category.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_event_category.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        lbl_event_category.setBounds(0, 0, 116, 20);
        panel_event_category.add(lbl_event_category);
        
        JPanel panel_step_by_step = new JPanel();
        panel_step_by_step.setLayout(null);
        panel_step_by_step.setBackground(Color.WHITE);
        panel_step_by_step.setBounds(264, 129, 239, 104);
        panel_3.add(panel_step_by_step);
        
        JTextArea textArea_step_by_step = new JTextArea(result[7]);
        textArea_step_by_step.setWrapStyleWord(true);
        textArea_step_by_step.setLineWrap(true);
        textArea_step_by_step.setEditable(false);
        textArea_step_by_step.setBounds(5, 22, 229, 82);
        panel_step_by_step.add(textArea_step_by_step);
        
        JLabel lbl_event_step_by_step = new JLabel("Step by Step");
        lbl_event_step_by_step.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_event_step_by_step.setBounds(10, 5, 218, 14);
        panel_step_by_step.add(lbl_event_step_by_step);
        
        JPanel panel_event_category_1 = new JPanel();
        panel_event_category_1.setLayout(null);
        panel_event_category_1.setBackground(Color.WHITE);
        panel_event_category_1.setBounds(390, 75, 116, 20);
        panel_3.add(panel_event_category_1);
        
        JLabel lbl_capacity = new JLabel(result[5]);
        lbl_capacity.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_capacity.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        lbl_capacity.setBounds(69, 0, 47, 20);
        panel_event_category_1.add(lbl_capacity);
        
        JLabel lbl_quota = new JLabel(result[4]);
        lbl_quota.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_quota.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        lbl_quota.setBounds(0, 0, 47, 20);
        panel_event_category_1.add(lbl_quota);
        
        JLabel lbl_pembatas = new JLabel("/");
        lbl_pembatas.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_pembatas.setBounds(50, 2, 18, 14);
        panel_event_category_1.add(lbl_pembatas);
        
        JPanel panel_event_category_2 = new JPanel();
        panel_event_category_2.setLayout(null);
        panel_event_category_2.setBackground(Color.WHITE);
        panel_event_category_2.setBounds(390, 98, 116, 20);
        panel_3.add(panel_event_category_2);
        
        JLabel lbl_info_fee = new JLabel(result[6]);
        lbl_info_fee.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_info_fee.setFont(new Font("Segoe UI", Font.PLAIN, 9));
        lbl_info_fee.setBounds(0, 0, 116, 20);
        panel_event_category_2.add(lbl_info_fee);
	}
}
