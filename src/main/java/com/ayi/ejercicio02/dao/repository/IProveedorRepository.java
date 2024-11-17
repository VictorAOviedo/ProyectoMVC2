package com.ayi.ejercicio02.dao.repository;

import com.ayi.ejercicio02.dao.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Long> {
}
