package br.agenda.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.agenda.dao.ContatoDAO;
import br.agenda.model.dto.Bairro;
import br.agenda.model.dto.Cidade;
import br.agenda.model.dto.Contato;
import br.agenda.model.dto.Pais;

public class CadastrarContatoAction extends HttpServlet {

	private static final long serialVersionUID = 3247826716106213413L;

	protected void doPost(HttpServletRequest rqt, HttpServletResponse rsp)
			throws ServletException, IOException {
		String nome     	= rqt.getParameter("nome");
		String endereco 	= rqt.getParameter("endereco");
		Long   bairro   	= Long.parseLong(rqt.getParameter("bairro"));
		Long   cidade   	= Long.parseLong(rqt.getParameter("cidade"));
		String residencial 	= rqt.getParameter("residencial");
		String comercial   	= rqt.getParameter("comercial");
		String celular	   	= rqt.getParameter("celular");
		String email	   	= rqt.getParameter("email");
		String msn		   	= rqt.getParameter("msn");
		Long   pais		   	= Long.parseLong(rqt.getParameter("pais"));
		
		
		Bairro bai = new Bairro();
		bai.setId(bairro);
		
		Cidade cid = new Cidade();
		cid.setId(cidade);
		
		Pais pai = new Pais();
		pai.setId(pais);
		
		Contato o = new Contato();
		o.setNome(nome);
		o.setEndereco(endereco);
		o.setIdBairro(bai);
		o.setIdCidade(cid);
		o.setResidencial(residencial);
		o.setComercial(comercial);
		o.setCelular(celular);
		o.setEmail(email);
		o.setMsn(msn);
		o.setIdPais(pai);
		
		try {
			ContatoDAO.adiciona(o);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}

		RequestDispatcher view = rqt.getRequestDispatcher("/index.jsp");
		view.forward(rqt, rsp);

		PrintWriter out = rsp.getWriter();
		out.close();
	}
}
