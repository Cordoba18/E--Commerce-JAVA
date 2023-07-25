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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

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
	public JButton btnEditarImagenes, btnCancelar;
	public JLabel lbl_Imagen;
	private JLabel lblPrecio_1;
	private JLabel lblPrecio_2;
	private JScrollPane scrollPane;
	/**
	 * Create the panel.
	 */
	public EditarProductos() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Producto");
		lblNewLabel.setBounds(49, 25, 257, 62);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 29));
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(195, 79, 886, 525);
		add(panel);
		panel.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setBounds(492, 44, 358, 27);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtPrecio.setBounds(662, 118, 188, 21);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCategoria.setBounds(42, 237, 98, 21);
		panel.add(lblCategoria);
		
		cbxCategoria = new JComboBox();
		cbxCategoria.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		cbxCategoria.setBounds(511, 239, 339, 21);
		panel.add(cbxCategoria);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPrecio.setBounds(42, 118, 85, 21);
		panel.add(lblPrecio);
		
		JLabel lblDescuento = new JLabel("Descuento\r\n:");
		lblDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescuento.setBounds(42, 176, 98, 21);
		panel.add(lblDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setBackground(new Color(255, 255, 255));
		txtDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtDescuento.setBounds(709, 177, 96, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		btnAgregarImagen = new JButton("Editar Imagen Principal");
		btnAgregarImagen.setIcon(new ImageIcon("icons\\Lg-sliders.png"));
		btnAgregarImagen.setBackground(new Color(255, 255, 255));
		btnAgregarImagen.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnAgregarImagen.setBounds(511, 423, 339, 58);
		panel.add(btnAgregarImagen);
		
		btnEdColorTalla = new JButton("Editar Color/Talla");
		btnEdColorTalla.setBackground(new Color(255, 255, 255));
		btnEdColorTalla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEdColorTalla.setBounds(682, 487, 168, 27);
		panel.add(btnEdColorTalla);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblDescripcion.setBounds(42, 329, 98, 21);
		panel.add(lblDescripcion);
		
		lblErrorNombrePro = new JLabel("ERROR");
		lblErrorNombrePro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorNombrePro.setVisible(false);
		lblErrorNombrePro.setForeground(Color.RED);
		lblErrorNombrePro.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorNombrePro.setBounds(652, 82, 198, 21);
		panel.add(lblErrorNombrePro);
		
		lblErrorPrecio = new JLabel("ERROR");
		lblErrorPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorPrecio.setVisible(false);
		lblErrorPrecio.setForeground(Color.RED);
		lblErrorPrecio.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorPrecio.setBounds(652, 145, 198, 21);
		panel.add(lblErrorPrecio);
		
		lblErrorDescuento = new JLabel("ERROR");
		lblErrorDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDescuento.setVisible(false);
		lblErrorDescuento.setForeground(Color.RED);
		lblErrorDescuento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescuento.setBounds(652, 207, 198, 21);
		panel.add(lblErrorDescuento);
		
		lblErrorDescripcion = new JLabel("ERROR");
		lblErrorDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblErrorDescripcion.setVisible(false);
		lblErrorDescripcion.setForeground(Color.RED);
		lblErrorDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblErrorDescripcion.setBounds(652, 383, 198, 21);
		panel.add(lblErrorDescripcion);
		
		lblNomProducto = new JLabel("Nombre Producto:");
		lblNomProducto.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNomProducto.setBounds(42, 47, 153, 21);
		panel.add(lblNomProducto);
		
		lbl_Imagen = new JLabel("Imagen:");
		lbl_Imagen.setFont(new Font("Segoe UI", Font.BOLD, 8));
		lbl_Imagen.setBounds(685, 429, 165, 21);
		panel.add(lbl_Imagen);
		
		lblPrecio_1 = new JLabel("$");
		lblPrecio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPrecio_1.setBounds(617, 118, 41, 21);
		panel.add(lblPrecio_1);
		
		lblPrecio_2 = new JLabel("%");
		lblPrecio_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblPrecio_2.setBounds(809, 177, 41, 21);
		panel.add(lblPrecio_2);
		
		btnEditarImagenes = new JButton("Editar Imagenes");
		btnEditarImagenes.setBackground(new Color(255, 255, 255));
		btnEditarImagenes.setBounds(504, 487, 168, 27);
		panel.add(btnEditarImagenes);
		btnEditarImagenes.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(511, 283, 339, 97);
		panel.add(scrollPane);
		
		textAreaDescripcion = new JTextArea();
		scrollPane.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 15));
		textAreaDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(365, 439, 136, 27);
		panel.add(btnCancelar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setIcon(new ImageIcon("icons\\Lg-editar.png"));
		btnActualizar.setBounds(481, 615, 301, 56);
		btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnActualizar.setBackground(new Color(255, 255, 255));
		add(btnActualizar);
		btnCancelar.setVisible(false);
	}
}

