package com.daos.Response;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import com.daos.Entity.Vuelo;
import com.fasterxml.jackson.annotation.JsonFormat;

// OBJETO UTILIZADO PARA CONSTRUIR LA RESPUESTA DE LOS SERVICIOS
public class VueloDTO extends RepresentationModel<VueloDTO>{
	
	private Long nro;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime fecha_hora;
	private Integer nro_filas;
	private Integer nro_asiento; //NRO DE ASIENTOS POR FILA
	private String tipo;
	private String destino;
	private String origen;
	private String estado;
	
	public VueloDTO() {
		super();
	}
	
	public VueloDTO(Vuelo vuelo) {
		super();
		this.nro = vuelo.getNro();
		this.fecha_hora = vuelo.getFecha_hora();
		this.nro_filas = vuelo.getNro_filas();
		this.nro_asiento = vuelo.getNro_asiento();
		this.tipo = vuelo.getTipo();
		this.destino = vuelo.getDestino();
		this.origen = vuelo.getOrigen();
		this.estado = vuelo.getEstado();
	}
	
	public Long getNro() {
		return nro;
	}
	public void setNro(Long nro) {
		this.nro = nro;
	}
	public LocalDateTime getFecha_hora() {
		return fecha_hora;
	}
	public void setFecha_hora(LocalDateTime fecha_hora) {
		this.fecha_hora = fecha_hora;
	}
	public Integer getNro_filas() {
		return nro_filas;
	}
	public void setNro_filas(Integer nro_filas) {
		this.nro_filas = nro_filas;
	}
	public Integer getNro_asiento() {
		return nro_asiento;
	}
	public void setNro_asiento(Integer nro_asiento) {
		this.nro_asiento = nro_asiento;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
