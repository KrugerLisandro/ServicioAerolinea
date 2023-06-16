package com.daos.Service;

import java.util.List;

import com.daos.Response.CotizacionDolar;


public interface DolarProxy {
	
	/**
	 * Devuelve la lista de cotizaciones del día
	 * @return Lista de cotizaciones
	 */
	public List<CotizacionDolar> getCotizaciones();

	

}
