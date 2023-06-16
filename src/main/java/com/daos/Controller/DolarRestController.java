package com.daos.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daos.Response.CotizacionDolar;
import com.daos.Exception.Excepcion;
import com.daos.Service.DolarProxy;

@RestController
@RequestMapping("/dolar")
public class DolarRestController {
	
	@Autowired
	private DolarProxy service; 	
	
	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<CotizacionDolar>> getCotizacionActual() throws Excepcion
	{
		List<CotizacionDolar> rta = service.getCotizaciones();
		if(rta.size()>0)
		{
			return new ResponseEntity<List<CotizacionDolar>>(rta, HttpStatus.OK);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	
	
	
	
	
	

}
