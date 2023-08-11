package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo.Compras;
import modelo.Factura;
import sql.Consultas;
import vista.*;

public class PedidosDetalles_Controller implements ActionListener, MouseListener{
	
	
	VpedidosDetalles vpdDetalles;
	Factura f = new Factura();
	Compras c = new Compras();
	boolean compra = true; 
	Consultas consulta = new Consultas();
	public PedidosDetalles_Controller(VpedidosDetalles vpdDetalles, Factura f) {
		this.vpdDetalles = vpdDetalles;
		this.vpdDetalles.tblProductosPedidos.addMouseListener(this);
		this.vpdDetalles.btnAccion.addActionListener(this);
		this.f = f;
		cargar_detalles_factura();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(vpdDetalles.tblProductosPedidos)) {
			int row = vpdDetalles.tblProductosPedidos.getSelectedRow();
			c.setId((String) vpdDetalles.tblProductosPedidos.getValueAt(row, 0).toString());
			vpdDetalles.btnAccion.setVisible(true);
			String estados_id = (String) vpdDetalles.tblProductosPedidos.getValueAt(row, 7).toString();
			if (estados_id.equals("4")) {
				compra = true;
				vpdDetalles.btnAccion.setText("DESPACHAR");
			}else {
				compra = false;
				vpdDetalles.btnAccion.setText("DEVOLVER");
			}
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vpdDetalles.btnAccion)) {
			consulta.AccionCDProducto(c, compra);
			vpdDetalles.btnAccion.setVisible(false);
			cargar_detalles_factura();
		}
		
	}
	
	public void cargar_detalles_factura() {
		consulta.CargarDetallesFacturas(vpdDetalles.tblProductosPedidos, f);
		
	}

}
