package com.sfa.pet.api.entity.util;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import com.sfa.pet.api.util.RandomUtil;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String TO_STRING_FMT = "%s[id=%d]";
	private transient long transientId = Math.abs(RandomUtil.nextLong()) * -1;

	public AbstractEntity(Long id) {
		setId(id);
	}

	public AbstractEntity() {
	}

	private long generateTransientId() {
		return transientId;
	}

	public abstract Long getId();

	public abstract void setId(Long id);

	public Long getSafeId() {
		return (getId() == null ? generateTransientId() : getId());
	}

	@Override
	public String toString() {
		return String.format(TO_STRING_FMT, getClass().getSimpleName(), getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode() + getSafeId().hashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (this == other)
			return true;
		if ((!(this.getClass().isInstance(other))) // Class
				&& (!other.getClass().isAssignableFrom(getClass()))) { // Subclass
			return false;
		}
		final Long otherId = ((AbstractEntity) other).getSafeId();
		return this.getSafeId().equals(otherId);
	}
}
