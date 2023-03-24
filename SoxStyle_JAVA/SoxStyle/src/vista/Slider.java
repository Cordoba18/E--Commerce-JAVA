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

public class Slider extends JPanel {
	
	private JTable TablaSlider;
	public JScrollPane scrollSlider;
	public JLabel lblModificar;
	public JLabel lblNombre;
	public JLabel lblDescripcion;
	public JLabel lblerrorN;
	public JLabel lblerrorD;
	public JTextField txtNombre;
	public JTextArea txtArea;
	public JButton btnActivar;
	public JButton btnCambiar;
	public JButton btnActualizar;
	public JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public Slider() {
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		lblModificar = new JLabel("Modificar Slider");
		lblModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificar.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		lblModificar.setBounds(33, 29, 207, 58);
		add(lblModificar);
		
		scrollSlider = new JScrollPane();
		scrollSlider.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		scrollSlider.setBounds(33, 123, 876, 450);
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
		
		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		lblDescripcion.setBounds(1029, 285, 134, 50);
		add(lblDescripcion);
		
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setFont(new Font("Segoe UI Light", Font.BOLD, 13));
		txtArea.setBounds(964, 345, 271, 166);
		add(txtArea);
		
		btnActivar = new JButton("Activar");
		btnActivar.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnActivar.setBounds(936, 595, 99, 34);
		add(btnActivar);
		
		btnCambiar = new JButton("Cambiar imagen");
		btnCambiar.setVisible(false);
		btnCambiar.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnCambiar.setBounds(1045, 595, 129, 34);
		add(btnCambiar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setVisible(false);
		btnActualizar.setFont(new Font("Segoe UI Light", Font.BOLD, 12));
		btnActualizar.setBounds(1184, 595, 89, 34);
		add(btnActualizar);
		
		lblerrorN = new JLabel("Error");
		lblerrorN.setForeground(Color.RED);
		lblerrorN.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblerrorN.setVisible(false);
		lblerrorN.setBounds(1117, 231, 175, 14);
		add(lblerrorN);
		
		lblerrorD = new JLabel("Error");
		lblerrorD.setVisible(false);
		lblerrorD.setForeground(Color.RED);
		lblerrorD.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblerrorD.setBounds(1117, 523, 175, 14);
		add(lblerrorD);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnCancelar.setVisible(false);
		btnCancelar.setBounds(1045, 661, 129, 23);
		add(btnCancelar);
	}
}
