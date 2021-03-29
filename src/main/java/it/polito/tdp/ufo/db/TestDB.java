package it.polito.tdp.ufo.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestDB {
//
//	public static void main(String[] args) {
//
//		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=Nikond7200";
//
//		//potrebbe dare errore perché si ha a che fare con un server e potrebbe esserci problemi
//		try {
//
//
//			Connection conn = DriverManager.getConnection(jdbcURL);
//
//			String sql = "SELECT DISTINCT shape "
//					+ "FROM sighting "
//					+ "WHERE shape<>'' "
//					+ "ORDER BY shape ASC" ;
//
//			PreparedStatement st = conn.prepareStatement(sql);
//
//			ResultSet res = st.executeQuery();
//
//			List <String> formeUFO = new ArrayList<>();
//
//			while( res.next() ){
//				String forma = res.getString("shape");
//				formeUFO.add(forma) ;
//			}
//
//			st.close();
//
//			System.out.println(formeUFO);
//
//
//			// Seconda Query
//
//			String sql2 = "SELECT COUNT(*) As cnt FROM sighting WHERE shape = ? ";
//
//			String shapeScelta = "circle";
//
//			PreparedStatement st2 = conn.prepareStatement(sql2);
//
//			st2.setString(1, shapeScelta);
//
//			ResultSet res2 = st2.executeQuery(); //mette insieme st2 e sql2
//
//			res2.first(); //corrisponde a ciclo ma essendoci una sola riga (count) non 
//			c'e bisogno di muoversi fra le righe, bsta prendere la prima colonna
//
//			int count = res2.getInt("cnt");
//
//			st2.close();
//			conn.close();
//
//			System.out.println("UFO di forma "+shapeScelta+" sono: "+count);
//
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//}




public class TestDB {

	public static void main(String[] args) {
		
		SightingDAO DAO = new SightingDAO();
		
		String shape = "circle" ;
		int num = DAO.countByShape(shape);
		System.out.println("UFO di forma "+shape+" sono: "+num);
		

	}
}




















