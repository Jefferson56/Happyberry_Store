package com.happyberrystore.happyberry_store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.happyberrystore.happyberry_store.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}