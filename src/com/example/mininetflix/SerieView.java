package com.example.mininetflix;

import java.util.Scanner;

/**
 * <h1>SerieView</h1>
 * Klassen SerieView visar all information om hur användaren vill hantera serier i programmet.
 * SerieView sparar även ner variablerna som användaren skriver in med hjälp av scanner-klassen.
 *
 *  @author Pär Nilsson
 *  @version 1.0
 *  @since 2018-10-9
 */
public class SerieView {
    private static Scanner input = new Scanner(System.in);
    private static SerieController serie = new SerieController();

    public static void display(){
        serie.showContent();
    }

    public static void add(){
        System.out.print("Namn på serien: ");
        String name = input.nextLine();
        System.out.print("Är det en:\n" +
                "[1] Actionserie\n" +
                "[2] Komediserie\n" +
                "[3] Dramaserie\n" +
                "[4] Skräckserie\n" +
                "[5] Dokumentärserie\n");
        int genreMenuChoice = input.nextInt();
        input.nextLine();
        String genre = MiniNetflix.genreChoice(genreMenuChoice);
        System.out.print("Hur många säsonger finns det: ");
        int seasons = input.nextInt();
        input.nextLine();
        System.out.println("Är sista säsongen släppt:\n" +
                "[1] Ja\n" +
                "[2] Nej");
        int seasonMenuChoice = input.nextInt();
        input.nextLine();
        String isLastSeasonReleased = seasonChoice(seasonMenuChoice);
        System.out.print("Hur många avsnitt finns det totalt: ");
        int episodes = input.nextInt();
        input.nextLine();
        System.out.print("Betygsätt serien 1-5: ");
        int rating = input.nextInt();
        input.nextLine();
        SerieModel newSerieModel = SerieModel.add(name, genre, rating, isLastSeasonReleased, seasons, episodes);
        serie.addContent(newSerieModel);
    }

    /**
     * Metoden frågar användaren vilken serie den vill ta bort.
     * Sparar ner namnet på filmen i name och kallar på metoden serie.removeContent i SerieController klassen.
     * När metoden kallar på serie.removeContent skickar den även med String variablen name.
     */
    public static void remove(){
        System.out.println("Vilken serie vill du ta bort från biblioteket: ");
        String name = input.nextLine();
        serie.removeContent(name);
    }

    /**
     * Metoden frågar anvädaren vilken Serie de vill ta bort ifrån seriebiblioteket.
     * Väljer användaren en serie som inte finns i seriebiblioteket retuneras ett meddelande som berättar att serien inte finns och metoden bryts.
     * Väljer användaren en serie som finns får användaren möjligheten att ändra respektive val som kan sparas.
     */
    public static void change(){
        System.out.print("Vilken serie vill du ändra? ");
        String name = input.nextLine();
        boolean doContinue = serie.controllExistence(name);
        if(doContinue) {
            System.out.print("Ny kategori:\n" +
                    "[1] Actionserie\n" +
                    "[2] Komediserie\n" +
                    "[3] Dramaserie\n" +
                    "[4] Skräckserie\n" +
                    "[5] Dokumentärserie\n");
            int genreMenuChoice = input.nextInt();
            input.nextLine();
            String genre = MiniNetflix.genreChoice(genreMenuChoice);
            System.out.print("Antal säsonger: ");
            int seasons = input.nextInt();
            input.nextLine();
            System.out.println("Är sista säsongen släppt:\n" +
                    "[1] Ja\n" +
                    "[2] Nej");
            int seasonMenuChoice = input.nextInt();
            input.nextLine();
            String isLastSeasonReleased = seasonChoice(seasonMenuChoice);
            System.out.print("Antal avsnitt: ");
            int episodes = input.nextInt();
            input.nextLine();
            System.out.print("Betygsätt serien 1-5: ");
            int rating = input.nextInt();
            input.nextLine();
            SerieModel serieToUpdate = SerieModel.add(name, genre, rating, isLastSeasonReleased, seasons, episodes);
            serie.changeContent(name, serieToUpdate);
        }else{
            return;
        }
    }

    public static void search(){
        System.out.println("Vilken serie söker du efter: ");
        String name = input.nextLine();
        serie.searchContent(name);
    }

    public static void displaySerieMenu(){
        System.out.print("Välkommen till ditt seriebibliotek!\n" +
                "Vill du:\n" +
                "[0] Gå tillbaka.\n" +
                "[1] Se vilka serier som finns.\n" +
                "[2] Lägg till en serie.\n" +
                "[3] Ta bort en serie.\n" +
                "[4] Ändra en serie.\n" +
                "[5] Sök efter en serie.\n");
    }

    /**
     * Metoden tar emot information ifrån metoden change eller add i from utav:
     * @param seasonMenuChoice Val 1 tillika sista säsongen är släppts, Val 2 tillika sista säsongen inte släppt
     * @return String
     */
    private static String seasonChoice(int seasonMenuChoice){
        String season = "";
        if(seasonMenuChoice == 1){
            season = "Ja";
        }else if(seasonMenuChoice == 2){
            season = "Nej";
        }else{
            System.out.println("Välj Ja eller Nej.");
        }
        return season;
    }
}


