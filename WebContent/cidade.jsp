<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Cidade</title>
</head>
<body>
<form name="formCidade" method="post" action="cidade">
  <table width="237" border="0">
    <tr>
      <td width="44">Cidade</td>
      <td width="177"><label>
        <input name="nome" type="text" size="25" maxlength="25">
      </label></td>
    </tr>
    <tr>
      <td>Estado</td>
      <td><label>
        <input name="uf" type="text" size="2" maxlength="2">
      </label></td>
    </tr>
    <tr>
      <td>DDD</td>
      <td><label>
        <input name="ddd" type="text" size="3" maxlength="3">
        <input type="submit" name="Submit" value="Gravar">
      </label></td>
    </tr>
  </table>
</form>
</body>
</html>