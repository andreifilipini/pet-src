package com.sfa.pet.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sfa.pet.api.entity.util.AbstractEntity;
import com.sfa.pet.api.enumeration.PerfilEnum;
import com.sfa.pet.api.enumeration.StatusEnum;

@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6462209812185933652L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_usuario")
	private Long id;

	private String email;

	private String nome;

	private String senha;

	@Enumerated(EnumType.STRING)
	@Column(name = "situacao")
	private StatusEnum status;

	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
