package com.example.mininetflix;

import java.util.Scanner;

/**
 *<h1>MiniNetflix</h1>
 * MiniNetflix är ett film och seriebibliotek där du kan lägga till,
 * visa, ta bort, ändra och söka efter filmer och serier.
 *
 * @author Pär Nilsson
 * @version 1.0
 * @since 2018-10-9
 */
public class MiniNetflix {
    private static Scanner input = new Scanner(System.in);
    private static boolean notExit = true;

    public static void main(String args[]) {
        mainMenu();
    }

    /**
     * Metoden visar huvudmenyn där man får välja om man ska hantera filmer, serier eller avsluta programmet.
     */
    private static void mainMenu(){
        displayMainMenu();
        do {
            System.out.print("Ditt val: ");
            int menuChoice = input.nextInt();
            input.nextLine();
            switch(menuChoice) {
                case 0:
                    doExit();
                    break;
                case 1:
                    movieMenu();
                    break;
                case 2:
                    serieMenu();
                    break;
                default:
                    System.out.println("\nVälj ett giltigt val [0], [1] eller [2].\n");
                    break;
            }
        }while(notExit);
    }

    /**
     * Metoden visar filmmenyn för användaren och kör olika metoder från MovieView klassen beroende på vad användaren vill göra.
     */
    private static void movieMenu() {
        MovieView.displayMovieMenu();
        do {
            System.out.print("[6]. För att se dina alternativ.\n" +
                    "Vad vill du göra härnest?: ");
            int menuChoice = input.nextInt();
            input.nextLine();
            switch (menuChoice) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    MovieView.display();
                    break;
                case 2:
                    MovieView.add();
                    break;
                case 3:
                    MovieView.remove();
                    break;
                case 4:
                    MovieView.change();
                    break;
                case 5:
                    MovieView.search();
                    break;
                case 6:
                    MovieView.displayMovieMenu();
                    break;
                default:
                    System.out.println("\nVälj ett giltigt val [0], [1], [2], [3], [4], [5] eller [6].\n");
                    break;
            }
        } while (notExit);
    }

    private static void serieMenu() {
        SerieView.displaySerieMenu();
        do {
            System.out.print("[6]. För att se dina alternativ.\n" +
                    "Vad vill du göra härnest?: ");
            int menuChoice = input.nextInt();
            input.nextLine();
            switch (menuChoice) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    SerieView.display();
                    break;
                case 2:
                    SerieView.add();
                    break;
                case 3:
                    SerieView.remove();
                    break;
                case 4:
                    SerieView.change();
                    break;
                case 5:
                    SerieView.search();
                    break;
                case 6:
                    SerieView.displaySerieMenu();
                    break;
                default:
                    System.out.println("\nVälj ett giltigt val [0], [1], [2], [3], [4], [5] eller [6].\n");
                    break;
            }
        } while (notExit);
    }

    /**
     * Metoden körs när användaren väljer att avsluta programmet, man får här en fråga om man är säker på att man vill avlsuta.
     * @return boolean retunerar notExit = false om man väljer att stänga programmet vilket avslutar while loopen för programmet.
     */
    private static void doExit(){
        String exitChoice;
        System.out.println("Är du säker på att du vill avsluta? Ja/Nej: ");
        exitChoice = input.nextLine();
        if (exitChoice.equals("Ja")) {
            System.out.println("Välkommen åter!");
            notExit = false;
        }else{
            System.out.println("Kul att du stanna!");
            notExit = true;
        }
    }

    private static void displayMainMenu(){
        System.out.println("Välkommen till ditt film- & seriebibliotek!\n" +
                "Vill du:\n" +
                "[0] Avsluta.\n" +
                "[1] Hantera filmer.\n" +
                "[2] Hantera serier.\n");
    }

    public static String genreChoice(int genreMenuChoice){
        String genre = "";
        if(genreMenuChoice == 1){
            genre = "Action";
        }else if(genreMenuChoice == 2){
            genre = "Komedi";
        }else if(genreMenuChoice == 3){
            genre = "Drama";
        }else if(genreMenuChoice == 4){
            genre = "Skräck";
        }else if(genreMenuChoice == 5){
            genre = "Dokumentär";
        }else{
            System.out.println("Välj en kattegori mellan 1-5.");
        }
        return genre;
    }
}

