package com.ayi.ejercicio02.controller;

import com.ayi.ejercicio02.dao.model.Proveedor;
import com.ayi.ejercicio02.service.interf.IProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {

    private final IProveedorService iProveedorService;

    @Autowired
    public ProveedorController(IProveedorService iProveedorService) {
        this.iProveedorService = iProveedorService;
    }

    //Lista de Proveedores
    @GetMapping("/listado")
    public String mostrarListado(Model model) {

        // Obtencion de lista en modelo MProveedores
        model.addAttribute("MProveedores", iProveedorService.obtenerProveedores());

        // Envia titulo de controlador a vista
        model.addAttribute("tituloProveedores", "Listado de proveedores");

        return "listado";
    }


    //Alta Nuevo Proveedor (form)
    @GetMapping("/formNuevoProveedor")
    public String formNuevoProveedor(Model model) {
        Proveedor proveedor = new Proveedor();

        model.addAttribute("titulo","Alta de nuevo Proveedor");
        model.addAttribute("MProveedor",proveedor);

        return "nuevoProveedor";
    }

    //Guardar Nuevo Proveedor
    @PostMapping("/nuevoProveedor")
    public String guardaServicio(@Valid @ModelAttribute("MProveedor") Proveedor proveedor,
                                 BindingResult result,
                                 Model model){
        // Si hay errores de validación, regresar al formulario
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Alta de nuevo Proveedor");
            return "nuevoProveedor";
        }

        // Si no hay errores, guarda
        iProveedorService.guardarProveedores(proveedor);
        return "redirect:/listado";
    }

    //Editar Proveedor (form)
    @GetMapping("/editarProveedor/{idProveedor}")
    public String formularioEditarProveedor(@PathVariable Long idProveedor , Model model) {
        var proveedor = iProveedorService.obtenerProveedorPorId(idProveedor);

        model.addAttribute("titulo","Editar Proveedor existente");
        model.addAttribute("proveedor",proveedor);

        return "editarProveedor";
    }

    //Método que va a guardar la edicion del Proveedor existente
    @PostMapping("/actualizarProveedor/{idProveedor}")
    public String guardarEdicionProveedor(@PathVariable Long idProveedor ,
                                          @Valid @ModelAttribute("proveedor") Proveedor proveedor,
                                          BindingResult result,
                                          Model model){
        // Si hay errores de validación, regresar al formulario
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Editar Proveedor");
            return "editarProveedor";
        }

        Proveedor proveedorExistente = iProveedorService.obtenerProveedorPorId(idProveedor);
        proveedorExistente.setNombre(proveedor.getNombre());
        proveedorExistente.setTelefono(proveedor.getTelefono());
        proveedorExistente.setDireccion(proveedor.getDireccion());
        proveedorExistente.setEmail(proveedor.getEmail());
        proveedorExistente.setSitioWeb(proveedor.getSitioWeb());
        proveedorExistente.setEstado(proveedor.getEstado());



        // Si no hay errores, guarda
        iProveedorService.actualizarProveedor(proveedorExistente);
        return "redirect:/listado";
    }














    //Eliminar Proveedor
    @GetMapping("/eliminarProveedor/{idProveedor}")
    public String eliminarProveedor(@PathVariable Long idProveedor){
        iProveedorService.eliminarProveedores(idProveedor);

        return "redirect:/listado";
    }
}
