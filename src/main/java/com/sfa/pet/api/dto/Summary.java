package com.sfa.pet.api.dto;

import java.io.Serializable;

public class Summary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9060478805302749481L;

	private Integer amountNew = 0;
	private Integer amountResolved = 0;
	private Integer amountApproved = 0;
	private Integer amountDisapproved = 0;
	private Integer amountAssigned = 0;
	private Integer amountClosed = 0;

	public Integer getAmountNew() {
		return amountNew;
	}

	public void setAmountNew(Integer amountNew) {
		this.amountNew = amountNew;
	}

	public Integer getAmountResolved() {
		return amountResolved;
	}

	public void setAmountResolved(Integer amountResolved) {
		this.amountResolved = amountResolved;
	}

	public Integer getAmountApproved() {
		return amountApproved;
	}

	public void setAmountApproved(Integer amountApproved) {
		this.amountApproved = amountApproved;
	}

	public Integer getAmountDisapproved() {
		return amountDisapproved;
	}

	public void setAmountDisapproved(Integer amountDisapproved) {
		this.amountDisapproved = amountDisapproved;
	}

	public Integer getAmountAssigned() {
		return amountAssigned;
	}

	public void setAmountAssigned(Integer amountAssigned) {
		this.amountAssigned = amountAssigned;
	}

	public Integer getAmountClosed() {
		return amountClosed;
	}

	public void setAmountClosed(Integer amountClosed) {
		this.amountClosed = amountClosed;
	}

}
