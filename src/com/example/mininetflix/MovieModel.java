package com.example.mininetflix;

/**
 * <h1>MovieModel</h1>
 * Klassen skapar objekt av de variabler som användaren skriver in när de vill skapa en film tillsammans med dens genre och betyg att spara i biblioteket.
 * Klassen är en superklass till SerieModel.
 *
 *  @author Pär Nilsson
 *  @version 1.0
 *  @since 2018-10-9
 */
public class MovieModel {
    private String name;
    private String genre;
    private int rating;

    public MovieModel(String name, String genre, int rating){
        this.name = name;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() { return name; }

    public String getGenre() { return genre; }

    public int getRating() { return rating; }

    /**
     * Metoden tar emot ett namn, en genre och ett betyg.
     * De skapar sedan ett objekt utav detta som retuneras.
     *
     * @param name Filmens namn
     * @param genre Filmens genre
     * @param rating Filmens betyg
     *
     * @return Object
     */
    public static MovieModel add(String name, String genre, int rating) {
        return new MovieModel(name, genre, rating);
    }
}

