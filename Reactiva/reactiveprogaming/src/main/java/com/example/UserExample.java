package com.example;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class UserExample {

    static class User {
        String nombre;
        int edad;

        User(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public int getEdad() {
            return edad;
        }
    }

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
            new User("Daniela", 20),
            new User("Oscar", 21),
            new User("Koko", 17),
            new User("Steve", 12)
        );

        Observable.fromIterable(users)
            .filter(user -> user.getEdad() >= 18).doOnNext(user -> System.out.println("Usuario filtrado: " + user.getNombre()))

            .map(user -> new User(user.getNombre().toUpperCase(), user.getEdad())).doOnNext(user -> System.out.println("Nombre transformado: " + user.getNombre()))

            .zipWith(Observable.range(1, Integer.MAX_VALUE), (userData, id) -> "ID: " + id + ", Data: " + userData);

    }

}


