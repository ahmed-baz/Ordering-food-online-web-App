package demo.web.app.servlets.area;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.web.app.senior.beans.AreaBean;
import net.web.app.senior.beans.CityBean;
import net.web.app.senior.bll.SeniorBLGateWay;

public class addNewArea extends HttpServlet {

    SeniorBLGateWay gateWay = new SeniorBLGateWay();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String responsePgae = null;
            Integer master_city_id;
            Integer city_id;
            String master_city_id_String = request.getParameter("master_city_id");
            String city_id_String = request.getParameter("city_id");

            master_city_id = Integer.parseInt(master_city_id_String);
            city_id = Integer.parseInt(city_id_String);

            String nameAr = request.getParameter("areaNameAr");
            String nameEn = request.getParameter("areaNameEn");

            AreaBean area = new AreaBean();
            area.setNameAr(nameAr);
            area.setNameEn(nameEn);

            if (master_city_id.equals(city_id)) {
                CityBean city = gateWay.findCityById(master_city_id);
                area.setCityBean(city);
                responsePgae = "ViewCity.jsp?id=" + city_id;
            } else {

                CityBean city = gateWay.findCityById(city_id);
                area.setCityBean(city);
                responsePgae = "ViewCity.jsp?id=" + city_id;
            }

            gateWay.addArea(area);
            response.sendRedirect(responsePgae);
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
