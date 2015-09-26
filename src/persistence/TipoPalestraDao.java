package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TipoPalestra;

public class TipoPalestraDao implements ITipoPalestraDao {

	private Connection c;
	
	public TipoPalestraDao() throws SQLException{
		GenericoDao gDao = new GenericoDao();
		c = gDao.fazConexao();
	}

	@Override
	public List<TipoPalestra> consultaTipos() throws SQLException {
		List<TipoPalestra> lista = new ArrayList<TipoPalestra>();
		String sql = "select codigo, tipo from tipopalestra";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			TipoPalestra tp = new TipoPalestra();
			tp.setCodigo(rs.getInt("codigo"));
			tp.setTipo(rs.getString("tipo"));
			lista.add(tp);
		}
		rs.close();
		ps.close();
		return lista;
	}
	
}
