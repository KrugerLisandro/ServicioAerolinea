package com.daos.Request;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.daos.Entity.Vuelo;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// OBJETO NECESARIO PARA INSERTAR, ACTUALIZAR O ELIMINAR UN VUELO.

public class VueloRequest {
	
	//ATRIBUTOS
	private Long nro;
	@NotNull(message = "La fecha y hora no pueden ser nulas")
	@FutureOrPresent(message = "La fecha y hora deben ser en el futuro o en el presente")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime fecha_hora;
	@NotNull(message = "El número de filas no puede ser nulo")
	private Integer nro_filas;
	@NotNull(message = "El número de asientos no puede ser nulo")
	private Integer nro_asientos; //NRO DE ASIENTOS POR FILA
	@NotNull(message = "El tipo no puede ser nulo")
	@NotBlank(message = "El tipo no puede estar vacío o contener solo espacios en blanco")
	private String tipo;
	@NotNull(message = "El destino no puede ser nulo")
	@NotBlank(message = "El destino no puede estar vacío o contener solo espacios en blanco")
	String destino;
	/*@NotNull
	@NotBlank
	String origen POR EL MOMENTO SIEMPRE SERA AEROPUERTO SAUCE VIEJO*/;
	
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
	public Integer getNro_asientos() {
		return nro_asientos;
	}
	public void setNro_asientos(Integer nro_asientos) {
		this.nro_asientos = nro_asientos;
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
	/*public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}*/
	
	//ENTIDAD VUELO
	public Vuelo toEntidad() {
		
		Vuelo newVuelo = new Vuelo();
		newVuelo.setNro(this.nro);
		newVuelo.setFecha_hora(this.fecha_hora);
		newVuelo.setNro_filas(this.nro_filas);
		newVuelo.setNro_asiento(this.nro_asientos);
		newVuelo.setTipo(this.tipo);
		newVuelo.setDestino(this.destino);
		newVuelo.setOrigen("sauce_viejo");
		newVuelo.setEstado("registrado");
		return newVuelo;
	}
	
}
