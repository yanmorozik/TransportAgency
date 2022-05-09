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
//обновление заказа!!!
//More than one row with the given identifier was found: 1,
//разобраться с удаление контент->транспорт->...
//!!не удоляется аддрес при удаление контента
//не работает запрос, опять ошибка 2 rows....