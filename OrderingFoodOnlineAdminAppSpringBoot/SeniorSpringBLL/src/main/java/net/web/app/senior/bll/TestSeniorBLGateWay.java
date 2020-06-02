package net.web.app.senior.bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import net.web.app.senior.beans.BranchBean;
import net.web.app.senior.constant.SeniorConstant;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSeniorBLGateWay implements SeniorConstant {

    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("bll-spring-context.xml");
        SeniorBLGateWay service = appCon.getBean("seniorBLGateWay", SeniorBLGateWay.class);
        DateFormat dateFormat = new SimpleDateFormat("hh.mm:ss a");
        BranchBean branch = new BranchBean();
        branch.setNameAr("Branch C ar");
        branch.setNameEn("Branch C en");
        branch.setOpenAt(dateFormat.format(new Date()));
        branch.setCloseAt(dateFormat.format(new Date()));
        branch.setPhone("01009894481");
        branch.setProvider(service.findProviderById(1));
        branch.setArea(service.findAreaById(8));
        service.addBranch(branch);
        service.findBranchList().forEach(b
                -> {
            System.out.println(b.getId());
            System.out.println(b.getArea().getNameAr());
        }
        );

    }
}
