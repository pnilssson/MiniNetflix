package com.example.mininetflix;

import java.util.ArrayList;

/**
 * <h1>MovieController</h1>
 * Klassen MovieController får information ifrån MovieView om vilken metod som ska utföras och retunerar sedan diverse information.
 *
 *  @author Pär Nilsson
 *  @version 1.0
 *  @since 2018-10-9
 */


public class MovieController{
    private ArrayList<MovieModel> allMovies;
    /**
     * I MovieController skapar vi ArrayListen som vi ska spara samtliga filmer med deras genre och betyg i.
     */
    public MovieController(){
        this.allMovies = new ArrayList<>();
    }

    /**
     * Metoden loopar igenom ArrayListen allMovies och skriver ut alla filmernas namn, genre och betyg.
     */
    public void showContent(){
        System.out.println("Följande filmer finns i filmbiblioteket:");
        for(int i = 0; i < allMovies.size(); i++){
            System.out.println("Film " + (i+1) + ":\n\t" +
                    this.allMovies.get(i).getName() +
                    "\n\tGenre: " +
                    this.allMovies.get(i).getGenre() +
                    "\n\tRating: " +
                    this.allMovies.get(i).getRating());
        }
    }

    public void addContent(MovieModel newMovieModel) {
        allMovies.add(newMovieModel);
    }

    public void removeContent(String name){
        MovieModel objectToRemove = findObject(name);
        if(objectToRemove == null){
            System.out.println("Filmen finns inte i filmbiblioteket.");
        }else {
            this.allMovies.remove(objectToRemove);
            System.out.println(name + " har tagits bort från filmbilbioteket.");
        }
    }

    public void changeContent(String name, MovieModel movieModelToUpdate){
        MovieModel objectToChange = findObject(name);
        if(objectToChange == null) {
            System.out.println("Filmen finns inte i filmbiblioteket.");
        }else{
            this.allMovies.set(findIndex(name), movieModelToUpdate);
            System.out.println(name + " har ändrats.");
        }
    }

    public void searchContent(String name){
        MovieModel objectToDisplay = findObject(name);
        if(objectToDisplay == null){
            System.out.println("Filmen finns inte i filmbiblioteket.");
        }
        System.out.println("Film:\n\t" +
                this.allMovies.get(findIndex(name)).getName() +
                "\n\tGenre: " +
                this.allMovies.get(findIndex(name)).getGenre() +
                "\n\tRating: " +
                this.allMovies.get(findIndex(name)).getRating());
    }

    public boolean controllExistence(String name){
        MovieModel objectToChange = findObject(name);
        if(objectToChange == null) {
            System.out.println("Filmen finns inte i filmbiblioteket.");
            return false;
        }return true;
    }

    private int findIndex(String objectName){
        //Loopar igenom Arraylisten för att örsäkra oss om att objektet finns
        for(int i = 0; i<this.allMovies.size(); i++){
            MovieModel movieModel = this.allMovies.get(i);
            if(movieModel.getName().equals(objectName)){
                return i;
            }
        }
        return -1;
    }
    //Retunerar ett objekt med hjälp av namnet man tilldelat objektet i ArrayListen
    private MovieModel findObject(String name){
        int index = findIndex(name);
        //Finns objektet i arraylisten retunerars det
        //Annars retuneras null som vi använder oss av för att visa användaren att objektet inte går att hitta
        if(index >=0) {
            return this.allMovies.get(index);
        }
        return null;
    }
}
