package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Ciudad;

@Repository
public interface ICiudadDao extends CrudRepository<Ciudad, Integer>{

}
