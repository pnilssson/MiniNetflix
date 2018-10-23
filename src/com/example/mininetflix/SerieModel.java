package com.example.mininetflix;

/**
 * <h1>SerieModel</h1>
 * Klassen skapar objekt av de variabler som användaren skriver in när de vill skapa en serie tillsammans att spara i filmbibliotekt.
 * Klassen är en subklass till MovieModel.
 *
 *  @author Pär Nilsson
 *  @version 1.0
 *  @since 2018-10-9
 */
public class SerieModel extends MovieModel {
    private String isLastSeasonReleased;
    private int seasons;
    private int episodes;

    /**
     * Metoden hämtar namn, genre och rating ifrån sin superklass MovieModel
     * Metoden sparar ner om sista säsongen är släppt, antal säsonger samt antal episoder utav serien som finns i ett objekt när metoden SerieModel add() körs.
     *
     * @param name Seriens namn
     * @param genre Seriens genre
     * @param rating Seriens betyg
     * @param isLastSeasonReleased Om seriens sista säsong är släppt eller ej
     * @param seasons Seriens antal säsonger
     * @param episodes Seriens antal avsnitt
     */
    public SerieModel(String name, String genre, int rating, String isLastSeasonReleased, int seasons, int episodes){
        super(name, genre, rating);
        this.isLastSeasonReleased = isLastSeasonReleased;
        this.seasons = seasons;
        this.episodes = episodes;
    }

    /**
     * Metoden är en get-metod för den privata variabeln isLastSeasonReleased
     * Metoden används i klassen SerieController
     *
     * @return String
     */
    public String getIsLastSeasonReleased() { return isLastSeasonReleased; }

    public int getSeasons() { return seasons; }

    public int getEpisodes() { return episodes; }


    public static SerieModel add(String name, String genre, int rating, String isLastSeasonReleased, int seasons, int episodes) {
        return new SerieModel(name, genre, rating, isLastSeasonReleased, seasons, episodes);
    }
}
