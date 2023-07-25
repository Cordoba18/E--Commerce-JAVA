package controlador;

import sql.Consultas;
import vista.Estadisticas;

public class EstadisticasController {
Estadisticas e;
Consultas consulta = new Consultas();
public EstadisticasController(Estadisticas e) {
	this.e=e;
	CargarTablas();
}

public void CargarTablas() {
//	consulta.CargarEstadisticas(e.tblProductosMasVendidos, "6", "mas");
//	consulta.CargarEstadisticas(e.tblPruductosMenosVendidos, "6", "menos");
	consulta.CargarEstadisticas(e.tblUsuariosIngresadosDia, "15", "");
	consulta.CargarEstadisticas(e.tabla_monitorias, "", "");
}
}
