package com.example.mininetflix;

import java.util.ArrayList;

/**
 * <h1>SerieController</h1>
 * Klassen SerieController får information ifrån SerieView om vilken metod som ska utföras och retunerar sedan diverse information.
 *
 *  @author Pär Nilsson
 *  @version 1.0
 *  @since 2018-10-9
 */
public class SerieController{
    private ArrayList<SerieModel> allSeries;
    private ArrayList<SerieModel> favSeries;

    public SerieController() {
        this.allSeries = new ArrayList<>();
        this.favSeries = new ArrayList<>();
    }

    public void showContent(){
        if (allSeries.isEmpty()){
            System.out.println("Seriebilbioteket är tomt, gå tillbaka & lägg till dina serier.");
            return;
        }
        System.out.println("Följande serier finns i seriebiblioteket:");
        for(int i = 0; i < allSeries.size(); i++){
            System.out.println("Serie " + (i+1) + ":\n\t" +
                    this.allSeries.get(i).getName() +
                    "\n\tAntal säsonger: " +
                    this.allSeries.get(i).getSeasons() +
                    "\n\tAntal avsnitt: " +
                    this.allSeries.get(i).getEpisodes() +
                    "\n\tÄr sista säsongen släppt? " +
                    this.allSeries.get(i).getIsLastSeasonReleased() +
                    "\n\tGenre: " +
                    this.allSeries.get(i).getGenre() +
                    "\n\tRating: " +
                    this.allSeries.get(i).getRating());
        }
    }

    public void showFavorite(){
        if (favSeries.isEmpty()){
            System.out.println("Det är tomt på favoriter, gå tillbaka & lägg till dina favoritserier.");
            return;
        }
        System.out.println("Dina favoritserier:");
        for(int i = 0; i < favSeries.size(); i++){
            System.out.println("Favorit " + (i+1) + ":\n\t" +
                    this.favSeries.get(i).getName() +
                    "\n\tAntal säsonger: " +
                    this.favSeries.get(i).getSeasons() +
                    "\n\tAntal avsnitt: " +
                    this.favSeries.get(i).getEpisodes() +
                    "\n\tÄr sista säsongen släppt? " +
                    this.favSeries.get(i).getIsLastSeasonReleased() +
                    "\n\tGenre: " +
                    this.favSeries.get(i).getGenre() +
                    "\n\tRating: " +
                    this.favSeries.get(i).getRating());
        }
    }

    /**
     * Metoden tar emot objektet newSerieModel och lägger till det i ArrayListen allseries.
     * @param newSerieModel en ny Serie som ett objekt med namn, genre, avsnitt osv.
     */
    public void addContent(SerieModel newSerieModel) {
        allSeries.add(newSerieModel);
    }

    public void favoriteSerie(int favIndex) {
        if (allSeries.isEmpty()){
            System.out.println("Seriebilbioteket är tomt, gå tillbaka & lägg till dina serier innan du kan välja favoriter.");
            return;
        }
        SerieModel favSerie = allSeries.get(favIndex);
        favSeries.add(favSerie);
        System.out.println(allSeries.get(favIndex).getName() + " har lagts till i dina favoriter.");
    }

    public void removeContent(String name){
        MovieModel objectToRemove = findObject(name);
        if(objectToRemove == null){
            System.out.println("Serien finns inte i seriebiblioteket.");
        }else {
            this.allSeries.remove(objectToRemove);
            System.out.println(name + " har tagits bort från seriebilbioteket.");
        }
    }

    public void changeContent(String name, SerieModel serieToUpdate){
        MovieModel objectToChange = findObject(name);
        if(objectToChange == null) {
            System.out.println("Serien finns inte i seriebiblioteket.");
        }else{
            this.allSeries.set(findIndex(name), serieToUpdate);
            System.out.println(name + " har ändrats.");
        }
    }

    public void searchContent(String name){
        MovieModel objectToDisplay = findObject(name);
        if(objectToDisplay == null) {
            System.out.println("Serien finns inte i seriebiblioteket.");
        }
        System.out.println("Serier:\n\t" +
                this.allSeries.get(findIndex(name)).getName() +
                "\n\tAntal säsonger: " +
                this.allSeries.get(findIndex(name)).getSeasons() +
                "\n\tAntal avsnitt: " +
                this.allSeries.get(findIndex(name)).getEpisodes() +
                "\n\tÄr sista säsongen släppt? " +
                this.allSeries.get(findIndex(name)).getIsLastSeasonReleased() +
                "\n\tGenre: " +
                this.allSeries.get(findIndex(name)).getGenre() +
                "\n\tRating: " +
                this.allSeries.get(findIndex(name)).getRating());
    }

    /**
     * Metoden tar emot ett name och kollar om det finns en serie med detta namn, finns det retuneras true
     * finns inte serien i biblioteket retuneras false och vi bryter metoden i SerieView för att uppdatera serien.
     *
     * @param name namnet på Serien som ska kollas om den finns i biblioteket
     * @return boolean
     */
    public boolean controllExistence(String name){
        MovieModel objectToChange = findObject(name);
        if(objectToChange == null) {
            System.out.println("Serien finns inte i seriebiblioteket.");
            return false;
        }return true;
    }

    private int findIndex(String objectName){
        //Loopar igenom Arraylisten för att örsäkra oss om att objektet finns
        for(int i=0; i<this.allSeries.size(); i++){
            MovieModel movieModel = this.allSeries.get(i);
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
            return this.allSeries.get(index);
        }
        return null;
    }
}
