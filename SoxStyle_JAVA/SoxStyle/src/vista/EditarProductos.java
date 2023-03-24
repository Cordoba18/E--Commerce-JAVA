package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class EditarProductos extends JPanel {
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtEstado;
	private JTextField txtTalla;
	private JTextField textField;
	private JTextField txtDescuento;

	/**
	 * Create the panel.
	 */
	public EditarProductos() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setBackground(SystemColor.control);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Producto");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel.setBounds(49, 25, 257, 62);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(335, 84, 534, 605);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("IMAGEN");
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblImagen.setBounds(42, 27, 360, 161);
		panel.add(lblImagen);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEstado.setBounds(42, 292, 85, 21);
		panel.add(lblEstado);
		
		JLabel lblEstadoProducto = new JLabel("Estado\r\n:");
		lblEstadoProducto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEstadoProducto.setBounds(42, 372, 98, 21);
		panel.add(lblEstadoProducto);
		
		JComboBox comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(137, 375, 145, 21);
		panel.add(comboBoxEstado);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTalla.setBounds(42, 418, 85, 21);
		panel.add(lblTalla);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setText("NombreProducto");
		txtNombre.setBounds(84, 198, 204, 27);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setText("$00000");
		txtPrecio.setBounds(137, 246, 146, 21);
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
		txtTalla.setBounds(137, 419, 96, 19);
		panel.add(txtTalla);
		txtTalla.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblColor.setBounds(42, 465, 85, 21);
		panel.add(lblColor);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 0));
		textField.setBounds(164, 468, 43, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 512, 98, 21);
		panel.add(lblCategoria);
		
		JComboBox comboBoxEstado_1 = new JComboBox();
		comboBoxEstado_1.setBounds(137, 512, 145, 21);
		panel.add(comboBoxEstado_1);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPrecio.setBounds(42, 246, 85, 21);
		panel.add(lblPrecio);
		
		JLabel lblDescuento = new JLabel("Descuento\r\n:");
		lblDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescuento.setBounds(42, 333, 98, 21);
		panel.add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDescuento.setText("10%");
		txtDescuento.setBounds(137, 337, 96, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		JButton btnAgregar = new JButton("Actualizar");
		btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregar.setBounds(554, 699, 124, 29);
		btnAgregar.setBackground(new Color(0, 150, 255));
		add(btnAgregar);

	}
}

