package com.daos.Response;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;
import com.daos.Entity.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteDTO extends RepresentationModel<ClienteDTO>{
	
	private Long dni;
	private String apellido;
	private String nombre;
	private String domicilio;
	private String email;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fecha_nac;
	private Long pasaporte;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	LocalDate fecha_pas;
	
	public ClienteDTO() {
		super();
	}
	
	public ClienteDTO (Cliente cliente) {
		super();
		this.dni = cliente.getDni();
		this.apellido = cliente.getApellido();
		this.nombre = cliente.getNombre();
		this.domicilio = cliente.getDomicilio();
		this.fecha_nac = cliente.getFecha_nac();
		this.email = cliente.getEmail();
		this.pasaporte = cliente.getPasaporte();
		this.fecha_pas = cliente.getFecha_pas();
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Long getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Long pasaporte) {
		this.pasaporte = pasaporte;
	}

	public LocalDate getFecha_pas() {
		return fecha_pas;
	}

	public void setFecha_pas(LocalDate fecha_pas) {
		this.fecha_pas = fecha_pas;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	}

