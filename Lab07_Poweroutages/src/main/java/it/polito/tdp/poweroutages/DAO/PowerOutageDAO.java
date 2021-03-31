package it.polito.tdp.poweroutages.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.poweroutages.model.Nerc;
import it.polito.tdp.poweroutages.model.PowerOutages;

public class PowerOutageDAO {
	
	//restituisce tutti i nerc dal database
	public List<Nerc> getNercList() {

		String sql = "SELECT id, value FROM nerc";
		List<Nerc> nercList = new ArrayList<>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				Nerc n = new Nerc(res.getInt("id"), res.getString("value"));
				nercList.add(n);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return nercList;
	}

	//restituisce tutti i power outages di un determinato nerc dal database
	public List<PowerOutages> getPOList(Nerc N) {
		
		String sql = "SELECT date_event_began AS begin,date_event_finished AS finished,customers_affected AS customers\r\n"
				+ "FROM poweroutages\r\n"
				+ "INNER JOIN nerc\r\n"
				+ "ON nerc.id=poweroutages.nerc_id\r\n"
				+ "WHERE nerc.id=?";
		
		List<PowerOutages> POList = new ArrayList<>();

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setInt(1, N.getId());
			
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				Timestamp b = res.getTimestamp("begin");
				Timestamp f = res.getTimestamp("finished");
				int c = res.getInt("customers");
				
				//inizialmente metto l'anno a 0, poi ci penserà il model
				PowerOutages p = new PowerOutages(0,b,f,c);
				
				POList.add(p);
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		if (POList!=null && !(POList.isEmpty())) {
			return POList;
		}
		
		return null;
	}
	

}
