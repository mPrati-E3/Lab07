package it.polito.tdp.poweroutages.model;

import java.time.LocalDate;

public class PowerOutages {
	
	private int years;
	private LocalDate begin;
	private LocalDate finished;
	private int customers;
	
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public LocalDate getBegin() {
		return begin;
	}
	public void setBegin(LocalDate begin) {
		this.begin = begin;
	}
	public LocalDate getFinished() {
		return finished;
	}
	public void setFinished(LocalDate finished) {
		this.finished = finished;
	}
	public int getCustomers() {
		return customers;
	}
	public void setCustomers(int customers) {
		this.customers = customers;
	}
	
	public PowerOutages(int years, LocalDate begin, LocalDate finished, int customers) {
		super();
		this.years = years;
		this.begin = begin;
		this.finished = finished;
		this.customers = customers;
	}
	
	

}
