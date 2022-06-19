<%--
  Created by IntelliJ IDEA.
  User: Sangeetha Ajay
  Date: 15-06-2022
  Time: 04:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create Location</title>
</head>
<body>
<form action="saveLocation" method="post">
<pre>
  Id: <input type="text" aria-label="Id:" name="id"/>
  Code: <input type="text" name="code"/>
  Name: <input type="text" name="name"/>
  Type: Urban <input type="radio" name="type" value="URBAN"/>
        Rural <input type="radio" name="type" value="RURAL"/>
  <input type="submit" value="save"/>
</pre>
</form>
${msg}
<a href="displayLocations">view All</a>
</body>
</html>
