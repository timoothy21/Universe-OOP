package code;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSet;

//import com.mysql.jdbc.ResultSet;

public class sqlConnector {

	public Connection con;
	public PreparedStatement preparedStatement;
	public ResultSet rs;
	private final String dbName = "universe";
	
	// Open Connection
	public void openConnection() {
		try {
			// Open Connection
			Class.forName("com.mysql.jdbc.Driver"); // External lib
			String url = "jdbc:mysql://localhost:3307/" + dbName; // 33006 is default
			String username = "root", pass = "";
			con = DriverManager.getConnection(url, username, pass);
			if(con != null) {
				System.out.println("connected");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Failed to connect!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
//	
	// Close Connetion
	public void closeConnection() {
		try {			
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to close connection!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
//	check account
    public boolean checkUsername(String username) {
        openConnection();
    	boolean exists = false;
        try {
        	preparedStatement = con.prepareStatement("SELECT username FROM account WHERE username = ?");
        			
            preparedStatement.setString(1, username);
            try (ResultSet rs = (ResultSet) preparedStatement.executeQuery()) {
                exists = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
    
//    check enroll
    public boolean checkEnrolledEvent(Integer idAccount, Integer idEvent) {
        openConnection();
    	boolean exists = false;
        try {
        	preparedStatement = con.prepareStatement("SELECT * FROM enrolledevent WHERE id_account = ? AND id_event = ?");
        	
        	preparedStatement.setInt(1, idAccount);
            preparedStatement.setInt(2, idEvent);
            try (ResultSet rs = (ResultSet) preparedStatement.executeQuery()) {
                exists = rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
	
	
//	
	// Add Data
	public void addDatatoServer(String querry, int countValue, Object[] values) {
		try {
			
			preparedStatement = con.prepareStatement(querry);
			
			for (int i = 1; i <= countValue; ++i) {
				if (values[i-1] instanceof Integer) preparedStatement.setInt(i, Integer.parseInt((String) values[i-1]));
				else if (values[i-1] instanceof String || values[i-1] instanceof Character) preparedStatement.setString(i, (String) values[i-1]);
				else {
					JOptionPane.showConfirmDialog(null, "Unknow data type!", "Error!", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
			preparedStatement.executeUpdate();

			JOptionPane.showMessageDialog(null, "New User Successfully Added!");
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Something's wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
    public void addDatatoServerEvent(String querry, int countValue, Object[] values) {
        try {
            
            preparedStatement = con.prepareStatement(querry);
            
            preparedStatement.setInt(1, (int) values[0]);
            preparedStatement.setString(2, (String) values[1]);
            preparedStatement.setString(3, (String) values[2]);
            preparedStatement.setInt(4, (int) values[3]);
            preparedStatement.setInt(5, (int) values[4]);
            preparedStatement.setString(6, (String) values[5]);
            preparedStatement.setString(7, (String) values[6]);
            preparedStatement.setString(8, (String) values[7]);
            preparedStatement.setString(9, (String) values[8]);
            
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "New Event Successfully Added!");
            
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Something's wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void addDatatoServerEnroll(String querry, int countValue, Object[] values) {
        try {
            
            System.out.println("coba connect");
            
            preparedStatement = con.prepareStatement(querry);
            preparedStatement.setInt(1, (int) values[0]);
            preparedStatement.setInt(2, (int) values[1]);
            
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "New User Successfully Added!");
            
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Something's wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
//	
//	// Delete Data
	public void deleteEvent(String querry, Integer id_event) {
		openConnection();
        try {
        	preparedStatement = con.prepareStatement(querry);
        	System.out.println("berhasil dipersiapin");
            preparedStatement.setInt(1, id_event);
            System.out.println("ini query sqlcon: " + querry);
            preparedStatement.executeUpdate();
            System.out.println("ini id_event: " + id_event);
//            con.commit();
            JOptionPane.showMessageDialog(null, "Successfully Delete!!");
        } catch (SQLException e2) {
        	System.out.println(e2.getMessage());
            JOptionPane.showMessageDialog(null, "Cannot Delete!\nSomething's wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
	}
//	
//	// Update Data
//  // Update Data
	  public void updateEvent(String querry, int countValue, Object[] values) {
	      try {
	          preparedStatement = con.prepareStatement(querry);
	          
	          for (int i = 1; i <= countValue; ++i) {
	              if (values[i-1] instanceof Integer) preparedStatement.setInt(i, Integer.parseInt(values[i-1].toString()));
	              else if (values[i-1] instanceof String || values[i-1] instanceof Character) preparedStatement.setString(i, values[i-1].toString());
	              else {
	                  JOptionPane.showConfirmDialog(null, "Unknow data type!", "Error!", JOptionPane.ERROR_MESSAGE);
	                  return;
	              }
	          }
	          
	          preparedStatement.executeUpdate();
	          JOptionPane.showMessageDialog(null, "Successfully Update!!");
	      } catch (SQLException e2) {
	          System.out.println(e2.getMessage());
	          JOptionPane.showMessageDialog(null, "Cannot Delete!\nSomething's wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
	      }
	  }
	  
	  public void updateEvent2(String querry, int countValue, int values, Object row) {
	      try {
	          preparedStatement = con.prepareStatement(querry);
	          
	          preparedStatement.setInt(1, values);
	          preparedStatement.setInt(2, (int) row);
	          
	          System.out.println(values);
	          System.out.println(row);
	          
	          preparedStatement.executeUpdate();
	          JOptionPane.showMessageDialog(null, "Successfully Update!!");
	      } catch (SQLException e2) {
	          System.out.println(e2.getMessage());
	          JOptionPane.showMessageDialog(null, "Cannot Delete!\nSomething's wrong!", "Error!", JOptionPane.ERROR_MESSAGE);
	      }
	  }
	
//	
//	// Remove Data
//
	// Table for event
	public Object[] getTableColumn() {
		sqlConnector connection = new sqlConnector();
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			String querrySQL = "SELECT * FROM event";
			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
			int count = rs.getMetaData().getColumnCount();
			Object[] columnNames = new Object[count];
			for(int i = 1; i <= count; i++) {
				columnNames[i-1] = rs.getMetaData().getColumnLabel(i);
			}
			return columnNames;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
	}
	
	public Integer getRow() {
		sqlConnector connection = new sqlConnector();
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			String querrySQL = "SELECT * FROM event";
			ResultSet rsCount = (ResultSet) statement.executeQuery(querrySQL);
			int countRow = 0;
			while(rsCount.next()) {
				countRow = rsCount.getInt(2);
			}
			connection.closeConnection();
			return countRow;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		
		
		return null;
		
	}
	
//	public String[][] getTableData() {
//		sqlConnector connection = new sqlConnector();
//		try {
//			connection.openConnection();
//			java.sql.Statement statement = connection.con.createStatement();
//			String querrySQL = "SELECT * FROM event";
//			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
//			int countRow = getRow();
//			int countColumn = rs.getMetaData().getColumnCount();
//			String[][] data = new String[countRow][countColumn];
//			int index = 0;
//			
//			while(rs.next()) {
//				for(int j = 1; j <= countColumn; j++) {
//					String typeData = rs.getMetaData().getColumnTypeName(j);
//					if(typeData.equals("INT")) {
//						data[index][j-1] = String.valueOf(rs.getInt(j));
//					} else if(typeData.equals("VARCHAR")) {
//						data[index][j-1] = rs.getString(j);
//					}
//				}
//				index++;
//			}
//			connection.closeConnection();
//			return data;
//		}catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
//		}
//		return null;
//	}
	
	public DefaultTableModel showTableData(JTable table) {
		sqlConnector connection = new sqlConnector();
		DefaultTableModel model;
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			String querrySQL = "SELECT * FROM event";
			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			model = (DefaultTableModel) table.getModel();
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			
			for(int i=0 ;i<cols;i++) {
				colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String[] row = new String[cols];
				while(rs.next()) {
					for(int j = 1; j <= cols; j++) {
						String typeData = rs.getMetaData().getColumnTypeName(j);
						if(typeData.equals("INT")) {
							row[j-1] = String.valueOf(rs.getInt(j));
						} else if(typeData.equals("VARCHAR")) {
							row[j-1] = rs.getString(j);
						}
					}
					model.addRow(row);
				}
			}
			statement.close();
			connection.closeConnection();
			return model;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
//	public void showTableData2(JTable table, DefaultTableModel model, String Harga) {
//		sqlConnector connection = new sqlConnector();
//		model.getDataVector().removeAllElements();
//		model.fireTableDataChanged();
//		try {
//			connection.openConnection();
//			java.sql.Statement statement = connection.con.createStatement();
//			String querrySQL = "SELECT * FROM event WHERE fee LIKE '%"+Harga+"%'";
//			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
//			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
//			model = (DefaultTableModel) table.getModel();
//			int cols = rsmd.getColumnCount();
//			String[] colName = new String[cols];
//			
//			for(int i=0 ;i<cols;i++) {
//				colName[i] = rsmd.getColumnName(i+1);
//				model.setColumnIdentifiers(colName);
//				String[] row = new String[cols];
//				while(rs.next()) {
//					for(int j = 1; j <= cols; j++) {
//						String typeData = rs.getMetaData().getColumnTypeName(j);
//						if(typeData.equals("INT")) {
//							row[j-1] = String.valueOf(rs.getInt(j));
//						} else if(typeData.equals("VARCHAR")) {
//							row[j-1] = rs.getString(j);
//						}
//					}
//					model.addRow(row);
//				}
//			}
//			statement.close();
//			connection.closeConnection();
////			return data;
//		}catch (Exception e) {
//			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
//		}
////		return null;
//	}
	
	public DefaultTableModel showTableData3(JTable table, DefaultTableModel model, String Harga, String Category) {
		sqlConnector connection = new sqlConnector();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		String querrySQL = "";
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			if(Category == Harga) {
				querrySQL = "SELECT * FROM event";
			}
			else if(Category == null && Harga !=null) {
				querrySQL = "SELECT * FROM event WHERE fee LIKE '%"+Harga+"%'";
			}
			else if(Harga == null && Category != null) {
				querrySQL = "SELECT * FROM event WHERE eventCategory LIKE '%"+Category+"%'";
			}
			else if(Harga != null && Category != null) {
				querrySQL = "SELECT * FROM event WHERE fee LIKE '%"+Harga+"%' AND eventCategory LIKE '%"+Category+"'";
			}
			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			model = (DefaultTableModel) table.getModel();
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			
			for(int i=0 ;i<cols;i++) {
				colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String[] row = new String[cols];
				while(rs.next()) {
					for(int j = 1; j <= cols; j++) {
						String typeData = rs.getMetaData().getColumnTypeName(j);
						if(typeData.equals("INT")) {
							row[j-1] = String.valueOf(rs.getInt(j));
						} else if(typeData.equals("VARCHAR")) {
							row[j-1] = rs.getString(j);
						}
					}
					model.addRow(row);
				}
			}
			statement.close();
			connection.closeConnection();
			return model;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public DefaultTableModel showTableReset(JTable table, DefaultTableModel model) {
		sqlConnector connection = new sqlConnector();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			String querrySQL = "SELECT * FROM event";
			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			model = (DefaultTableModel) table.getModel();
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			
			for(int i=0 ;i<cols;i++) {
				colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String[] row = new String[cols];
				while(rs.next()) {
					for(int j = 1; j <= cols; j++) {
						row[j-1] = null;
					}
					model.addRow(row);
				}
			}
			statement.close();
			connection.closeConnection();
			return model;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public DefaultTableModel showEventEnrolled(JTable table, User user) {
		sqlConnector connection = new sqlConnector();
		DefaultTableModel model;
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			System.out.println("coba");
			String querrySQL = 
					"SELECT organizerName, "
					+ "eventCategory, "
					+ "quota, "
					+ "Capacity, "
					+ "fee, "
					+ "steps, "
					+ "eventTitle, "
					+ "eventDesc FROM event "
					+ "INNER JOIN enrolledevent ON enrolledevent.id_account = " + user.getID() + " WHERE event.id_event = enrolledevent.id_event";
			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
			System.out.println("aman");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			model = (DefaultTableModel) table.getModel();
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			
			
			for(int i=0 ;i<cols;i++) {
				colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String[] row = new String[cols];
				while(rs.next()) {
					for(int j = 1; j <= cols; j++) {
						String typeData = rs.getMetaData().getColumnTypeName(j);
						if(typeData.equals("INT")) {
							row[j-1] = String.valueOf(rs.getInt(j));
						} else if(typeData.equals("VARCHAR")) {
							row[j-1] = rs.getString(j);
						}
					}
					model.addRow(row);
				}
			}
			statement.close();
			connection.closeConnection();
			return model;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public DefaultTableModel showEventEnrolledOrganizer(JTable table, Organizer organizer) {
		sqlConnector connection = new sqlConnector();
		DefaultTableModel model;
		try {
			connection.openConnection();
			java.sql.Statement statement = connection.con.createStatement();
			System.out.println("coba");
			String querrySQL = "SELECT * FROM event WHERE id_account = " + organizer.getID();
			System.out.println(organizer.getID());
			ResultSet rs = (ResultSet) statement.executeQuery(querrySQL);
			System.out.println("aman");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			model = (DefaultTableModel) table.getModel();
			int cols = rsmd.getColumnCount();
			String[] colName = new String[cols];
			
			
			for(int i=0 ;i<cols;i++) {
				colName[i] = rsmd.getColumnName(i+1);
				model.setColumnIdentifiers(colName);
				String[] row = new String[cols];
				while(rs.next()) {
					for(int j = 1; j <= cols; j++) {
						String typeData = rs.getMetaData().getColumnTypeName(j);
						if(typeData.equals("INT")) {
							row[j-1] = String.valueOf(rs.getInt(j));
						} else if(typeData.equals("VARCHAR")) {
							row[j-1] = rs.getString(j);
						}
					}
					model.addRow(row);
				}
			}
			statement.close();
			connection.closeConnection();
			return model;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to get User data!!", "Error!", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
}
