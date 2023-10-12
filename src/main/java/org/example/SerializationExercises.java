package org.example;
import org.example.model.Theater;
import org.example.model.Session;
import org.example.model.Movie;
import java.io.*;
import com.google.gson.Gson;



public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */

    public static class Exercise1 {
        public static void main(String[] args) {
            Gson gson = new Gson();
            Movie firstMovie = new Movie("Mamma mia");
            Movie secondMovie = new Movie("El padrino");
            Theater firstTheater = new Theater("Las Arenas", 20);
            Theater secondTheater = new Theater("Los Alisios", 30);
            Session firstSession = new Session(firstMovie, firstTheater);
            Session seconsSession = new Session(secondMovie, secondTheater);

            try {

                FileWriter movie1Writer = new FileWriter("firstMovie.json");
                gson.toJson(firstMovie, movie1Writer);
                movie1Writer.close();

                FileWriter movie2Writer = new FileWriter("secondMovie.json");
                gson.toJson(secondMovie, movie2Writer);
                movie2Writer.close();

                FileWriter theater1Writer = new FileWriter("firstTheater.json");
                gson.toJson(firstTheater, theater1Writer);
                theater1Writer.close();

                FileWriter theater2Writer = new FileWriter("secondTheater.json");
                gson.toJson(secondTheater, theater2Writer);
                theater2Writer.close();

                FileWriter session1Writer = new FileWriter("firstSession.json");
                gson.toJson(firstSession, session1Writer);
                session1Writer.close();

                FileWriter session2Writer = new FileWriter("secondSession.json");
                gson.toJson(seconsSession, session2Writer);
                session2Writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {
        public static void main(String[] args) {
            Gson gson = new Gson();

            try {

                Movie firstMovieDeserialized = gson.fromJson(
                        new FileReader("firstMovie.json"),
                        Movie.class
                );

                Movie secondMovieDeserialized = gson.fromJson(
                        new FileReader("secondMovie.json"),
                        Movie.class
                );


                Theater firstTheaterDeserialized = gson.fromJson(
                        new FileReader("firstTheater.json"),
                        Theater.class
                );
                Theater secondTheaterDeserialized = gson.fromJson(
                        new FileReader("secondTheater.json"),
                        Theater.class
                );


                Session firstSessionDeserialized = gson.fromJson(
                        new FileReader("firstSession.json"),
                        Session.class
                );
                Session secondSessionDeserialized = gson.fromJson(
                        new FileReader("secondSession.json"),
                        Session.class
                );


                System.out.println("Deserialized Movie: " + firstMovieDeserialized);
                System.out.println("Deserialized Theater: " + firstTheaterDeserialized);
                System.out.println("Deserialized Session: " + firstSessionDeserialized);
                System.out.println("Deserialized Movie: " + secondMovieDeserialized);
                System.out.println("Deserialized Theater: " + secondTheaterDeserialized);
                System.out.println("Deserialized Session: " + secondSessionDeserialized);

            } catch (IOException e) {
                e.printStackTrace();
            }



            Movie firstMovie = new Movie("Mamma mia");
            Movie secondMovie = new Movie("El padrino");
            Theater firstTheater = new Theater("Las Arenas", 20);
            Theater secondTheater = new Theater("Los Alisios", 30);
            Session firstSession = new Session(firstMovie, firstTheater);
            Session seconsSession = new Session(secondMovie, secondTheater);



            try {

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("firstMovie.bin"))) {
                    oos.writeObject(firstMovie);
                }


                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("secondMovie.bin"))) {
                    oos.writeObject(secondMovie);
                }


                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("firstTheater.bin"))) {
                    oos.writeObject(firstTheater);
                }

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("secondTheater.bin"))) {
                    oos.writeObject(secondTheater);
                }

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("firstSession.bin"))) {
                    oos.writeObject(firstSession);
                }

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("secondSession.bin"))) {
                    oos.writeObject(seconsSession);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {
        public static void main(String[] args) {
            try {

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("firstMovie.bin"))) {
                    Movie movie1Deserialized = (Movie) ois.readObject();
                    System.out.println("Deserialized Movie: " + movie1Deserialized);
                }


                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("secondMovie.bin"))) {
                    Movie movie2Deserialized = (Movie) ois.readObject();
                    System.out.println("Deserialized Movie: " + movie2Deserialized);
                }


                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("firstTheater.bin"))) {
                    Theater theater1Deserialized = (Theater) ois.readObject();
                    System.out.println("Deserialized Theater: " + theater1Deserialized);
                }

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("secondTheater.bin"))) {
                    Theater theater2Deserialized = (Theater) ois.readObject();
                    System.out.println("Deserialized Theater: " + theater2Deserialized);
                }

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("firstSession.bin"))) {
                    Session session1Deserialized = (Session) ois.readObject();
                    System.out.println("Deserialized Session: " + session1Deserialized);
                }
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("secondSession.bin"))) {
                    Session session2Deserialized = (Session) ois.readObject();
                    System.out.println("Deserialized Session: " + session2Deserialized);
                }



            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }

}

