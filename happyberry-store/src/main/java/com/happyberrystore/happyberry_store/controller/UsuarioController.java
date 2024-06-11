package com.happyberrystore.happyberry_store.controller;

import java.util.List;

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

import com.happyberrystore.happyberry_store.entity.Usuario;
import com.happyberrystore.happyberry_store.repository.UsuarioRepository;
import com.happyberrystore.happyberry_store.service.UsuarioService;



@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins="*")
public class UsuarioController {
	
		@Autowired
		private UsuarioService emailService;
		
	    @Autowired
	    private UsuarioRepository usuarioRepository;

	    @GetMapping
	    public List<Usuario> getAllUsuarios() {
	        return usuarioRepository.findAll();
	    }

	    @PostMapping("/registro")
	    public Usuario createUsuarioE(@RequestBody Usuario usuario) { //crear un usuario nuevo
	    	 	String to = usuario.getCorreo();
		        String subject = "Bienvenido a HappyBerry Store";
		        String text = "Estimado " + usuario.getNombre() + ",\n\n" +
		                      "Hola [Nombre del Usuario],\r\n"
		                      + "\r\n"
		                      + "¡Gracias por registrarte en HappyBerry Store! Estamos encantados de tenerte con nosotros.\r\n"
		                      + "\r\n"
		                      + "Para empezar a explorar y comprar, simplemente visita nuestro sitio web y accede a tu cuenta con los detalles proporcionados durante el registro. Si tienes alguna pregunta o necesitas ayuda, no dudes en contactarnos.\r\n"
		                      + "\r\n"
		                      + "Sigue estos sencillos pasos para comenzar:\r\n"
		                      + "\r\n"
		                      + "Inicia sesión: Visita [URL de inicio de sesión] e ingresa con tu correo electrónico y contraseña.\r\n"
		                      + "Explora: Navega por nuestras categorías y descubre productos increíbles.\r\n"
		                      + "Añade al carrito: Encuentra lo que te gusta y añádelo a tu carrito de compras.\r\n"
		                      + "Compra: Procede al pago de manera segura y rápida.\r\n"
		                      + "\n\n";
		        emailService.sendEmail(to, subject, text);
	    	return usuarioRepository.save(usuario);
	        
	    }	  

	    @GetMapping("/{id}")
	    public Usuario getUsuarioById(@PathVariable Long id) {
	        return usuarioRepository.findById(id).orElse(null);
	    }

	    @PutMapping("/{id}")
	    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
	        Usuario usuario = usuarioRepository.findById(id).orElse(null);
	        if (usuario != null) {
	            usuario.setNombre(usuarioDetails.getNombre());
	            usuario.setCorreo(usuarioDetails.getCorreo());
	            usuario.setContraseña(usuarioDetails.getContraseña());
	            usuario.setTipo_usuario(usuarioDetails.getTipo_usuario());
	            return usuarioRepository.save(usuario);
	        } else {
	            return null;
	        }
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUsuario(@PathVariable Long id) {
	        usuarioRepository.deleteById(id);
	    }
	}


