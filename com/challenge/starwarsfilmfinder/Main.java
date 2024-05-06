package com.challenge.starwarsfilmfinder;
import com.challenge.starwarsfilmfinder.models.FileGenerator;
import com.challenge.starwarsfilmfinder.models.Film;

import com.challenge.starwarsfilmfinder.control.GetApiConection;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String menu = """
                Bienvenido a StarWarsFilmFinder donde encontraras informacion acerca de cualquiera de las
                6 peliculas existentes del universo de Star Wars.
                                
                Para empezar escribe un numero del 1 al 6 y encuentra mas informacion de la pelicula:
                Nota: Se creara un archivo JSON con la information de la película
                """;

        System.out.println(menu);


        try{
            int number = input.nextInt();
            GetApiConection query = new GetApiConection();
            Film film = query.Query(number);
            System.out.println(film);
            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.saveJsonFile(film);
            System.out.println("Se han escrito la informacion de la pelicula en un archivo JSON");
        }catch (InputMismatchException e){
            System.out.println("Al parecer no escribiste un numero valido!"+e);
        } catch (IOException e) {
            System.out.println("Al parecer ha sido imposible crear el archivo JSON"+e);
        }catch (Exception e){
            System.out.println("Ocurrió un error interno :(, vuelve a intentarlo");
        }

    }
}
