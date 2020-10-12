package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;
		String user = "student";
		String pass = "student";
		String sq = "SELECT * FROM film WHERE id = ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sq);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			film = new Film(filmId, sq, sq, filmId, filmId, filmId, filmId, filmId, filmId, sq, sq);
			film.setId(rs.getInt("filmId"));
			film.setTitle(rs.getString("title"));
			film.setDescription(rs.getString("description"));
			film.setReleaseYear(rs.getInt("release year"));
			film.setLanguageId(rs.getInt("language"));
			film.setRentalDuration(rs.getInt("duration"));
			film.setRentalRate(rs.getDouble("rate"));
			film.setLength(rs.getInt("length"));
			film.setReplacementCost(rs.getDouble("cost"));
			film.setRating(rs.getString("rating"));
			film.setSpecialFeatures(rs.getNString("features"));
		}
		rs.close();
		stmt.close();
		conn.close();
		return film;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException{
		String user = "student";
		String pass = "student";
		Actor actor = null;
		
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet ar = stmt.executeQuery();
		while(ar.next()) {
			actor.setId(ar.getInt(1));
		    actor.setFirstName(ar.getString(2));
		    actor.setLastName(ar.getString(3));
//	        System.out.println(ar.getString("id") + " " +
//	                           ar.getString("first_name") + " " +
//	                           ar.getString("last_name"));
//			actor = new Actor(actord, sql, sql); // Create the object
//			// Here is our mapping of query columns to our object fields:
//			actor.setId(ar.getInt(1));
//			actor.setFirstName(ar.getString(2));
//			actor.setLastName(ar.getString(3));
		}
		return actor;
	}
	

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		String user = "student";
		String pass = "student";
		List<Actor> films = new ArrayList<>();
		  try {
		    Connection conn = DriverManager.getConnection(URL, user, pass);
		    String sql = "SELECT id, first_name, last_name"
		               +  " FROM actor JOIN film_film ON actor.id = film_actor.film_id "
		               + " WHERE actor_id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, filmId);
		    ResultSet rs = stmt.executeQuery();
	}catch (Exception e) {
		e.printStackTrace();
	}
		  return actor;
	}

}
