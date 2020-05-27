/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Ahmed Baz
 */
public class UpdateArea extends HttpServlet {

    SeniorBLGateWay gateWay = new SeniorBLGateWay();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String responsePage = null;
            Integer area_id = 0;
            Integer city_id = 0;
            String area_id_String = request.getParameter("id");
            String city_id_string = null;
            String nameAr = null;
            String nameEn = null;
            city_id_string = request.getParameter("city_id");
            nameAr = request.getParameter("nameAr");
            nameEn = request.getParameter("nameEn");

            if (null != area_id_String) {
                area_id = Integer.parseInt(area_id_String);
                city_id = Integer.parseInt(city_id_string);
            }
            AreaBean areaBean = gateWay.findAreaById(area_id);
            CityBean cityBean = areaBean.getCityBean();
            Integer id = cityBean.getId();
            AreaBean area = new AreaBean();
            area.setId(area_id);
            area.setNameAr(nameAr);
            area.setNameEn(nameEn);
            if (city_id.equals(id)) {
                area.setCityBean(cityBean);
                gateWay.updateArea(area);
                responsePage = "ViewCity.jsp?id=" + id;
            } else {
                CityBean city = gateWay.findCityById(city_id);
                area.setCityBean(city);
                gateWay.updateArea(area);
                responsePage = "ViewCity.jsp?id=" + city_id;
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
