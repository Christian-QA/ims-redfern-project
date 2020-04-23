package com.qa.ims.persistence.domain;

import java.sql.Date;

public class OrderProfile {

	private Long oid;
	private Long cid;
	private Date dateOrdered;

	public OrderProfile(Long cid, Date dateOrdered) {
		this.cid = cid;
		this.dateOrdered = dateOrdered;
	}

	public OrderProfile(Long oid, Long cid, Date dateOrdered) {
		this.oid = oid;
		this.cid = cid;
		this.dateOrdered = dateOrdered;
	}

	public final Long getOid() {
		return oid;
	}

	public final void setOid(Long oid) {
		this.oid = oid;
	}

	public final Long getCid() {
		return cid;
	}

	public final void setCid(Long cid) {
		this.cid = cid;
	}

	public final Date getDateOrdered() {
		return dateOrdered;
	}

	public final void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((dateOrdered == null) ? 0 : dateOrdered.hashCode());
		return result;
	}

	public String toString() {
		return "order id: " + oid + " | customer id: " + cid + " | Date Ordered: " + dateOrdered
				+ "\n ------------------------------------------------------";
	}

}
