<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script language="javascript">
function fechaJanela(){
   window.close();
}
</script>
<body>
<form name="formdelete" action="remove" method="post">
deseja realmente excluir este contato?
<input name=codigo type="hidden" value="<%request.getParameter("id");%>" />

<input type="submit" value="Sim"/>
<input type="button" value="Não" onClick="fechaJanela();"/>
</form>

</body>
</html>