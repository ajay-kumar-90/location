<%--
  Created by IntelliJ IDEA.
  User: Sangeetha Ajay
  Date: 16-06-2022
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Location</title>
</head>
<body>
<form action="updateLocation" method="post">
<pre>
    Id: <input type="text" name="id" value="${location.id}" readonly/>
    Code: <input type="text" name="code" value="${location.code}"/>
    Name: <input type="text" name="name" value="${location.name}"/>
    Type: Urban <input type="radio" name="type" value="URBAN" ${location.type == 'URBAN'?'checked':''}/>
          RURAL <input type="radio" name="type" value="RURAL" ${location.type == 'RURAL'?'checked':''}/>
            <input type="submit" value="update"/>
</pre>
</form>
</body>
</html>
