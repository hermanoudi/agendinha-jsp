<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="br.agenda.model.dto.Contato"%>
<%@page import="java.util.ArrayList" %>
<script language="javascript">
function setCommand(){
	document.formListaContatos.submit();
}
</script>


<script language="javascript">
function excluir(codigo){
    var n = codigo;
	location.href='<%=request.getContextPath()%>/remove?codigo='+n;
	//var new_window = window.open('\excluir.jsp?id='+codigo,"new_window", 'height=200, width=200, scrollbars, resizable');
	
}
</script>
<table width="691" border="0" cellspacing="0" cellpadding="0" style="margin:6px 0px 0px 0px">
	<tr>
		<td style="background:#ffffff url('panel_white_topleft.gif') no-repeat left top; " height=10 width="8">&nbsp;</td>
		<td style="background:#ffffff url('panel_white_topright.gif') no-repeat right top; " height=10 width="673">&nbsp;</td>
		<td width=4 style="padding:0px 0px 0px 6px" rowspan=4 valign=top>&nbsp;</td>
	</tr>
	<tr valign=top bgcolor="#ffffff">
		<td width=8 height=400>&nbsp;
	
			</td>
		<td style="padding:0px 10px 20px 0px;" width="663">
		
		<p align="center">        
		<form name="formListaContatos" method="post" action="carregar">
		  
		  <%ArrayList<Contato> list = new ArrayList<Contato>();
		    list = (ArrayList<Contato>)request.getAttribute("list");%> 
		  
		  <table width="567" border="1">
            <tr bgcolor="#FF0000">
              <th width="64" scope="col">Selecione</th>
              <th width="115" scope="col">Nome</th>
              <th width="113" scope="col">Celular</th>
              <th width="103" scope="col">Email</th>
              <th width="96" scope="col">MSN</th>
			  <th width="71" scope="col">Excluir</th>
            </tr>
			<c:forEach var="contato" items="${list}">
            <tr>
              <td><div align="center">
                <label>
                <input name="selected_contato" type="radio" value="${contato.id}" onClick="setCommand();">
                </label>
              </div></td>
              <td><div align="center">${contato.nome}</div></td>
              <td><div align="center">${contato.celular}</div></td>
              <td><div align="center">${contato.email}</div></td>
              <td><div align="center">${contato.msn}</div></td>
			  <td><div align="center"><a href='#'onClick="excluir(${contato.id});">Excluir</a></div></td>
            </tr>
			</c:forEach>
          </table>
          </form>		<p align="center"></td>
	</tr>
	<tr valign=top>
		<td style="background:#ffffff url('panel_white_bottomleft.gif') no-repeat left bottom; " height=10 width="8">&nbsp;</td>
		<td style="background:#ffffff url('panel_white_bottomright.gif') no-repeat right bottom; " height=10 width="673">&nbsp;</td>
	</tr>
	<tr>
		<td colspan=2 style="background:#000000" width="681"><div class="nispacer" style="width:550px;background:#000000;margin:0px 0px 0px 0px">&nbsp;</div></td>
	</tr>
	</table>