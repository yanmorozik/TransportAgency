package eu.morozik.transportagency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
//удаление водителей с ссылкой на транспорт!!!
//изменил табличку в migratin(ресурсы)