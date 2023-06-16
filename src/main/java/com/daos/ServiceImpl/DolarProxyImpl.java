package com.daos.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.daos.Response.CotizacionDolar;
import com.daos.Response.TipoCambioDolar;
import com.daos.Service.DolarProxy;

@Service
public class DolarProxyImpl implements DolarProxy {

	@Override
	public List<CotizacionDolar> getCotizaciones() {
		
		List<CotizacionDolar> lista=new ArrayList<CotizacionDolar>();
		
		ResponseEntity<TipoCambioDolar[]> resp= new RestTemplate().getForEntity("https://www.dolarsi.com/api/api.php?type=valoresprincipales", TipoCambioDolar[].class);
		for (TipoCambioDolar tipoCambio : resp.getBody()) {
			lista.add(tipoCambio.getCasa());
		}
		return lista;
	}
	

}
