package com.sfa.pet.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sfa.pet.api.entity.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long> {

	Usuario findByEmail(String email);

}
