package com.happyberrystore.happyberry_store.entity;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tipo_usuario")
@CrossOrigin
public class TipoUsuario {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false, unique = true)
	    private String nombre;

	    @ManyToMany(mappedBy = "tipo_usuario", fetch = FetchType.LAZY)
	    private Set<Usuario> usuarios;
	}
