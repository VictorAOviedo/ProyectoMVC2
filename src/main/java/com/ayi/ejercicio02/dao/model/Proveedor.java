package com.ayi.ejercicio02.dao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "proveedores")
public class Proveedor implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProveedor;

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotNull(message = "El telefono es obligatorio")
    private Long telefono;

    private String direccion;

    @Email(message = "Debe ser un correo electronico válido")
    private String email;

    private String sitioWeb;

    @NotNull(message = "El estado no puede estar vacío")
    private Integer estado;
}
