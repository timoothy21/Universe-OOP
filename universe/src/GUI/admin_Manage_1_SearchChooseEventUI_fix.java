package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.jdbc.ResultSet;

import code.Admin;
import code.DesignController;
import code.Event;
import code.sqlConnector;

import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class admin_Manage_1_SearchChooseEventUI_fix extends JFrame {

	private static final String NULL = null;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupEvent = new ButtonGroup();
	private final ButtonGroup buttonGroupFee = new ButtonGroup();
	private static DesignController designControl = new DesignController();
	static Admin admins;
	static Event events;
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
					admin_Manage_1_SearchChooseEventUI_fix frame = new admin_Manage_1_SearchChooseEventUI_fix(admins);
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
	
	public void Filter(String Category) {
		TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>((DefaultTableModel) table.getModel());
		
		table.setRowSorter(tr);
		if(Category != NULL) {
			tr.setRowFilter(RowFilter.regexFilter(Category));
//			model = connection.showTableData(table);
		} else {
			table.setRowSorter(tr);
		}
	}
	
	public admin_Manage_1_SearchChooseEventUI_fix(Admin admins) {
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
		
		JRadioButton btnreset = new JRadioButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroupFee.clearSelection();
				buttonGroupEvent.clearSelection();
				category = harga = "";
				model.getDataVector().removeAllElements();
				model.fireTableDataChanged();
				connection.showTableData(table);
				Filter(category);
				btnreset.setSelected(false);
			}
		});
		
		btnreset.setBounds(16, 15, 100, 23);
		panel_2.add(btnreset);
		btnreset.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnreset.setBackground(new Color(249, 247, 247));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(219, 226, 239));
		panel_3.setBounds(10, 265, 114, 94);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JRadioButton btnfree = new JRadioButton("Free");
		btnfree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				harga = "Free";	
				connection.showTableData3(table, model, harga, category);
				Filter(category);
			}
		});
		btnfree.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnfree.setBackground(new Color(249, 247, 247));
		btnfree.setBounds(6, 37, 100, 23);
		panel_3.add(btnfree);
		buttonGroupFee.add(btnfree);
		
		JRadioButton btnpaid = new JRadioButton("Paid");
		btnpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				harga = "Rp";	
				connection.showTableData3(table, model, harga, category);
				Filter(category);
			}
		});
		btnpaid.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnpaid.setBackground(new Color(249, 247, 247));
		btnpaid.setBounds(6, 64, 100, 23);
		panel_3.add(btnpaid);
		buttonGroupFee.add(btnpaid);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(132, 131, 206));
		panel_5.setBounds(0, 0, 114, 30);
		panel_3.add(panel_5);
		
		JLabel lbl_fee = new JLabel("Fee");
		lbl_fee.setForeground(new Color(249, 247, 247));
		panel_5.add(lbl_fee);
		lbl_fee.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fee.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_fee.setBackground(Color.BLACK);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(219, 226, 239));
		panel_4.setBounds(10, 89, 115, 173);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBackground(new Color(132, 131, 206));
		panel_5_1.setBounds(0, 0, 114, 30);
		panel_4.add(panel_5_1);
		
		JLabel lbl_event_category = new JLabel("Event Category");
		lbl_event_category.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_event_category.setForeground(new Color(249, 247, 247));
		lbl_event_category.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lbl_event_category.setBackground(Color.BLACK);
		panel_5_1.add(lbl_event_category);
		
		JRadioButton btnpendidikan = new JRadioButton("Education");
		btnpendidikan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = "Education";
				connection.showTableData3(table, model, harga, category);
				Filter(category);
				System.out.println(category);
			}
		});
		btnpendidikan.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnpendidikan.setBackground(new Color(249, 247, 247));
		btnpendidikan.setBounds(6, 37, 100, 23);
		panel_4.add(btnpendidikan);
		buttonGroupEvent.add(btnpendidikan);
		
		JRadioButton btnTeknologi = new JRadioButton("Technology");
		btnTeknologi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = "Technology";
				connection.showTableData3(table, model, harga, category);
				Filter(category);
				System.out.println(category);
			}
		});
		btnTeknologi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnTeknologi.setBackground(new Color(249, 247, 247));
		btnTeknologi.setBounds(6, 64, 100, 23);
		panel_4.add(btnTeknologi);
		buttonGroupEvent.add(btnTeknologi);
		
		JRadioButton btnEkonomi = new JRadioButton("Economic");
		btnEkonomi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = "Economic";
				connection.showTableData3(table, model, harga, category);
				Filter(category);
				System.out.println(category);
			}
		});
		btnEkonomi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnEkonomi.setBackground(new Color(249, 247, 247));
		btnEkonomi.setBounds(6, 90, 100, 23);
		panel_4.add(btnEkonomi);
		buttonGroupEvent.add(btnEkonomi);
		
		JRadioButton btnSosial = new JRadioButton("Social");
		btnSosial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = "Social";
				connection.showTableData3(table, model, harga, category);
				Filter(category);
				System.out.println(category);
			}
		});
		btnSosial.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnSosial.setBackground(new Color(249, 247, 247));
		btnSosial.setBounds(6, 116, 100, 23);
		panel_4.add(btnSosial);
		buttonGroupEvent.add(btnSosial);
		
		JRadioButton btnInvestasi = new JRadioButton("Investation");
		btnInvestasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				category = "Investation";
				connection.showTableData3(table, model, harga, category);
				Filter(category);
				System.out.println(category);
			}
		});
		btnInvestasi.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnInvestasi.setBackground(new Color(249, 247, 247));
		btnInvestasi.setBounds(6, 143, 100, 23);
		panel_4.add(btnInvestasi);
		buttonGroupEvent.add(btnInvestasi);
		
		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBackground(new Color(33, 215, 255));
		panel_5_1_1.setBounds(10, 55, 114, 30);
		panel_1.add(panel_5_1_1);
		
		JLabel lbl_filter_option = new JLabel("Filter Option");
		lbl_filter_option.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_filter_option.setForeground(new Color(249, 247, 247));
		lbl_filter_option.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lbl_filter_option.setBackground(Color.BLACK);
		panel_5_1_1.add(lbl_filter_option);
		
		JButton btnBack = new JButton("< Back");
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(203, 229, 255));
		btnBack.setBounds(10, 363, 115, 23);
		panel_1.add(btnBack);
		
		designControl.setNoBorderButton(btnBack);
		btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		admin_0_DashboardUI_fix frame = new admin_0_DashboardUI_fix(admins);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
        	}
        });
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(134, 61, 422, 295);
		panel_1.add(scrollPane);
		
		
		
