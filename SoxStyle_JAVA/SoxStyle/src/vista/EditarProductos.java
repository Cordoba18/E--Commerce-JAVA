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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class EditarProductos extends JPanel {
	public JTextField txtNombre;
	public JTextField txtPrecio;
	public JTextField txtDescuento;
	public JButton btnActualizar;
	public JButton btnEdColorTalla;
	public JButton btnAgregarImagen;
	public JComboBox cbxCategoria;
	public JTextArea textAreaDescripcion;
	public JLabel lblErrorNombrePro;
	public JLabel lblErrorPrecio;
	public JLabel lblErrorDescuento;
	public JLabel lblErrorDescripcion;
	private JLabel lblNomProducto;
	private JButton btnEditarImagenes;
	private JLabel lbl_Imagen;
	/**
	 * Create the panel.
	 */
	public EditarProductos() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setBackground(SystemColor.control);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Producto");
		lblNewLabel.setBounds(49, 25, 257, 62);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(335, 84, 462, 614);
		add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setText("NombreProducto");
		txtNombre.setBounds(228, 44, 204, 27);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setText("$00000");
		txtPrecio.setBounds(137, 118, 146, 21);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 300, 98, 21);
		panel.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setBounds(137, 303, 145, 21);
		panel.add(cbxCategoria);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPrecio.setBounds(42, 118, 85, 21);
		panel.add(lblPrecio);
		
		JLabel lblDescuento = new JLabel("Descuento\r\n:");
		lblDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescuento.setBounds(42, 237, 98, 21);
		panel.add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDescuento.setText("10%");
		txtDescuento.setBounds(137, 238, 96, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		btnAgregarImagen = new JButton("Editar Imagen Principal");
		btnAgregarImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregarImagen.setBounds(220, 534, 204, 27);
		panel.add(btnAgregarImagen);
		
		btnEdColorTalla = new JButton("Editar Color/Talla");
		btnEdColorTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEdColorTalla.setBounds(65, 571, 168, 27);
		panel.add(btnEdColorTalla);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescripcion.setBounds(42, 361, 98, 21);
		panel.add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 405, 280, 99);
		panel.add(scrollPane);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
		scrollPane.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		lblErrorNombrePro = new JLabel("ERROR");
		lblErrorNombrePro.setVisible(false);
		lblErrorNombrePro.setForeground(Color.RED);
		lblErrorNombrePro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorNombrePro.setBounds(137, 82, 198, 21);
		panel.add(lblErrorNombrePro);
		
		lblErrorPrecio = new JLabel("ERROR");
		lblErrorPrecio.setVisible(false);
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorPrecio.setBounds(137, 146, 198, 21);
		panel.add(lblErrorPrecio);
		
		lblErrorDescuento = new JLabel("ERROR");
		lblErrorDescuento.setVisible(false);
		lblErrorDescuento.setForeground(Color.RED);
		lblErrorDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescuento.setBounds(137, 268, 198, 21);
		panel.add(lblErrorDescuento);
		
		lblErrorDescripcion = new JLabel("ERROR");
		lblErrorDescripcion.setVisible(false);
		lblErrorDescripcion.setForeground(Color.RED);
		lblErrorDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescripcion.setBounds(89, 503, 198, 21);
		panel.add(lblErrorDescripcion);
		
		lblNomProducto = new JLabel("Nombre Producto:");
		lblNomProducto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNomProducto.setBounds(42, 47, 153, 21);
		panel.add(lblNomProducto);
		
		btnEditarImagenes = new JButton("Editar Imagenes");
		btnEditarImagenes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEditarImagenes.setBounds(243, 571, 168, 27);
		panel.add(btnEditarImagenes);
		
		lbl_Imagen = new JLabel("Imagen:");
		lbl_Imagen.setFont(new Font("Segoe UI", Font.BOLD, 8));
		lbl_Imagen.setBounds(45, 534, 165, 21);
		panel.add(lbl_Imagen);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(515, 718, 124, 29);
		btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnActualizar.setBackground(new Color(0, 150, 255));
		add(btnActualizar);

	}
}

