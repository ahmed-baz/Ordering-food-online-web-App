<%-- 
    Document   : UpdateCity
    Created on : Mar 3, 2020, 7:54:59 PM
    Author     : Ahmed Baz
--%>

<%@page import="net.web.app.senior.beans.CityBean"%>
<%@page import="net.web.app.senior.bll.SeniorBLGateWay"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%!
        SeniorBLGateWay gateWay = new SeniorBLGateWay();
        CityBean city = new CityBean();
        Integer id;
        String idString;
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update City</title>
    </head>
    <body>
        <%
            idString = request.getParameter("id");
            if (null != idString) {
                id = Integer.parseInt(idString);
                city = gateWay.findCityById(id);
            }
        %>
        <form action="updateCity?id=<%=id%>" method="POST">
            <table width="30%">
                <tr>
                    <td>
                        <label>City Name In Arabic</label>
                    </td>
                    <td>
                        <input type="text"  placeholder="<%=city.getNameAr()%>" name="nameAr" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>City Name In English</label>
                    </td>
                    <td>
                        <input type="text"  placeholder="<%=city.getNameEn()%>" name="nameEn" required="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Update" />
                        <a href="City.jsp">Back</a>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

