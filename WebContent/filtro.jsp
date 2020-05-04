<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contatos</title>
</head>
<body bgcolor="#000000"> 
<link rel="stylesheet" href="howto.css" type="text/css">
<link rel="stylesheet" type="text/css" href="/howto.css">
<form name="formPesquisaContato" method="post" action="pesquisar"> 
  <table width="676" border="0" bgcolor="#FFFFFF">
    <tr>
      <th colspan="2" bgcolor="#FF0000">Pesquisa Contato </th>
    </tr>
    <tr>
      <td width="153">Nome</td>
      <td><label>
        <input name="nome" type="text" id="nome" size="80" maxlength="80">
      </label></td>
    </tr>
	    <tr>
      <td colspan="2">
        <label>
        <div align="right">
  <input name="pesquisar" type="submit" id="pesquisar" value="pesquisar">        </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
</body>
</html>