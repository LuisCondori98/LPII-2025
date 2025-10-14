package com.ciberfarma.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_usua;
	private String nom_usua;
	private String ape_usua;
	@Column(name = "usr_usua")
	private String correo;
	@Column(name = "cla_usua")
	private String clave;
	private String fna_usua;
	private int idtipo = 2;
	private int est_usua = 1;
}
