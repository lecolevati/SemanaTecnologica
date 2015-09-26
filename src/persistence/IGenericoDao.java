package persistence;

import java.sql.Connection;
import java.sql.SQLException;

public interface IGenericoDao {

	public Connection fazConexao() throws SQLException;
	
}
