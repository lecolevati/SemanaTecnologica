package persistence;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.leandrocolevati.bancodedados.GenericDao;
import br.com.leandrocolevati.bancodedados.Sgbd;

public class GenericoDao implements IGenericoDao {

	public GenericoDao(){
		super();
	}

	@Override
	public Connection fazConexao() throws SQLException {
		GenericDao gDao = new GenericDao("localhost", "l.colevati", "com@fatec", "semanatecnologica", true, Sgbd.SQLSERVER);
		Connection c = gDao.getConnection();
		return c;
	}
	
	
}
