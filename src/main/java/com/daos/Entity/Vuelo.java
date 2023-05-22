package com.daos.Entity;

import java.time.LocalDateTime;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vuelo {
	
	//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long nro;
	@Nonnull // ESTA ANOTACIÓN SE UTILIZA PARA DOCUMENTAR QUE UN CAMPO O PARÁMETRO NO PUEDE SER NULO. ANOTACIÓN DE JetBrains
	LocalDateTime fecha_hora;
	private @Nonnull
	Integer nro_filas;
	@Nonnull
	private Integer nro_asiento; //NRO DE ASIENTOS POR FILA
	@Nonnull
	private String tipo;
	@Nonnull
	private String destino;
	@Nonnull
	private String origen;
	@Nonnull
	private String estado;
	
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
	
	/*POR EL MOMNETO SERÁ SIEMPRE AEROPUERTO SAUCE VIEJO YA QUE SOLO CONSIDERAREMOS LA VENTA DE
	PASAJES QUE PARTAN DESDE ESTE LUGAR*/
	public String getEstado() {
		return estado;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
