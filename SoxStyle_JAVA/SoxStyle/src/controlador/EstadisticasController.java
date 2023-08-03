package controlador;

import modelo.Productos;
import sql.Consultas;
import vista.Estadisticas;

public class EstadisticasController {
Estadisticas e;
Consultas consulta = new Consultas();
Productos producto = new Productos();
public EstadisticasController(Estadisticas e) {
	this.e=e;
	CargarTablas();
}
public void CargarTablas() {
	consulta.CargarProductosVendidos(e.tblProductosMasVendidos,"mas");
	consulta.CargarProductosVendidos(e.tblPruductosMenosVendidos,"menos");
	consulta.CargarMonitorias(e.tblUsuariosIngresadosDia, "15");
	consulta.CargarMonitorias(e.tabla_monitorias, "");
	consulta.ContarUsuariosProductos(producto, "productos");
	e.lblTotalProductos.setText(String.valueOf(producto.getCantidad()));
	consulta.ContarUsuariosProductos(producto, "Users");
	e.lblTotalUsuarioRegistrados.setText(String.valueOf(producto.getCantidad()));
}
}
