package net.web.app.senior.dal;

import java.util.List;
import net.web.app.senior.dal.entity.CityEntity;
import net.web.app.senior.dal.repo.CityRepo;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("dal-spring-context.xml");
        CityManager manager = appCon.getBean("cityManager", CityManager.class);
        List<CityEntity> cityList = manager.findCityList(appCon);
        for (CityEntity city : cityList) {
            System.out.println(city.getNameEn());
        }
    }

}
