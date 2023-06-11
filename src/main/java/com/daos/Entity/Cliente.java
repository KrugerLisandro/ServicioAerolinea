package com.daos.Entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {
	
	@Id
	@Nonnull
	private Long dni;
	@Nonnull
	@Size(min = 1,max = 100, message = "Debe completar el nombre")
	private String nombre;
	@Nonnull
	@Size(min = 1,max = 100, message = "Debe completar el apellido")
	private String apellido;
	@Nonnull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	LocalDate fecha_nac;
	private String domicilio;
	@Nonnull
	@Email(message = "El e-mail ingresado no es valido")
	private String email;
	@Nonnull
	private Long pasaporte;
	@Nonnull
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	LocalDate fecha_pas;
	
	//GET Y SET
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
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

}
