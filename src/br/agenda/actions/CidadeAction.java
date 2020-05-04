package br.agenda.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.agenda.dao.CidadeDAO;
import br.agenda.model.dto.Cidade;

public class CidadeAction extends HttpServlet {

	private static final long serialVersionUID = 3247826716106213413L;

	protected void doPost(HttpServletRequest rqt, HttpServletResponse rsp)
			throws ServletException, IOException {
		String nome = rqt.getParameter("nome");
		String uf   = rqt.getParameter("uf");
		String ddd  = rqt.getParameter("ddd");

		Cidade o = new Cidade();
		o.setNome(nome);
		o.setUf(uf);
		o.setDdd(ddd);

		try {
			CidadeDAO.adiciona(o);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e);
		}

		RequestDispatcher view = rqt.getRequestDispatcher("/cidade.jsp");
		view.forward(rqt, rsp);

		PrintWriter out = rsp.getWriter();
		out.close();
	}
}
