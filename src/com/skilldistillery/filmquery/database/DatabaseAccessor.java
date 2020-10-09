package com.skilldistillery.filmquery.database;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  public Actor findActorById(int actorId) throws SQLException;
  public List<Actor> findActorsByFilmId(int filmId);
  
  // use examples from fridays lesson after lunch to fill all this out
}