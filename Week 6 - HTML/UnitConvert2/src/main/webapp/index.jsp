<%-- 
    Document   : index
    Created on : Oct 21, 2016, 3:37:46 PM
    Author     : Apprentice
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
   <title>Unit Converter</title>
  </head>

  <body>
  <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/starter-template.css" rel="stylesheet">

    </head>
    <body style="background-color:powderblue;">
        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="http://getbootstrap.com/examples/starter-template/#">Unit Converter</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
        </div>

        <div class="container">

            <div class="starter-template">

                <center><img src="convert.jpg" height="200" width="242" alt="convert">      
      <form action="UnitConvertServlet" method="post">
        <label for="conversionType">Select a conversion type:</label><br>
        <select id="typeSelection" name="conversionType">
          <option value="Temperature">Temperature</option>
          <option value="Currency">Currency</option>
        </select>
        <hr>
        <div class="row">
          <div class="col-md-4">
            <label for="fromValue">From:</label><br>
            <input id="fromVal" type="number" step=".01" required="true" name="fromValue">
            <select id="fromUnit" name="fromUnit">
              <option value="Celsius">Celsius</option>
              <option value="Kelvin">Kelvin</option>
              <option value="Fahrenheit">Fahrenheit</option>
            </select>
          </div>
          <div class="col-md-4">
            <label for="toValue">To:</label><br>
            <input id="toVal" type="number" step=".01" name="toValue">
            <select id="toUnit" name="toUnit">
              <option value="Celsius">Celsius</option>
              <option value="Kelvin">Kelvin</option>
              <option value="Fahrenheit">Fahrenheit</option>
            </select>
          </div>
        </div><br>
        <input class="btn-primary" type="submit" value="CONVERT"/>
      </form>

    </div>
  </body>

  <script>
      var conversionType = "Temperature";
      var fromUnit = "Fahrenheit";
      var toUnit = "Celsius";
    <c:if test="${not empty(result)}" >
      conversionType = '<c:out value="${result.conversionType}"/>';
      fromUnit = '<c:out value="${result.fromUnit}"/>';
      toUnit = '<c:out value="${result.toUnit}"/>';
    </c:if>

      $(document).ready(function () {

          var temperatureOptions = "<option value='Celsius'>Celsius</option><option value='Kelvin'>Kelvin</option><option value='Fahrenheit'>Fahrenheit</option><option value='Rankine'>Rankine</option>";
          var currencyOptions = "<option value='USD'>USD</option><option value='CAD'>CAD</option><option value='Euro'>Euro</option><option value='Peso'>Peso</option>";

          $("#typeSelection").val(conversionType);
          updateUnits(conversionType);
          $("#fromUnit").val(fromUnit);
          $("#toUnit").val(toUnit);

          $("#typeSelection").change(function () {
              var choice = $(this).val();

              updateUnits(choice);
          });
          
           function updateUnits(choice) {
          switch (choice) {
              case "Temperature":
                  var options = temperatureOptions;
                  break;
              case "Currency":
                  var options = currencyOptions;
                  break;
              default:
          }
          
          $("#fromUnit").html(options);
          $("#toUnit").html(options);

      }
          
      });

     
  </script>
</html>