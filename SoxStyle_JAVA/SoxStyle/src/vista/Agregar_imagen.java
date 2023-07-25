package vista;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Agregar_imagen extends JPanel {
	public JScrollPane tbl_Agregar = new JScrollPane();
	public JButton btn_Agregar,btnCancelar,btnEliminar;
	public JTable table;
	public JLabel lblContadorImagenes;
	

	/**
	 * Create the panel.
	 */
	public Agregar_imagen() {
		setBackground(new Color(255, 255, 255));
		setBounds(new Rectangle(0, 0, 1318, 757));
		setLayout(null);
		
		btn_Agregar = new JButton("Agregar");
		btn_Agregar.setBackground(new Color(255, 255, 255));
		btn_Agregar.setIcon(new ImageIcon("icons\\Lg-boton-agregar.png"));
		btn_Agregar.setBounds(1066, 184, 161, 47);
		btn_Agregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		add(btn_Agregar);
		
		JLabel lblNewLabel = new JLabel("Agregar más imágenes al producto");
		lblNewLabel.setBounds(37, 20, 504, 47);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(118, 184, 916, 351);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"ID", "Imagen", "Estado"
			}
		));
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setVisible(false);
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(1064, 312, 163, 59);
		add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("icons\\Lg-eliminar.png"));
		btnEliminar.setVisible(false);
		btnEliminar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(1066, 242, 163, 59);
		add(btnEliminar);
		
		JLabel lblTituloLimite = new JLabel("LIMITE DE IMAGENES:   ");
		lblTituloLimite.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblTituloLimite.setBounds(118, 549, 378, 47);
		add(lblTituloLimite);
		
		JLabel libLimiteComplemento = new JLabel("10/");
		libLimiteComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		libLimiteComplemento.setFont(new Font("Segoe UI", Font.BOLD, 28));
		libLimiteComplemento.setBounds(506, 549, 46, 47);
		add(libLimiteComplemento);
		
		lblContadorImagenes = new JLabel("0");
		lblContadorImagenes.setForeground(new Color(255, 0, 0));
		lblContadorImagenes.setHorizontalAlignment(SwingConstants.CENTER);
		lblContadorImagenes.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblContadorImagenes.setBounds(547, 549, 46, 47);
		add(lblContadorImagenes);
	}
}
