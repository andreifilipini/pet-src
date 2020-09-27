package com.sfa.pet.api.enumeration;

public enum PerfilEnum {
	ROLE_ADMIN,

	ROLE_CUSTOMER,

	ROLE_TECHNICIAN;
	
	public static PerfilEnum getStatus(String profile) {
		for (PerfilEnum pe : PerfilEnum.values()) {
			if (pe.name().equalsIgnoreCase(profile)) {
				return pe;
			}
		}
		return null;
	}

}
