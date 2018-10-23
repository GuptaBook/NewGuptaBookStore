package com.thirdware.guptabookstore.getconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	String ip = "204.246.56.130";
	String driverClass = "net.sourceforge.jtds.jdbc.Driver";
	String db = "guptadatabase";
	String un = "guptadatabase";
	String password = "tspl@123";

	public Connection CONN() {

		Connection conn = null;
		String ConnURL = null;

		try {

			Class.forName(driverClass);
			ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName=" + db + ";user=" + un + ";password="
					+ password + ";";
			conn = DriverManager.getConnection(ConnURL);
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} catch (ClassNotFoundException se) {
			System.out.println(se.getMessage());
		} catch (Exception se) {
			System.out.println(se.getMessage());
		}
		return conn;
	}

}
