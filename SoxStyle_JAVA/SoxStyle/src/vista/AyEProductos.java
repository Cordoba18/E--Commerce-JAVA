package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class AyEProductos extends JPanel {
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtEstado;
	private JTextField txtTalla;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AyEProductos() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Producto");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel.setBounds(49, 25, 257, 62);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(335, 84, 550, 565);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("IMAGEN");
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblImagen.setBounds(42, 27, 360, 161);
		panel.add(lblImagen);
		
		JButton btnEditarImagen = new JButton("Editar");
		btnEditarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarImagen.setBounds(428, 47, 85, 21);
		btnEditarImagen.setBackground(new Color(0, 150, 255));
		panel.add(btnEditarImagen);
		
		JButton btnAgregarImagen = new JButton("+");
		btnAgregarImagen.setBounds(428, 100, 85, 21);
		btnAgregarImagen.setBackground(new Color(0, 150, 255));
		panel.add(btnAgregarImagen);
		
		JButton btnEditarNombre = new JButton("Editar");
		btnEditarNombre.setBounds(337, 204, 65, 21);
		btnEditarNombre.setBackground(new Color(0, 150, 255));
		panel.add(btnEditarNombre);
		
		JButton btnEditarPrecio = new JButton("Editar");
		btnEditarPrecio.setBounds(337, 247, 65, 21);
		btnEditarPrecio.setBackground(new Color(0, 150, 255));
		panel.add(btnEditarPrecio);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEstado.setBounds(42, 292, 85, 21);
		panel.add(lblEstado);
		
		JButton btnEditarEstado = new JButton("Editar");
		btnEditarEstado.setBounds(337, 295, 65, 21);
		btnEditarEstado.setBackground(new Color(0, 150, 255));
		panel.add(btnEditarEstado);
		
		JLabel lblEstadoProducto = new JLabel("Estado\r\n:");
		lblEstadoProducto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEstadoProducto.setBounds(42, 336, 98, 21);
		panel.add(lblEstadoProducto);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(137, 339, 145, 21);
		panel.add(comboBoxEstado);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTalla.setBounds(42, 385, 85, 21);
		panel.add(lblTalla);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setText("NombreProducto");
		txtNombre.setBounds(84, 198, 204, 27);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setText("$XXXXXXXX");
		txtPrecio.setBounds(42, 244, 146, 21);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtEstado.setText("Nuevo");
		txtEstado.setBounds(137, 293, 96, 19);
		panel.add(txtEstado);
		txtEstado.setColumns(10);
		
		txtTalla = new JTextField();
		txtTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtTalla.setText("XL");
		txtTalla.setBounds(137, 386, 96, 19);
		panel.add(txtTalla);
		txtTalla.setColumns(10);
		
		JButton btnEditarTalla = new JButton("Editar");
		btnEditarTalla.setBounds(337, 385, 65, 21);
		btnEditarTalla.setBackground(new Color(0, 150, 255));
		panel.add(btnEditarTalla);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblColor.setBounds(42, 436, 85, 21);
		panel.add(lblColor);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 0));
		textField.setBounds(160, 439, 43, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnEditarColor = new JButton("Editar");
		btnEditarColor.setBounds(337, 439, 65, 21);
		btnEditarColor.setBackground(new Color(0, 150, 255));
		panel.add(btnEditarColor);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 483, 98, 21);
		panel.add(lblCategoria);
		
		JComboBox comboBoxEstado_1 = new JComboBox();
		comboBoxEstado_1.setBounds(137, 486, 145, 21);
		panel.add(comboBoxEstado_1);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregar.setBounds(566, 684, 124, 29);
		btnAgregar.setBackground(new Color(0, 150, 255));
		add(btnAgregar);

	}
}

