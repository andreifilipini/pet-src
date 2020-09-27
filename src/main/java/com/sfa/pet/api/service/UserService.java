package com.sfa.pet.api.service;

import org.springframework.data.domain.Page;

import com.sfa.pet.api.entity.Usuario;

public interface UserService {

	Usuario findByEmail(String email);

	Usuario createOrUpdate(Usuario user);

	void delete(Long id) throws Exception;

	Page<Usuario> findAll(int page, int count);

	Usuario findById(Long id);

}
