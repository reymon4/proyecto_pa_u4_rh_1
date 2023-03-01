package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "per_seq")
	@SequenceGenerator(name = "per_seq", sequenceName = "per_seq", allocationSize = 1)
	@Column(name = "per_id")
	private Integer id;

	@Column(name = "per_nombre")
	private String nombre;

	@Column(name = "per_apellido")
	private String apellido;

	@Column(name = "per_genero")
	private String genero;

	@Column(name = "per_cedula")
	private String cedula;
	
	

}
