package it.polito.tdp.poweroutages.model;

import java.sql.Timestamp;
import java.util.Date;

public class PowerOutages {
	
	private int year;
	private Date begin;
	private Date finished;
	private int customers;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Timestamp begin) {
		this.begin = begin;
	}
	public Date getFinished() {
		return finished;
	}
	public void setFinished(Timestamp finished) {
		this.finished = finished;
	}
	public int getCustomers() {
		return customers;
	}
	public void setCustomers(int customers) {
		this.customers = customers;
	}
	
	public PowerOutages(int year, Date b, Date f, int customers) {
		super();
		this.year = year;
		this.begin = b;
		this.finished = f;
		this.customers = customers;
	}
	
	

}
