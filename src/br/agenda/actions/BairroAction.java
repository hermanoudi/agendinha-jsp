package br.agenda.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.agenda.dao.BairroDAO;
import br.agenda.model.dto.*;

public class BairroAction extends HttpServlet {

	private static final long serialVersionUID = -4899951809164178935L;

	protected void doPost(HttpServletRequest rqt, HttpServletResponse rsp)
			throws ServletException, IOException {
		String nome = rqt.getParameter("nome");

		Bairro o = new Bairro();
		o.setNome(nome);

		try {
			BairroDAO.adiciona(o);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro: " + e.getMessage());
		}

		RequestDispatcher view = rqt.getRequestDispatcher("/bairro.jsp");
		view.forward(rqt, rsp);

		PrintWriter out = rsp.getWriter();
		out.close();
	}
}
