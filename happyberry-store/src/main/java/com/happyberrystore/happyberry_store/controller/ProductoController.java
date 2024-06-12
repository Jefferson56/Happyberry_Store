package com.happyberrystore.happyberry_store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyberrystore.happyberry_store.entity.Producto;
import com.happyberrystore.happyberry_store.entity.*;
import com.happyberrystore.happyberry_store.repository.ProductoRepository;



@RestController
@RequestMapping("/productos")
@CrossOrigin(origins="*")
public class ProductoController {

    //@Autowired
    //private ProductoService productoService;
    
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @PostMapping("/registro")
    public Producto createProductoE(@RequestBody Producto producto) { //crear un producto nuevo
        return productoRepository.save(producto);
        
    }  

    @PutMapping("/actualizar/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoActual = productoRepository.findById(id).orElseThrow(null);
        productoActual.setModelo(producto.getModelo());
        productoActual.setMarca(producto.getMarca());
        productoActual.setCantidad(producto.getCantidad());
        productoActual.setColor(producto.getColor());
        productoActual.setDetalles(producto.getDetalles());
        productoActual.setImagen(producto.getImagen());
        productoActual.setPrecio_compra(producto.getPrecio_compra());
        productoActual.setPrecio_venta(producto.getPrecio_venta());
        productoActual.setDescuento(producto.getDescuento());

        Producto updatedProducto = productoRepository.save(productoActual);
        return updatedProducto;
    }

    @DeleteMapping("/eliminar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        Producto producto = productoRepository.findById(id).orElseThrow(null); //busca el producto por el id y si no lo encuentra lanza un error

        productoRepository.delete(producto);
        return "Producto eliminado con id: " + id;
    }

    
}


