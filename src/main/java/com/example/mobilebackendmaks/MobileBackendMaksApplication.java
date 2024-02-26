package com.example.mobilebackendmaks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MobileBackendMaksApplication {
    /**
        у одного юзера много задач
        в лог записываем лог времени юзер сам делает
        юзер может участвовать в нескольких проектах
        получить всех пользователей кроме текущего
        получить юзера по айди
        получмть всех юзеров по айдишникам

     */
    public static void main(String[] args) {
        SpringApplication.run(MobileBackendMaksApplication.class, args);
    }

}
