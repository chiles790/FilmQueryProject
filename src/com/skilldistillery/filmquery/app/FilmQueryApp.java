package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

//	private void test() throws SQLException {
//		Film film = db.findFilmById(1);
//		System.out.println(film);
//	}

	void launch() throws SQLException {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) throws SQLException {

		System.out.println("Hello! Welcome to Film Query");
		System.out.println();

		boolean menu = true;

		while (menu) {
			int userInput;
			int filmId;
			System.out.println("Please select an option: ");
			System.out.println("1. Look up a film by its ID");
			System.out.println("2. Look up a film by a search keyword");
			System.out.println("3. Exit");
			userInput = input.nextInt();

			switch (userInput) {

			case 1:
				System.out.println("Please enter a film ID:");
				filmId = input.nextInt();
				Film result = (db.findFilmById(filmId));
				if (result != null) {
					System.out.println();
					result.displayInfo();
					System.out.println();
				}
				break;
			case 2:
				String keyword;
				System.out.println("Please enter a search keyword:");
				keyword = input.next();
				java.util.List<Film> results = db.findFilmBySearch(keyword);
				if (results.size() != 0) {
					for (Film film : results) {
						System.out.println();
						film.displayInfo();
						System.out.println();
					}
				} else {
					System.out.println("no results found");
					System.out.println();
				}
				break;
			case 3:
				System.out.println("Have a nice day!");
				menu = false;
				break;
			}

		}
	}

}
