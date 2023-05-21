package com.daos.Request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VueloDTO {
	
	//ATRIBUTOS
	
	Long nro;
	
	@NotNull //NO PERMITE QUE UN CAMPO SEA NULO,PERO SI PERMITE QUE ESTÉ VACÍO
	@NotBlank //PARA VALIDAR QUE UNA CADENA NO ESTÉ VACÍA Y NO CONTENGA SOLO ESPACIOS EN BLANCO
	LocalDateTime fecha_hora;
	@NotNull
	@NotBlank
	Integer nro_filas;
	@NotNull
	@NotBlank
	Integer nro_asiento; //NRO DE ASIENTOS POR FILA
	@NotNull
	@NotBlank
	String tipo;
	@NotNull
	@NotBlank
	String destino;
	@NotNull
	@NotBlank
	String origen;
	@NotNull
	@NotBlank
	String estado;
	
	//GET Y SET
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
