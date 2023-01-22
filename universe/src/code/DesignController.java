package code;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class DesignController {
	
	public void addPlaceHolderStyle(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.ITALIC);
		textField.setFont(new Font("Segoe UI", Font.ITALIC, 14));
		textField.setForeground(Color.gray);
	}
	
	public void removePlaceHolderStyle(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.PLAIN|Font.PLAIN);
		textField.setFont(font);
		textField.setForeground(Color.black);
	}
	
	public void setNoBorderField(JTextField JTextFieldName) {
		JTextFieldName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	}
	
	public void setNoBorderButton(JButton JButtonName) {
		Border emptyBorder = BorderFactory.createEmptyBorder();
		JButtonName.setBorder(emptyBorder);
	}
	
	public void setFrametoCenterOfScreen(JFrame JFrameName) {
		JFrameName.setLocationRelativeTo(null);
	}
	

}
