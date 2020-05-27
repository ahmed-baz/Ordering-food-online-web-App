<%-- 
    Document   : Providers
    Created on : Mar 22, 2020, 10:45:10 PM
    Author     : Ahmed Baz
--%>

<%@page import="java.util.Set"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.web.app.senior.bll.SeniorBLGateWay"%>
<%@page import="net.web.app.senior.beans.BranchBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Branches</title>
        <link rel="stylesheet" href="css/provider_style_II.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/provider_style_I.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript">
        </script>
        <script src="js/provider_script.js"></script>

    </head>
    <body>
        <div class="container">
            <div class="table-wrapper">			
                <div class="table-title">
                    <div class="row">

                        <div class="col-sm-4">
                            <h2 class="text-center">Choose  <b>The Restaurant</b></h2>
                        </div>
                    </div>
                </div>
                <%!
                    private final SeniorBLGateWay gateWay = new SeniorBLGateWay();
                    List<BranchBean> branchList = null;
                    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
                    String openAtString = null;
                    String closeAtString = null;

                %>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="table-text-center">Id</th>
                            <th class="table-text-center"></th>
                            <th class="table-text-center">Branch</th>
                            <th class="table-text-center">Provider</th>
                            <th class="table-text-center">Open AT</th>
                            <th class="table-text-center">Close AT</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String name = request.getParameter("name");
                            branchList = gateWay.searchBranchByName(name);
                            for (BranchBean iBranch : branchList) {
                                openAtString = DATE_FORMAT.format(iBranch.getOpenAt());
                                closeAtString = DATE_FORMAT.format(iBranch.getCloseAt());
                        %>
                        <tr>
                            <th class="table-text-center"><%=iBranch.getId()%></th>
                            <th class="table-text-center"><img src="images/logo_1.jpg" alt="Provider Logo" height="50" width="50"></th>
                            <th class="table-text-center"><a href="Branches.jsp"><%=iBranch.getNameEn()%></a></th>
                            <th class="table-text-center"><%=iBranch.getProvider().getNameEn()%></th>
                            <th class="table-text-center"><%=openAtString%></th>
                            <th class="table-text-center"><%=closeAtString%></th>
                        </tr> 
                        <%}%>
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
                    <ul class="pagination">
                        <li class="page-item disabled"><a href="#">Previous</a></li>
                        <li class="page-item"><a href="#" class="page-link">1</a></li>
                        <li class="page-item"><a href="#" class="page-link">2</a></li>
                        <li class="page-item active"><a href="#" class="page-link">3</a></li>
                        <li class="page-item"><a href="#" class="page-link">4</a></li>
                        <li class="page-item"><a href="#" class="page-link">5</a></li>
                        <li class="page-item"><a href="#" class="page-link">Next</a></li>
                    </ul>
                </div>
            </div>
        </div>   
    </body>
</html>                                		                            