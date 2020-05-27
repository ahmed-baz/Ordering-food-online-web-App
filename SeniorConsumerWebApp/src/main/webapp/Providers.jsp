<%-- 
    Document   : Providers
    Created on : Mar 22, 2020, 10:45:10 PM
    Author     : Ahmed Baz
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.web.app.senior.bll.SeniorBLGateWay"%>
<%@page import="net.web.app.senior.beans.ProviderBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Find Restaurant</title>
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
        <form action="Branch" method="POST">
            <div class="container">
                <div class="table-wrapper">			
                    <div class="table-title">
                        <div class="row">

                            <div class="col-sm-4">
                                <h2 class="text-center">Choose  <b>The Restaurant</b></h2>
                            </div>
                            <div class="col-sm-4">
                                <div class="search-box">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
                                        <input type="text" name="area"  class="form-control" placeholder="Search By Your Area&hellip;">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%!
                        private final SeniorBLGateWay gateWay = new SeniorBLGateWay();
                        List<ProviderBean> providerList = null;
                    %>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th class="table-text-center">Id</th>
                                <th class="table-text-center"></th>
                                <th class="table-text-center">Provider</th>
                                <th class="table-text-center">HotLine</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                // Provider List has no impl.. in BLL project
                                //providerList = gateWay.findProviderList();
                                providerList = gateWay.searchProviderByName("");
                                for (ProviderBean iProvider : providerList) {
                            %>
                            <tr>
                                <th class="table-text-center"><%=iProvider.getId()%></th>
                                <th class="table-text-center"><img src="images/logo_2.jpg" alt="Provider Logo" height="50" width="50"></th>
                                <th class="table-text-center"><a href="Branch?provider_id=<%=iProvider.getId()%>"><%=iProvider.getNameEn()%></a></th>
                                <th class="table-text-center"><%=iProvider.getHotline()%></th>
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
        </form>
    </body>
</html>                                		                            