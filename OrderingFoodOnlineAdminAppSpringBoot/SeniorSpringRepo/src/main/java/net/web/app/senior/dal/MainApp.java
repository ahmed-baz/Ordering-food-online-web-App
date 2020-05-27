package net.web.app.senior.dal;

import java.util.List;
import net.web.app.senior.dal.entity.CityEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("dal-spring-context-test.xml");
        CityManager manager = appCon.getBean("cityManager", CityManager.class);
        CityEntity entity = new CityEntity("Giza ar", "Giza");
        // manager.addCity(appCon, entity);
        manager.findCityList(appCon).forEach(city
                -> System.out.println(city.getId() + ":" + city.getNameEn())
        );
    }

}
