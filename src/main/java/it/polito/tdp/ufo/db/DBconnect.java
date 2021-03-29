package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {

	public static Connection getConnection() {  //abbiamo messo lo static perché getConnection è static

		String jdbcURL = "jdbc:mysql://localhost/ufo_sightings?user=root&password=Nikond7200";

		try {

			return DriverManager.getConnection(jdbcURL);


		} catch (SQLException e) {

			e.printStackTrace();

		}
		
			return null;

	}

}
