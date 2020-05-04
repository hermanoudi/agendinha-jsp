package br.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.agenda.model.dto.Cidade;
import br.agenda.dao.ConnectionFactory;

public class CidadeDAO {
	// a conexão com o banco de dados
	private static Connection connection;

	// construtor que recebe a conexão
	public CidadeDAO() throws SQLException {
		connection = ConnectionFactory.getConnection();
	}

	public static void adiciona(Cidade o) throws SQLException {
		
		// prepared statement para incluir
		String SQL = "insert into cidade (cid_nome, cid_uf, cid_ddd) values (?,?,?)";

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		try {
			// seta os valores
			psm.setString(1, o.getNome());
			psm.setString(2, o.getUf());
			psm.setString(3, o.getDdd());

			// executa
			psm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro ao inserir dados");
		}

		psm.close();
	}
	public List<Cidade> getLista() throws SQLException {

		PreparedStatement psm = connection.prepareStatement("select * from cidade");
		ResultSet rs = psm.executeQuery();

		List<Cidade> list = new ArrayList<Cidade>();

		while (rs.next()) {
			// criando o objeto 
			Cidade o = new Cidade();
			o.setId(rs.getLong("cid_id"));
			o.setNome(rs.getString("cid_nome"));
			
			// adicionando o objeto à lista
			list.add(o);
		}

		rs.close();
		psm.close();

		return list;
	}

}

