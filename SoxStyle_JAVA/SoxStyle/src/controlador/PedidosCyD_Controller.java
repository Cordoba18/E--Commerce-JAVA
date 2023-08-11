package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import herramientas.Ayudas;
import modelo.Factura;
import sql.Consultas;
import vista.*;

public class PedidosCyD_Controller implements ActionListener, MouseListener {
	
	Vpedidos vpedi;
	Administrador a;
	Consultas consulta = new Consultas();
	Factura f = new Factura();
	public PedidosCyD_Controller(Vpedidos vpedi, Administrador a) {
		this.vpedi = vpedi;
		this.a = a;
		vpedi.btnVerDetalles.addActionListener(this);
		vpedi.tblPedidosComprados.addMouseListener(this);
		vpedi.tblpedidosDespachados.addMouseListener(this);
		cargar_compradas();
		cargar_despachadas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vpedi.btnVerDetalles)) {
			VpedidosDetalles vpedidosDetalles = new VpedidosDetalles();
			new PedidosDetalles_Controller(vpedidosDetalles, f);
			Ayudas.ActualizarPanel(vpedidosDetalles, a.panelPrincipal);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (e.getSource().equals(vpedi.tblPedidosComprados)) {
			int row = vpedi.tblPedidosComprados.getSelectedRow();
			f.setId((String) vpedi.tblPedidosComprados.getValueAt(row, 0).toString());
			vpedi.btnVerDetalles.setVisible(true);
		}
		if (e.getSource().equals(vpedi.tblpedidosDespachados)) {
			int row = vpedi.tblpedidosDespachados.getSelectedRow();
			f.setId((String) vpedi.tblpedidosDespachados.getValueAt(row, 0).toString());
			vpedi.btnVerDetalles.setVisible(true);
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
	
	public void cargar_compradas() {
		consulta.CargarFacturas(vpedi.tblPedidosComprados, "4");
	}
	
	public void cargar_despachadas() {
		consulta.CargarFacturas(vpedi.tblpedidosDespachados, "5");
	}
}
