package com.qa.ims.persistence.domain;

public class OrderlineProfile {

	private Long pid;
	private Long oid;
	private Long quantityOrdered;

	public OrderlineProfile(Long pid, Long oid, Long quantityOrdered) {
		this.pid = pid;
		this.oid = oid;
		this.quantityOrdered = quantityOrdered;
	}

	public OrderlineProfile(Long oid) {
		this.oid = oid;
	}

	public final Long getPid() {
		return pid;
	}

	public final void setPid(Long pid) {
		this.pid = pid;
	}

	public final Long getOid() {
		return oid;
	}

	public final void setOid(Long oid) {
		this.oid = oid;
	}

	public final Long getQuantityOrdered() {
		return quantityOrdered;
	}

	public final void setQuantityOrdered(Long quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((quantityOrdered == null) ? 0 : quantityOrdered.hashCode());
		return result;
	}

	public String toString() {
		return "order id: " + oid + " | product id: " + pid + " | Quantity: " + quantityOrdered
				+ "\n ------------------------------------------------------";
	}

}
