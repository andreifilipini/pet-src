package com.sfa.pet.api.enumeration;

public enum StatusEnum {
	ACTIVE,

	EXPIRED,

	LOCKED,

	;

	public static StatusEnum getStatus(final String profile) {
		for (final StatusEnum pe : StatusEnum.values()) {
			if (pe.name().equalsIgnoreCase(profile)) {
				return pe;
			}
		}
		return null;
	}

}
