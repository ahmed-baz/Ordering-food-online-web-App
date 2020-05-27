<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Discover Restaurants</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="author" content="colorlib.com">
        <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet" />
        <link href="css/discover_restaurants.css" rel="stylesheet" />
        <script src="js/provider_script.js"></script>

    </head>
    <body>
        <div class="s01">
            <form action="Branches.jsp" method="POST">
                <fieldset>
                    <legend style="font-size: 40px">Find the restaurants nearest to you</legend>
                </fieldset>
                <div class="inner-form">
                    <div class="input-field first-wrap">
                        <input id="search" type="text" placeholder="Search by your area or restaurant name !" name="name"/>
                    </div>
                    <div class="input-field third-wrap">
                        <input class="btn-search" type="submit" value="Search">
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
