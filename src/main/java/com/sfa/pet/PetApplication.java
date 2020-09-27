package com.sfa.pet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sfa.pet.api.dao.UserRepository;
import com.sfa.pet.api.entity.Usuario;
import com.sfa.pet.api.enumeration.PerfilEnum;
import com.sfa.pet.api.enumeration.StatusEnum;

@SpringBootApplication
public class PetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initUsers(userRepository, passwordEncoder);
		};
	}

	private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		Usuario admin = new Usuario();
		admin.setEmail("admin@helpdesk.com");
		admin.setNome("admin");
		admin.setSenha(passwordEncoder.encode("123456"));
		admin.setPerfil(PerfilEnum.ROLE_ADMIN);
		admin.setStatus(StatusEnum.ACTIVE);

		Usuario find = userRepository.findByEmail(admin.getEmail());
		if (find == null) {
			userRepository.save(admin);
		}
	}

}
