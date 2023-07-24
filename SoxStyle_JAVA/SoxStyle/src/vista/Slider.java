package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Slider extends JPanel {
	
	public JTable TablaSlider;
	public JScrollPane scrollSlider;
	public JLabel lblModificar;
	public JLabel lblNombre;
	public JLabel lblDescripcion;
	public JLabel lblerrorN;
	public JLabel lblerrorD;
	public JTextField txtNombre;
	public JTextArea txtArea;
	public JButton btnActivar;
	public JButton btnAgregarImagen;
	public JButton btnGuardar;
	public JButton btnCancelar;
	public JLabel lblImagen;
	public JLabel lblTitulo;

	/**
	 * Create the panel.
	 */
	public Slider() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		lblModificar = new JLabel("Modificar Slider");
		lblModificar.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificar.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblModificar.setBounds(33, 29, 524, 83);
		add(lblModificar);
		
		scrollSlider = new JScrollPane();
		scrollSlider.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		scrollSlider.setBounds(33, 123, 876, 501);
		add(scrollSlider);
		
		TablaSlider = new JTable();
		TablaSlider.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Informacion", "Imagen", "Estados"
			}
		));
		scrollSlider.setViewportView(TablaSlider);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(1029, 125, 134, 50);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		txtNombre.setBounds(964, 186, 271, 34);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		lblDescripcion = new JLabel("INFORMACION");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblDescripcion.setBounds(1015, 284, 206, 50);
		add(lblDescripcion);
		
		txtArea = new JTextArea();
		txtArea.setBackground(new Color(192, 192, 192));
		txtArea.setLineWrap(true);
		txtArea.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		txtArea.setBounds(964, 345, 271, 91);
		add(txtArea);
		
		btnActivar = new JButton("ELIMINAR");
		btnActivar.setBackground(new Color(255, 255, 255));
		btnActivar.setIcon(new ImageIcon("icons\\Lg-eliminar.png"));
		btnActivar.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnActivar.setBounds(964, 603, 271, 68);
		add(btnActivar);
		
		btnAgregarImagen = new JButton("AGREGAR IMAGEN");
		btnAgregarImagen.setIcon(new ImageIcon("icons\\Lg-editar.png"));
		btnAgregarImagen.setBackground(new Color(255, 255, 255));
		btnAgregarImagen.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnAgregarImagen.setBounds(964, 472, 271, 68);
		add(btnAgregarImagen);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnGuardar.setBounds(964, 538, 271, 68);
		add(btnGuardar);
		
		lblerrorN = new JLabel("Error");
		lblerrorN.setForeground(Color.RED);
		lblerrorN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblerrorN.setVisible(false);
		lblerrorN.setBounds(964, 220, 271, 14);
		add(lblerrorN);
		
		lblerrorD = new JLabel("Error");
		lblerrorD.setVisible(false);
		lblerrorD.setForeground(Color.RED);
		lblerrorD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblerrorD.setBounds(964, 447, 271, 14);
		add(lblerrorD);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCancelar.setVisible(false);
		btnCancelar.setBounds(964, 682, 271, 34);
		add(btnCancelar);
		
		lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(964, 500, 271, 14);
		add(lblImagen);
		
		lblTitulo = new JLabel("CREAR SLIDER");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblTitulo.setBounds(964, 58, 271, 50);
		add(lblTitulo);
		
		btnCancelar.setVisible(false);
		btnActivar.setVisible(false);
		lblerrorN.setVisible(false);
		lblerrorD.setVisible(false);
	}
}
