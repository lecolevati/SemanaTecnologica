package persistence;

import java.sql.SQLException;

import model.Palestra;

public interface IPalestrasDao {

	public void iuPalestras(Palestra palestra) throws SQLException;
	public void deletePalestras(Palestra palestra) throws SQLException;
	
}
