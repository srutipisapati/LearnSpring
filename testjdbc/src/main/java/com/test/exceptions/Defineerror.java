package com.test.exceptions;

import java.time.LocalDateTime;

public class Defineerror {
	
private String description;
private String status;
private  LocalDateTime datetime;
public String getDescription() {
	return description;
}
public String getStatus() {
	return status;
}
public LocalDateTime getDatetime() {
	return datetime;
}

public Defineerror(String description, String status, LocalDateTime datetime) {
	super();
	this.description = description;
	this.status = status;
	this.datetime = datetime;
}

}
