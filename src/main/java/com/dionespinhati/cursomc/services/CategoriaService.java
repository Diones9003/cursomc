package com.dionespinhati.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dionespinhati.cursomc.domain.Categoria;
import com.dionespinhati.cursomc.repositories.CategoriaRepository;
import com.dionespinhati.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	
	public Optional<Categoria> buscar(Integer id) {
		//Categoria obj = repo.findOne(id); Na Aula utiliza se o findOne
		// avaliar possiveis erros com o getOne
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! ID: " + id 
					+ ", Tipo " + Categoria.class.getName());  
		}
		return obj;
	}

}
