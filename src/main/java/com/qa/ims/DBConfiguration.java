package com.qa.ims;

public class DBConfiguration {

	private String jdbcConnectionUrl = "jdbc:mysql://35.205.154.97/imsDB";
	private String imsDBSchema = "src/main/resources/imsDB-schema.sql";

	public final String getImsDBSchema() {
		return imsDBSchema;
	}

	public final void setImsDBSchema(String imsDBSchema) {
		this.imsDBSchema = imsDBSchema;
	}

	public final String getJdbcConnectionUrl() {
		return jdbcConnectionUrl;
	}

	public final void setJdbcConnectionUrl(String jdbcConnectionUrl) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
	}

}
