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
	consulta.CargarEstadisticas(e.tblProductosMasVendidos, "6", "mas");
	consulta.CargarEstadisticas(e.tblPruductosMenosVendidos, "6", "menos");
	consulta.CargarEstadisticas(e.tblUsuariosIngresadosDia, "15", "");
	consulta.CargarEstadisticas(e.tabla_monitorias, "", "");
	consulta.ContarUsuariosProductos(producto, "productos");
	e.lblTotalProductos.setText(String.valueOf(producto.getCantidad()));
	consulta.ContarUsuariosProductos(producto, "Users");
	e.lblTotalUsuarioRegistrados.setText(String.valueOf(producto.getCantidad()));
}
}
