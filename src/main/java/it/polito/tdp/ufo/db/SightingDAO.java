package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SightingDAO {

	public List<String> readShapes(){
		try {
			
			
			Connection conn = DBconnect.getConnection();

			String sql = "SELECT DISTINCT shape " //lascia sempre spazio alla fine così per ex. shape e from non risultano attaccati
					+ "FROM sighting "
					+ "WHERE shape<>'' "
					+ "ORDER BY shape ASC" ;
			
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet res = st.executeQuery();

			List <String> formeUFO = new ArrayList<>();
			
			while(res.next()){
				String forma = res.getString("shape");
				formeUFO.add(forma) ;
			}
			
			st.close();
			conn.close();
			return formeUFO;

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		

	}

	public int countByShape(String shape) {
		
		try {
			
			Connection conn = DBconnect.getConnection();
			
			String sql = "SELECT COUNT(*) as cnt FROM sighting WHERE shape = ? " ;
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, shape);
			
			
			ResultSet res = st.executeQuery();
			
			res.first();
			
			int count = res.getInt("cnt");
			
			st.close();
			conn.close();
						
			return count;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return -1;

	}

}
