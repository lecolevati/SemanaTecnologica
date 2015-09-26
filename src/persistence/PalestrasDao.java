package persistence;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import model.Palestra;

public class PalestrasDao implements IPalestrasDao {

	private Connection c;
	
	public PalestrasDao() throws SQLException{
		GenericoDao gDao = new GenericoDao();
		c = gDao.fazConexao();
	}

	@Override
	public void iuPalestras(Palestra palestra) throws SQLException {
		String sql = "{exec sp_palestras (?,?,?,?,?,?,?,?,?,?,?)}"; 
		CallableStatement cs = c.prepareCall(sql);
		if (palestra.getCodigo() == null){
			cs.setNull(1, Types.VARCHAR);
		} else {
			cs.setString(1, palestra.getCodigo());
		}
		cs.setString(2, palestra.getTitulo());
		cs.setString(3, palestra.getTitulacao());
		cs.setString(4, palestra.getPalestrante());
		cs.setString(5, palestra.getEmpresa());
		cs.setInt(6, palestra.getDuracao());
		cs.setString(7, palestra.getDt()+" "+palestra.getHr());
		cs.setInt(8, palestra.getTipo().getCodigo());
		cs.setInt(9, palestra.getCurso().getCodigo());
		cs.setInt(10, palestra.getEvento().getCodigo());
		cs.setInt(11, palestra.getSala().getNumero());
		cs.execute();
		cs.close();
	}

	@Override
	public void deletePalestras(Palestra palestra) throws SQLException {
		String sql = "delete palestras where codigo = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, palestra.getCodigo());
		ps.execute();
		ps.close();
	}
	
}
