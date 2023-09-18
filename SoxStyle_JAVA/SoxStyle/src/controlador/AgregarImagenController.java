package controlador;

import java.awt.event.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.Productos;
import sql.Consultas;
import vista.Administrador;
import vista.Agregar_imagen;
import vista.EditarProductos;

public class AgregarImagenController implements ActionListener, MouseListener {

    Agregar_imagen agi;
    Productos p = new Productos();
    Consultas consul = new Consultas();
    String FinFormato;
    Path Origen;
    Administrador a;

 // Constructor_para_inicializar_el_controlador_con_la_vista_y_los_datos_de_los_productos
 // En_esta_parte_se_decalrar_y_se_agrregan_los_escuchadores_a_los_botones, cuadros_de_texto,_labels_y_la_tabla
 // Todo_esto_para_pode_escuchar/detectar_lo_que_hace_cada_elemento_de_la_vista
    public AgregarImagenController(Agregar_imagen agi, Productos p, Administrador a) {
        this.a = a;
        this.p = p;
        this.agi = agi;
        this.agi.btn_Agregar.addActionListener(this);
        this.agi.table.addMouseListener(this);
        this.agi.btnCancelar.addActionListener(this);
        this.agi.btnEliminar.addActionListener(this);
        this.agi.btnVolver.addActionListener(this);
        CargarTablaImagenes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	//accion para volver a la vista de la edicion del producto
    	
    	if (e.getSource().equals(agi.btnVolver)) {
    		EditarProductos ed = new EditarProductos();
			new EdProductosController(ed, p, a);
			Ayudas.ActualizarPanel(ed, a.panelPrincipal);
			
		}
        // Acción_cuando se_presiona el botón_"Cancelar"
        if (e.getSource().equals(agi.btnCancelar)) {
            agi.btn_Agregar.setVisible(true);
            agi.btnCancelar.setVisible(false);
            agi.btnEliminar.setVisible(false);
        }

        // Acción_cuando se_presiona el_botón "Eliminar"
        if (e.getSource().equals(agi.btnEliminar)) {
            // Registrar_la_acción_en_la_base_de_datos
            consul.Monitorias(a.lbl_IdUser.getText(), "20", p.getImagen() + ",id_producto:" + p.getId());
            // Eliminar_la_imagen_del_producto
            consul.EliminarImagen(p);
            agi.btn_Agregar.setVisible(true);
            agi.btnCancelar.setVisible(false);
            agi.btnEliminar.setVisible(false);
            CargarTablaImagenes();
            JOptionPane.showMessageDialog(null, "IMAGEN ELIMINADA CON ÉXITO");
        }

     // Acción_cuando_se_presiona_el_botón_"Agregar"

        if (e.getSource().equals(agi.btn_Agregar)) {
            if (agi.lblContadorImagenes.getText().equals("10")) {
                JOptionPane.showMessageDialog(null, "LIMITE DE IMÁGENES ALCANZADO");
            } else {
                // Abrir_el_selector_de_archivos
                JFileChooser file = new JFileChooser();
                file.showOpenDialog(null);
                File archivo = file.getSelectedFile();
                if (archivo != null) {
                    // Obtener_el_formato_del_archivo
                    int formato = archivo.getName().length() - 4;
                    FinFormato = archivo.getName().toString().substring(formato);
                    if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg") && !FinFormato.equals("jpeg")) {
                        JOptionPane.showMessageDialog(null, "FORMATO NO VÁLIDO \n EL FORMATO DEBE SER png, jpeg o jpg");
                    } else {
                        if (FinFormato.equals("jpeg")) {
                            FinFormato = "." + FinFormato;
                        }
                        String Orig = archivo.getPath();
                        Origen = Paths.get(Orig);
                        String fechayhora = Ayudas.obtenerFechaYHoraActual();
                        // Subir_el_archivo_al_servidor_FTP
                        Ayudas.uploadFileToFTP(fechayhora + FinFormato, new File(String.valueOf(Origen)));
                        p.setImagen(fechayhora + FinFormato);
                        p.setId_Producto(p.getId());
                        // Insertar_la_imagen_en_la_base_de_datos
                        consul.insertarImagen(p);
                        // Registrar_la_acción_en_la_base_de_datos
                        consul.Monitorias(a.lbl_IdUser.getText(), "19", p.getImagen() + ",id_producto:" + p.getId_Producto());
                        JOptionPane.showMessageDialog(null, "IMAGEN AGREGADA");
                        CargarTablaImagenes();
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Método_no_utilizado_en_este_controlador
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Cuando_se_hace_clic_en_una_fila_de_la_tabla,_se_selecciona_una_imagen_para_editar_o_eliminar
        if (e.getSource().equals(agi.table)) {
            int row = agi.table.getSelectedRow();
            p.setId_imagen((String) agi.table.getValueAt(row, 0).toString());
            p.setImagen((String) agi.table.getValueAt(row, 1).toString());
            agi.btn_Agregar.setVisible(false);
            agi.btnCancelar.setVisible(true);
            agi.btnEliminar.setVisible(true);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Método_no_utilizado_en_este_controlador
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Método_no_utilizado_en_este_controlador
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Método_no_utilizado_en_este_controlador
    }

    // Método_para_cargar_la_tabla_de_imágenes_con_los_productos_disponibles
    public void CargarTablaImagenes() {
        consul.CargarTablaImagenes(agi.table, p);
        agi.lblContadorImagenes.setText(String.valueOf(p.getCantidad()));
    }
}
