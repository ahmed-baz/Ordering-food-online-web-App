package net.web.app.senior.bll;

import java.util.List;
import java.util.Set;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.constant.SeniorConstant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSeniorBLGateWay implements SeniorConstant {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("bll-spring-context.xml");
        SeniorBLGateWay service = appCon.getBean("seniorBLGateWay", SeniorBLGateWay.class);
        List<CityBean> list = service.findCityList();
        for (CityBean cityBean : list) {
            System.out.println(cityBean.getNameEn());
            Set<AreaBean> areasBean = cityBean.getAreasBean();
            for (AreaBean areaBean : areasBean) {
                System.out.println(areaBean.getNameAr());
            }
            System.out.println("||||||||||||||||||||||");
        }
        
    }
    
}
