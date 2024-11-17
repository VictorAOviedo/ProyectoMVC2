package com.ayi.ejercicio02.service.impl;

import com.ayi.ejercicio02.dao.model.Proveedor;
import com.ayi.ejercicio02.dao.repository.IProveedorRepository;
import com.ayi.ejercicio02.service.interf.IProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImpl implements IProveedorService {

    private final IProveedorRepository  iProveedorRepository;

    @Autowired
    public ProveedorServiceImpl(IProveedorRepository iProveedorRepository) {
        this.iProveedorRepository = iProveedorRepository;
    }

    @Override
    public List<Proveedor> obtenerProveedores() {
        return (List<Proveedor>) iProveedorRepository.findAll();
    }

    @Override
    public Proveedor guardarProveedores(Proveedor proveedor) {
        return iProveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor obtenerProveedorPorId(Long idProveedor) {
        return iProveedorRepository.findById(idProveedor).get();
    }

    @Override
    public Proveedor actualizarProveedor(Proveedor proveedor) {
        return iProveedorRepository.save(proveedor);
    }

    @Override
    public void eliminarProveedores(Long idProveedor) {
        iProveedorRepository.deleteById(idProveedor);
    }
}
