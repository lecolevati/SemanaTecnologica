package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sala;

public class SalaDao implements ISalaDao {

	private Connection c;
	
	public SalaDao() throws SQLException {
		GenericoDao gDao = new GenericoDao();
		c = gDao.fazConexao();
	}

	@Override
	public List<Sala> listaSalas() throws SQLException {
		List<Sala> lista = new ArrayList<Sala>();
		String sql = "select numero, lotacao from sala";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Sala s = new Sala();
			s.setNumero(rs.getInt("numero"));
			s.setLotacao(rs.getInt("lotacao"));
			lista.add(s);
		}
		rs.close();
		ps.close();
		return lista;
	}
	
}
