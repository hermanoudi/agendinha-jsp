<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bairros</title>
</head>
<body>
<form nome="formBairro" method="POST" action="bairro">
	  <table width="351" border="0">
        <tr>
          <td width="41">Bairro</td>
          <td width="241"><input name="nome" type="text" size="60" maxlength="60"></td>
          <td width="55"><input name="submit" type="submit" value="gravar"></td>
        </tr>
      </table>
</form>
</body>
</html>