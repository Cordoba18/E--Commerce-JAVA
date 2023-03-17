package vista;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Slider extends JPanel {
	private JTable JtableSlider;
	private JTextField textField;
	public JLabel lblSlider;
	public JLabel lblNombre;
	public JLabel lblDescripcion;
	public JButton btnActivar;
	public JButton btnC_imagen;
	public JTextArea textArea;
	/**
	 * Create the panel.
	 */
	public Slider() {
		setMaximumSize(new Dimension(1318, 757));
		setLayout(null);
		
		JScrollPane SpSlider = new JScrollPane();
		SpSlider.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		SpSlider.setBounds(20, 62, 487, 270);
		add(SpSlider);
		
		JtableSlider = new JTable();
		JtableSlider.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Infromacion", "Imagen", "Estado"
			}
		));
		SpSlider.setViewportView(JtableSlider);
		
		lblSlider = new JLabel("Editar slider");
		lblSlider.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblSlider.setBounds(10, 8, 167, 43);
		add(lblSlider);
		
		lblNombre = new JLabel("Nombre del slider");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		lblNombre.setBounds(593, 69, 167, 43);
		add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(563, 109, 231, 31);
		add(textField);
		textField.setColumns(10);
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		lblDescripcion.setBounds(593, 196, 167, 43);
		add(lblDescripcion);
		
		btnActivar = new JButton("Activar");
		btnActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActivar.setBounds(493, 358, 89, 23);
		add(btnActivar);
		
		btnC_imagen = new JButton("Cambiar imagen");
		btnC_imagen.setBounds(593, 358, 115, 23);
		add(btnC_imagen);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(718, 358, 89, 23);
		add(btnModificar);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBounds(563, 237, 231, 97);
		add(textArea);

	}
}
