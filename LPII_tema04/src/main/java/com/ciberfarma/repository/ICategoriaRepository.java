package com.ciberfarma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciberfarma.entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {}
