package it.polito.tdp.poweroutages.model;

import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<PowerOutages> getPOList(Nerc N) {
		return podao.getPOList(N);
	}

	@SuppressWarnings("deprecation")
	public List<PowerOutages> faiWCA(Nerc n, int y, int h) {
		
		List<PowerOutages> PO = this.getPOList(n);
		
		for (PowerOutages po : PO) {
			po.setYear(po.getBegin().getYear()+1900);
		}
		
		return PO;
	}

}
