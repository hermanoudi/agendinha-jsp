<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.agenda.model.dto.Contato"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Contato</title>
</head>
<link rel="stylesheet" href="howto.css" type="text/css">
<link rel="stylesheet" type="text/css" href="/howto.css">
<script language="JavaScript">
<!--	
function Validacao()
{
	if (document.getElementById("nome").value == '')
	    {
		  alert("Preencha o campo nome!");
		  document.getElementById("nome").focus();
		  return false;
	    }	

	   if (document.getElementById("residencial").value == '')
       {
		alert("Preencha o campo telefone residencial!");
		document.getElementById("residencial").focus();
		return false;
	   }
	   
	   if (document.getElementById("celular").value == '')
	   {
		alert("Preencha o campo celular!");
		document.getElementById("celular").focus();
		return false;
	   }
	  
}
	
//-->
</script>
<body> 
<form name="formAlteraContato" method="post" action="alterar" onSubmit=" return Validacao();"> 
<%Contato contato = (Contato)request.getAttribute("contato"); %>
  <table width="676" border="0" bgcolor="#FFFFFF">
    <tr>
      <th colspan="2" bgcolor="#FF0000">Alterar Contato </th>
    </tr>
    <tr>
      <td width="153">Nome</td>
      <td><label>
        <input name="id" type="hidden" value="${contato.id}">
        <input name="nome" type="text" id="nome" value="${contato.nome}" size="80" maxlength="80">
      </label></td>
    </tr>
    <tr>
      <td>Endere&ccedil;o</td>
      <td><label>
        <input name="endereco" type="text" id="endereco" value="${contato.endereco}" size="80" maxlength="80">
      </label></td>
    </tr>
    <tr>
      <td>Bairro</td>
      <td>
      <jsp:useBean id="dao" class="br.agenda.dao.BairroDAO"></jsp:useBean>
	    <select name="bairro" id="bairro">
   		    <option value="${contato.idBairro.id}" SELECTED>${contato.idBairro.nome}</option> 
       <c:forEach var="bairro" items="${dao.lista}">
            <option value="${bairro.id}">${bairro.nome}</option>
       </c:forEach>
	    </select>      </td>
    </tr>
    <tr>
      <td>Cidade</td>
      <td>
      <jsp:useBean id="daoCidade" class="br.agenda.dao.CidadeDAO"></jsp:useBean>
        <select name="cidade" id="cidade">
		   <option value="${contato.idCidade.id}">${contato.idCidade.nome}</option> 
		   <c:forEach var="cidade" items="${daoCidade.lista}">
          <option value="${cidade.id}">${cidade.nome}</option>
       </c:forEach>
        </select>      </td>
    </tr>
    <tr>
      <td>Telefone Residencial </td>
      <td><label>
        <input name="residencial" type="text" id="residencial" value="${contato.residencial}" size="10" maxlength="10">
      </label></td>
    </tr>
    <tr>
      <td height="27">Telefone Comercial </td>
      <td><label>
        <input name="comercial" type="text" id="comercial" value="${contato.comercial}" size="10" maxlength="10">
      &nbsp;Celular&nbsp;&nbsp;
      <input name="celular" type="text" id="celular" value="${contato.celular}" size="10" maxlength="10">
      </label></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><label>
        <input name="email" type="text" id="email" value="${contato.email}" size="80" maxlength="80">
      </label></td>
    </tr>
    <tr>
      <td>Msn</td>
      <td><label>
        <input name="msn" type="text" id="msn" value="${contato.msn}" size="80" maxlength="80">
      </label></td>
    </tr>
    <tr>
      <td>Pais</td>
      <jsp:useBean id="daoPais" class="br.agenda.dao.PaisDAO"></jsp:useBean>
	  <td><select name="pais" id="pais">
	      <option value="${contato.idPais.id}" selected>${contato.idPais.nome}</option> 
		<c:forEach var="pais" items="${daoPais.lista}">
          <option value="${pais.id}">${pais.nome}</option>
        </c:forEach>
      </select></td>
    </tr>
	    <tr>
      <td colspan="2">
        <label>
        <div align="right">
  <input name="gravar" type="submit" id="gravar" value="Gravar">
        </td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>

  </table>
</form>
</body>
</html>