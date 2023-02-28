package edu.wctc;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        try{
            LocalDate joshuaTree = LocalDate.of(1987,3,9);
            LocalDate rattleAndHum = LocalDate.of(1988,10,10);
            LocalDate today = LocalDate.now();

            //find out the time since joshua tree
            Period yearsApart = Period.between(joshuaTree, today);
            System.out.printf("Joshua Tree was released %d years, %d months, and %d days ago.\n",
                    yearsApart.getYears(),
                    yearsApart.getMonths(),
                    yearsApart.getDays());

            System.out.println();

            //find out time between albums
            Period betweenAlbums = Period.between(joshuaTree, rattleAndHum);
            System.out.printf("The albums are %d years, %d months, and %d days apart.\n",
                    betweenAlbums.getYears(),
                    betweenAlbums.getMonths(),
                    betweenAlbums.getDays());

            System.out.println();
            //calculate when third album should have been

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

            LocalDate nextChild = rattleAndHum.plus(betweenAlbums);
            System.out.printf("The next album should have been released on %s.\n",
                    nextChild.format(formatter));

        }catch (DateTimeException e){
            System.out.println(e.getMessage());
        }
    }
}
