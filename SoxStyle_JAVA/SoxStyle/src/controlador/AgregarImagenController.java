package controlador;

import java.awt.event.*;

import java.io.File;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import herramientas.Validaciones;
import modelo.Productos;
//import sql.Conexion;
import sql.Consultas;
import vista.Agregar_imagen;


public class AgregarImagenController implements ActionListener{
	
	Agregar_imagen agi;
	Consultas consul = new Consultas();

	public AgregarImagenController(Agregar_imagen agi) {
		
		this.agi = agi;
		this.agi.btn_Agregar.addActionListener(this);
		eventos();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		   if (e.getSource().equals(agi.btn_Agregar)) {

		        JFileChooser fileChooser = new JFileChooser();
		        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "jpeg", "png");
		        fileChooser.setFileFilter(filter);

		        int result = fileChooser.showOpenDialog(this.agi);
		        if (result == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();
		            String fileName = selectedFile.getName(); // Obtener solo el nombre del archivo con la extensión

		            // Verificar la extensión del archivo
		            String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		            if (!extension.equals("jpg") && !extension.equals("jpeg") && !extension.equals("png")) {
		                JOptionPane.showMessageDialog(null, "Tipo de imagen no válido. Selecciona un archivo JPG, JPEG o PNG.", "Error", JOptionPane.ERROR_MESSAGE);
		                return; // Salir del método actionPerformed
		            }

		            if (consul.InsertarImagen(fileName)) {
		            	//consul.saveImageToServer(selectedFile);
		                JOptionPane.showMessageDialog(null, "INSERTADO");
		            }
		        }
		    }
	}

	
	public void eventos() {
		agi.setVisible(true);
        consul.mostrarImagen(agi.table);
        
		//-----------------------SELECCIONAR FILA Y APARECER BOTONES-----------------------------
        
        agi.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				
				if(e.getSource().equals(agi.table)) {

					int row = agi.table.getSelectedRow();
					
					agi.txtId.setText(agi.table.getValueAt(row, 0).toString());

					

					agi.btn_Editar.setVisible(true);
					agi.btn_Eliminar.setVisible(true);

				}
			}
		});
	}
}