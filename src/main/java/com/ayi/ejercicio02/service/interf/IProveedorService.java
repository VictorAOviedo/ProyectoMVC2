package com.ayi.ejercicio02.service.interf;

import com.ayi.ejercicio02.dao.model.Proveedor;

import java.util.List;

public interface IProveedorService {
    List<Proveedor> obtenerProveedores();
    Proveedor guardarProveedores(Proveedor proveedor);
    Proveedor obtenerProveedorPorId(Long idProveedor);
    Proveedor actualizarProveedor(Proveedor proveedor);
    void eliminarProveedores(Long idProveedor);
}
