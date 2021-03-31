package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.Date;
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

	@SuppressWarnings({ "deprecation", "null" })
	public List<PowerOutages> faiWCA(Nerc n, int y, int h) {
		
		List<PowerOutages> PO = this.getPOList(n);
		
		List<PowerOutages> PBOX = new ArrayList<PowerOutages>();
		
		if (PO!=null && !(PO.isEmpty())) {
			
			Date DF = new Date();
			DF.setHours(h);
			DF.setYear(y);
		
			for (PowerOutages po : PO) {
				po.setYear(po.getBegin().getYear()+1900);
			}
		
			for (int i=0; i<PO.size(); i++) {
				if (PO.get(i).getYear() < y) {
					PBOX.add(PO.get(i));
				}
			}
		
		}
		
		return PBOX;
	}

}
