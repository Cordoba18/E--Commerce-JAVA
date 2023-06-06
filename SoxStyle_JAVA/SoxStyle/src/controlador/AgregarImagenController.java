package controlador;

import java.awt.event.*;
import java.io.File;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import herramientas.Validaciones;
import modelo.Productos;
//import sql.Conexion;
import sql.Consultas;
import vista.Agregar_imagen;

public class AgregarImagenController implements ActionListener{
	
	Agregar_imagen agi;
	

	public AgregarImagenController(Agregar_imagen agi) {

		this.agi = agi;
		this.agi.btn_Agregar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(agi.btn_Agregar)) {
			
			JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(this.agi);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String imagePath = selectedFile.getAbsolutePath();

                saveImagePathToDatabase(imagePath);
            }
		}		
	}	
	

    public void saveImagePathToDatabase(String imagePath) {
    	
        // CONEXION BASE DE DATOS ( ESTOY ENSAYANDO CON UNA BD PERSONAL )
        String url = "jdbc:mysql://localhost:3306/ensayo_java";
        String username = "root";
        String password = "";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO imagen (imagen) VALUES (?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, imagePath);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this.agi, "La imagen se ha guardado exitosamente en la base de datos.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this.agi, "Error al guardar la imagen en la base de datos: " + ex.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}