package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	//prendo il DAO dalla classe dedicata
	PowerOutageDAO podao;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	//ritorna la lista di tutti i nerc
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	//ritorna la lista di tutti i power outages di un determinato nerc
	public List<PowerOutages> getPOList(Nerc N) {
		return podao.getPOList(N);
	}

	//esegue la WCA chiamata dal controller
	@SuppressWarnings({ "deprecation" })
	public List<PowerOutages> faiWCA(Nerc n, int y, int h) {
		
		//prendo la lista di tutti i power outages del nerc passato
		List<PowerOutages> PO = this.getPOList(n);
		
		//lista di power outage di servizio, la andrò a comporre e poi la stamperò
		List<PowerOutages> PBOX = new ArrayList<PowerOutages>();
		
		if (PO!=null && !(PO.isEmpty())) {
			
			//imposto l'anno a quello in cui è finito il power outages
			for (PowerOutages po : PO) {
				po.setYear(po.getFinished().getYear()+1900);
			}
						
			//controllo per la WCA: se l'anno che ho impostato è minore di quello chiesto dall'utente E
			//la differenza di tempo tra quando è finito e quando è iniziato (millisencondi) è minore delle
			//ore passate da utente (millisecondi), allora inserisco il power outage nella lista box
			for (int i=0; i<PO.size(); i++) {
				
				if ((PO.get(i).getYear() <= y) &&
						((PO.get(i).getFinished().getTime()-PO.get(i).getBegin().getTime()) <= h*3600000)) {
					PBOX.add(PO.get(i));
				}
				
			}
			
			
		
		}
		
		return PBOX;
	}

}
