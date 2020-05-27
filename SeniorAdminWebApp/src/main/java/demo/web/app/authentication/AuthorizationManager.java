package demo.web.app.authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthorizationManager {

    public Boolean isAuthorized(HttpServletRequest request) {
        Object attribute = request.getSession().getAttribute("Authorized");
        if ("Authorized".equals(attribute)) {
            return true;
        }
        /*
        Cookie[] cookies = request.getCookies();
        for (Cookie cooky : cookies) {
            if ("Authorized".equals(cooky.getName())) {
                return true;
            }
        }*/
        return false;
    }
}
