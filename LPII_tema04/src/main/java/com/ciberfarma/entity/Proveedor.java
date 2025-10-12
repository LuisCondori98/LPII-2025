package com.ciberfarma.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_proveedor")
public class Proveedor {

	@Id
	private Integer idproveedor;
	private String nombre_rs;
	private String telefono;
	private String email;
}
