package com.sfa.pet.api.security.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.sfa.pet.api.entity.Usuario;
import com.sfa.pet.api.enumeration.PerfilEnum;

public class JwtUserFactory {

	private JwtUserFactory() {
	};

	public static JwtUser create(final Usuario user) {
		return new JwtUser(user.getId().toString(), user.getEmail(), user.getSenha(), user.getStatus(),
				mapToGrantedAuthorities(user.getPerfil()));
	}

	private static Collection<? extends GrantedAuthority> mapToGrantedAuthorities(final PerfilEnum profileEnum) {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profileEnum.toString()));
		return authorities;
	}
}
