package br.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.agenda.model.dto.Bairro;
import br.agenda.model.dto.Cidade;
import br.agenda.model.dto.Contato;
import br.agenda.model.dto.Pais;
import br.agenda.dao.ConnectionFactory;

public class BairroDAO {
	// a conexão com o banco de dados
	private static Connection connection;

	// construtor que recebe a conexão
	public BairroDAO() throws SQLException {
		connection = ConnectionFactory.getConnection();
	}

	public static void adiciona(Bairro o) throws SQLException {
		
		// prepared statement para incluir
		String SQL = "insert into bairro (bai_nome) values (?)";

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		try {
			// seta os valores
			psm.setString(1, o.getNome());

			// executa
			psm.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao inserir dados: " + e.getMessage());
		}

		psm.close();
	}
	public List<Bairro> getLista() throws SQLException {

		PreparedStatement psm = connection.prepareStatement("select * from bairro");
		ResultSet rs = psm.executeQuery();

		List<Bairro> lista = new ArrayList<Bairro>();

		while (rs.next()) {
			// criando o objeto
			Bairro o = new Bairro();
			o.setId(rs.getLong("bai_id"));
			o.setNome(rs.getString("bai_nome"));
			
			// adicionando o objeto à lista
			lista.add(o);
		}

		rs.close();
		psm.close();

		return lista;
	}
	
    public static Bairro findById(Long id) throws SQLException {
		
		String SQL = "select bai_id, bai_nome from bairro where bai_id=?";
		Bairro bai = new Bairro();
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement psm = con.prepareStatement(SQL);
		psm.setLong(1,id);
		ResultSet rs = psm.executeQuery();
		
		if (!rs.next())
			return null;
		
		bai.setId(rs.getLong("bai_id"));
		bai.setNome(rs.getString("bai_nome"));
		
		rs.close();
		psm.close();
		return bai;
	}


}
