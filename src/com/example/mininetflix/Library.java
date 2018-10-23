package com.example.mininetflix;

public interface Library {
    void showContent();
    void addContent(MovieModel newMovieModel);
    void removeContent(String name);
    void changeContent(String name, MovieModel objectToUpdate);
    void searchContent(String name);
}
