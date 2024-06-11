package com.happyberrystore.happyberry_store.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="usuario")
public class Usuario {
	 	@Id
	 	@Column(name="id_usuario" )
	 	@GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id_usuario;
	 	@Column(name="nombre")
	    private String nombre;
	 	@Column(name="apellido")
	 	private String apellido;
	 	@Column(name="tipo_documento")
	 	private String tipo_documento;
	 	@Column(name="nacionalidad") 
	 	private String nacionalidad;
	 	@Column(name="celular")
	 	private String celular;
	 	@Column(name="correo")
	    private String correo;
	 	@Column(name="contraseña")
	    private String contraseña;
	 	@ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "usuario_tipo_usuario",
	        joinColumns = @JoinColumn(name = "id_usuario"),
	        inverseJoinColumns = @JoinColumn(name = "id_tipo_usuario")
	    )
	 	private Set<TipoUsuario>tipo_usuario;
	 	
	 	
		public Long getId_usuario() {
			return id_usuario;
		}
		public void setId_usuario(Long id_usuario) {
			this.id_usuario = id_usuario;
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
		public String getTipo_documento() {
			return tipo_documento;
		}
		public void setTipo_documento(String tipo_documento) {
			this.tipo_documento = tipo_documento;
		}
		public String getNacionalidad() {
			return nacionalidad;
		}
		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}
		public String getCelular() {
			return celular;
		}
		public void setCelular(String celular) {
			this.celular = celular;
		}
		public String getCorreo() {
			return correo;
		}
		public void setCorreo(String correo) {
			this.correo = correo;
		}
		public String getContraseña() {
			return contraseña;
		}
		public void setContraseña(String contraseña) {
			this.contraseña = contraseña;
		}
		public Set<TipoUsuario> getTipo_usuario() {
			return tipo_usuario;
		}
		public void setTipo_usuario(Set<TipoUsuario> tipo_usuario) {
			this.tipo_usuario = tipo_usuario;
		}
	 	
	 	
	 	
}