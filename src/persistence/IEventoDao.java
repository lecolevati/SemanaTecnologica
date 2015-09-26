package persistence;

import java.sql.SQLException;
import java.util.List;

import model.DataEvento;
import model.Evento;

public interface IEventoDao {

	public List<DataEvento> consultaDatasEvento(Evento ev) throws SQLException;
	public Evento consultaEvento() throws SQLException;
	
}
