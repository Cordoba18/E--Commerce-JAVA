package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import herramientas.Ayudas;
import vista.*;

public class PedidosCyD_Controller implements ActionListener {
	
	Vpedidos vpedi;
	Administrador a;
	
	public PedidosCyD_Controller(Vpedidos vpedi, Administrador a) {
		this.vpedi = vpedi;
		this.a = a;
		vpedi.btnVerDetalles.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vpedi.btnVerDetalles)) {
			VpedidosDetalles vpedidosDetalles = new VpedidosDetalles();
			new PedidosDetalles_Controller(vpedidosDetalles);
			Ayudas.ActualizarPanel(vpedidosDetalles, a.panelPrincipal);
		}
		
	}
	
}
