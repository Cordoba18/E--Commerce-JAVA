package vista;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*; 

public class AgregarProductos extends JPanel {
	public JTextField txtNombre;
	public JTextField txtPrecio;
	public JTextField txtEstado;
	public JTextField txtTalla;
	public JTextField textColor;
	public JButton btnAgregar;
	public JComboBox cbxCategoria;
	public JLabel lblError;

	/**
	 * Create the panel.
	 */
	public AgregarProductos() {
		setBounds(new Rectangle(0, 0, 1318, 757));	
		setBounds(0, 0, 1318, 757);
		setLayout(null); 
		
		JLabel lblNewLabel = new JLabel("Agregar Producto");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		lblNewLabel.setBounds(49, 25, 257, 62);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(334, 84, 550, 565);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("IMAGEN");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblImagen.setBounds(42, 27, 360, 161);
		panel.add(lblImagen);
		
		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEstado.setBounds(42, 292, 85, 21);
		panel.add(lblEstado);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTalla.setBounds(42, 345, 85, 21);
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
		txtTalla.setBounds(137, 346, 96, 19);
		panel.add(txtTalla);
		txtTalla.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblColor.setBounds(42, 397, 85, 21);
		panel.add(lblColor);
		
		textColor = new JTextField();
		textColor.setBackground(new Color(255, 255, 0));
		textColor.setBounds(156, 400, 43, 21);
		panel.add(textColor);
		textColor.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 458, 98, 21);
		panel.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setBounds(137, 461, 145, 21);
		panel.add(cbxCategoria);
		
		lblError = new JLabel("ERROR");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblError.setBounds(42, 504, 98, 21);
		panel.add(lblError);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregar.setBounds(565, 666, 124, 29);
		btnAgregar.setBackground(new Color(0, 150, 255));
		add(btnAgregar);

	}
}

