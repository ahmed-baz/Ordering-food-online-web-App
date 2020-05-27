package net.web.app.senior.bll;

import java.util.Date;
import net.web.app.senior.beans.ProviderUsersBean;
import net.web.app.senior.constant.SeniorConstant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSeniorBLGateWay implements SeniorConstant {
    
    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("bll-spring-context.xml");
        SeniorBLGateWay service = appCon.getBean("seniorBLGateWay", SeniorBLGateWay.class);

        
        // Test Provider User
        
        
        
    }
}
