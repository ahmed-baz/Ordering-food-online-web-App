package demo.web.app.servlets.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.web.app.senior.bll.SeniorBLGateWay;

public class UserLogin extends HttpServlet {
    
    SeniorBLGateWay gateWay = new SeniorBLGateWay();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String responsePage = "Login.jsp";
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Boolean checkLogin = gateWay.checkLogin(username, password);
            if (checkLogin) {
                HttpSession session = request.getSession();
                session.setAttribute("Authorized", "Authorized");
                session.setMaxInactiveInterval(30);
                
//                Cookie cookie = new Cookie("Authorized", "true");
//                cookie.setMaxAge(60);
//                response.addCookie(cookie);
                responsePage = "City.jsp";
            }
            
            response.sendRedirect(responsePage);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
