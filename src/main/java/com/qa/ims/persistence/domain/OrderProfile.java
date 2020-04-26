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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProfile other = (OrderProfile) obj;
		if (oid == null) {
			if (other.oid != null)
				return false;
		} else if (!oid.equals(other.oid))
			return false;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		if (dateOrdered == null) {
			if (other.dateOrdered != null)
				return false;
		} else if (!dateOrdered.equals(other.dateOrdered))
			return false;
		return true;
	}

	public String toString() {
		return "order id: " + oid + " | customer id: " + cid + " | Date Ordered: " + dateOrdered
				+ "\n ------------------------------------------------------";
	}

}
