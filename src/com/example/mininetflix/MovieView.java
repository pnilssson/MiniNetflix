package com.example.mininetflix;

import java.util.Scanner;

/**
 * <h1>MovieView</h1>
 * Klassen MovieView visar all information om hur användaren vill hantera filmerna i programmet.
 * MovieView sparar även ner variablerna som användaren skriver in med hjälp av scanner-klassen.
 *
 *  @author Pär Nilsson
 *  @version 1.0
 *  @since 2018-10-9
 */
public class MovieView {
    /**
     * MovieView metoden skapar en instans för att kunna använda scanner klassen i de andra metoderna.
     * MovieView metoden skapar ännu en instans av MovieController klassen för att kunna kalla på denna genom variabeln movie i de andra metoderna.
     */
    private static Scanner input = new Scanner(System.in);
    private static MovieController movie = new MovieController();

    public static void display(){
        movie.showContent();
    }

    /**
     *  Metoden frågar användaren om namn på filmen, val av genre och betyg.
     *  Metoden anropar sedan MovieModel.add för att skapa ett objekt av dessa tre variablar
     *  Metoden anropar sedan movie.addContent vilket är en metod i MovieController klassen för att lägga till det nya objektet i ArrayListen.
     *
     * name Är variabeln för filmens namn
     * genre Är variabeln för filmens genre
     * rating Är variablen för filmens betyg
     */
    public static void add(){
        System.out.print("Namn på filmen: ");
        String name = input.nextLine();
        System.out.print("Är det en:\n" +
                "[1] Actionfilm\n" +
                "[2] Komedifilm\n" +
                "[3] Dramafilm\n" +
                "[4] Skräckfilm\n" +
                "[5] Dokumentärfilm\n");
        int genreMenuChoice = input.nextInt();
        input.nextLine();
        String genre = MiniNetflix.genreChoice(genreMenuChoice);
        System.out.print("Betygsätt filmen 1-5: ");
        int rating = input.nextInt();
        input.nextLine();
        MovieModel newMovieModel = MovieModel.add(name, genre, rating);
        movie.addContent(newMovieModel);
    }

    public static void remove(){
        System.out.println("Vilken film vill du ta bort från biblioteket: ");
        String name = input.nextLine();
        movie.removeContent(name);
    }

    public static void change(){
        System.out.println("Vilken film vill du ändra?");
        String name = input.nextLine();
        boolean doContinue = movie.controllExistence(name);
        if(doContinue){
            System.out.print("Välj ny kategori:\n" +
                    "[1] Actionfilm\n" +
                    "[2] Komedifilm\n" +
                    "[3] Dramafilm\n" +
                    "[4] Skräckfilm\n" +
                    "[5] Dokumentärfilm\n");
            int genreMenuChoice = input.nextInt();
            input.nextLine();
            String genre = MiniNetflix.genreChoice(genreMenuChoice);
            System.out.print("Välj nytt betyg 1-5: ");
            int rating = input.nextInt();
            input.nextLine();
            MovieModel movieModelToUpdate = MovieModel.add(name, genre, rating);
            movie.changeContent(name, movieModelToUpdate);
        }else{
            return;
        }
    }

    public static void search(){
        System.out.println("Vilken film söker du efter: ");
        String name = input.nextLine();
        movie.searchContent(name);
    }

    public static void addFavorite(){

        movie.showContent();
        System.out.println("Vilken film vill du lägga till i favoriter(1, 2, 3 etc): ");
        int favMovie = (input.nextInt() - 1);
        input.nextLine();
        movie.favoriteMovie(favMovie);
    }

    public static void displayFavorite(){
        movie.showFavorite();
    }

    /**
     * Metoden printar ur alternativen användaren har när den hanterar filmer.
     */
    public static void displayMovieMenu(){
        System.out.print("Välkommen till ditt filmbibliotek!\n" +
                "Vill du:\n" +
                "[0] Gå tillbaka.\n" +
                "[1] Se vilka filmer som finns.\n" +
                "[2] Lägg till en film.\n" +
                "[3] Ta bort en film.\n" +
                "[4] Ändra en film.\n" +
                "[5] Sök efter en film.\n" +
                "[6] Lägg till en favoritfilm.\n" +
                "[7] Se dina favoritfilmer.\n");
    }

}
