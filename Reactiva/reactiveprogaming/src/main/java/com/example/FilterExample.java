package com.example;
import io.reactivex.rxjava3.core.Observable;

public class FilterExample {
    public static void main(String[] args) {
        Observable.just(1, 2, 3, 4, 5)
                .filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
    }
    
}


