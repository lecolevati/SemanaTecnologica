package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DataEvento;
import model.Evento;

public class EventoDao implements IEventoDao {

	private Connection c;
	
	public EventoDao() throws SQLException {
		GenericoDao gDao = new GenericoDao();
		c = gDao.fazConexao();
	}

	@Override
	public List<DataEvento> consultaDatasEvento(Evento ev) throws SQLException {
		List<DataEvento> lista = new ArrayList<DataEvento>();
		StringBuffer sql = new StringBuffer();
		sql.append("select ev.codigo, ev.nome, de.data_evento, ");
		sql.append("convert(char(10),de.data_evento,103) as dtconvertida ");
		sql.append("from dataevento de ");
		sql.append("inner join evento ev ");
		sql.append("on ev.codigo = de.codigo_evento ");
		sql.append("where de.data_evento >= GETDATE()");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			DataEvento de = new DataEvento();
			de.setDtEvento(rs.getString("data_evento").substring(0,rs.getString("data_evento").lastIndexOf(" ")));
			de.setDtConvertida(rs.getString("dtconvertida"));
			Evento eve = new Evento();
			eve.setCodigo(rs.getInt("codigo"));
			eve.setNome(rs.getString("nome"));
			de.setEvento(eve);
			lista.add(de);
		}
		rs.close();
		ps.close();
		return lista;
	}

	@Override
	public Evento consultaEvento() throws SQLException {
		Evento ev = new Evento();
		StringBuffer sql = new StringBuffer();
		sql.append("select ev.codigo, ev.nome, de.data_evento, ");
		sql.append("convert(char(10),de.data_evento,103) as dtconvertida ");
		sql.append("from dataevento de ");
		sql.append("inner join evento ev ");
		sql.append("on ev.codigo = de.codigo_evento ");
		sql.append("where de.data_evento >= GETDATE()");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		if (rs.next()){
			ev.setCodigo(rs.getInt("codigo"));
			ev.setNome(rs.getString("nome"));
		}
		rs.close();
		ps.close();
		return ev;
	}
	
}
