package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Agregar_imagen extends JPanel {

	/**
	 * Create the panel.
	 */
	public Agregar_imagen() {
		setBounds(new Rectangle(0, 0, 1000, 500));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(87, 99, 1066, 553);
		add(panel);
		panel.setLayout(null);
		
		JLabel imagen1 = new JLabel("IMAGEN");
		imagen1.setHorizontalAlignment(SwingConstants.CENTER);
		imagen1.setFont(new Font("Segoe UI", Font.BOLD, 25));
		imagen1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		imagen1.setBounds(33, 67, 239, 177);
		panel.add(imagen1);
		
		JLabel imagen2 = new JLabel("IMAGEN");
		imagen2.setHorizontalAlignment(SwingConstants.CENTER);
		imagen2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		imagen2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		imagen2.setBounds(382, 67, 239, 177);
		panel.add(imagen2);
		
		JButton btn_editar = new JButton("Editar");
		btn_editar.setBounds(282, 67, 85, 21);
		panel.add(btn_editar);
		
		JButton btn_eliminar = new JButton("Eliminar");
		btn_eliminar.setBounds(282, 102, 85, 21);
		panel.add(btn_eliminar);
		
		JButton btn_editar2 = new JButton("Editar");
		btn_editar2.setBounds(631, 67, 85, 21);
		panel.add(btn_editar2);
		
		JButton btn_eliminar2 = new JButton("Eliminar");
		btn_eliminar2.setBounds(631, 102, 85, 21);
		panel.add(btn_eliminar2);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 44));
		btnNewButton.setBounds(819, 138, 85, 45);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 44));
		btnNewButton_1.setBounds(100, 373, 85, 45);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("+");
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 44));
		btnNewButton_1_1.setBounds(459, 373, 85, 45);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("+");
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 44));
		btnNewButton_1_1_1.setBounds(819, 373, 85, 45);
		panel.add(btnNewButton_1_1_1);
		
		JLabel imagen4 = new JLabel("");
		imagen4.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		imagen4.setBounds(33, 308, 239, 177);
		panel.add(imagen4);
		
		JLabel imagen5 = new JLabel("");
		imagen5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		imagen5.setBounds(382, 308, 239, 177);
		panel.add(imagen5);
		
		JLabel imagen6 = new JLabel("");
		imagen6.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		imagen6.setBounds(735, 308, 239, 177);
		panel.add(imagen6);
		
		JLabel imagen3 = new JLabel("");
		imagen3.setFont(new Font("Segoe UI", Font.BOLD, 25));
		imagen3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		imagen3.setBounds(735, 67, 239, 177);
		panel.add(imagen3);
		
		JButton btnNewButton_2 = new JButton("Agregar");
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 25));
		btnNewButton_2.setBounds(554, 683, 151, 47);
		add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Agregar más imágenes al producto");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblNewLabel.setBounds(115, 23, 504, 47);
		add(lblNewLabel);

	}

}