//		TableModel model = new DefaultTableModel(connection.getTableData(), connection.getTableColumn());
		
		table = new JTable();
//		table = new JTable(model);
//		table = new JTable(connection.getTableData(), connection.getTableColumn());
		model = connection.showTableData(table);
		scrollPane.setViewportView(table);
		
		JButton btnSelect = new JButton("SELECT");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
	
				String[] result = new String[model.getColumnCount()];
				for(int j = 0; j < model.getColumnCount(); j++) {
					result[j] = (String) table.getModel().getValueAt(i, j);
					System.out.println(result[j]);
				}
				
        		admin_Manage_2_DeleteUpdateEventUI_fix frame = new admin_Manage_2_DeleteUpdateEventUI_fix(admins, result);
        		frame.setVisible(true);
        		designControl.setFrametoCenterOfScreen(frame);
        		dispose();
				
			}
		});
		btnSelect.setBorderPainted(false);
		btnSelect.setBackground(new Color(203, 229, 255));
		btnSelect.setBounds(441, 363, 115, 23);
		panel_1.add(btnSelect);
		
		JLabel lblEventDesc1 = new JLabel("Event Description");
		lblEventDesc1.setBounds(217, 171, 312, 37);

		lblEventDesc1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventDesc1.setBackground(new Color(255, 255, 255));
		lblEventDesc1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}