package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	public DatabaseAccessorObject(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		String user = "student";
		String pass = "student";
		String sql = "SELECT * FROM film WHERE id = ?";
			
		if(rs.next()) {
			film = new Film();
			film.setId((filmId);
			film.setTitle(rs.getString("title"));
			film.setDescription(rs.getString("description"));
			film.setReleaseYear(rs.getString("release year"));
			film.setLanguageId(rs.getString("language"));
		}
		return null;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException{
		String user = "student";
		String pass = "student";
		Actor actor = null;
//...
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet ar = stmt.executeQuery();
		while(ar.next()) {
	        System.out.println(ar.getString("id") + " " +
	                           ar.getString("first_name") + " " +
	                           ar.getString("last_name"));
//			actor = new Actor(id, sql, sql); // Create the object
//			// Here is our mapping of query columns to our object fields:
//			actor.setId(ar.getInt(1));
//			actor.setFirstName(ar.getString(2));
//			actor.setLastName(ar.getString(3));
		}
//...
		return actor;
	}
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

}
