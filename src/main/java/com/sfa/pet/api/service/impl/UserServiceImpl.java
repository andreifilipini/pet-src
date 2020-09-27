package com.sfa.pet.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sfa.pet.api.dao.UserRepository;
import com.sfa.pet.api.entity.Usuario;
import com.sfa.pet.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Usuario findByEmail(String email) {
		return this.userRepository.findByEmail(email);
	}

	@Override
	public Usuario createOrUpdate(Usuario user) {
		return this.userRepository.save(user);
	}

	@Override
	public Usuario findById(Long id) {
		return this.userRepository.getOne(id);
	}

	@Override
	public void delete(Long id) throws Exception {
		this.userRepository.deleteById(id);
	}

	@Override
	public Page<Usuario> findAll(int page, int count) {
		return this.userRepository.findAll(PageRequest.of(page, count));
	}

}
