package dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Data Access factory with methods
 * for working with information.
 * */
public interface DAOFactory {
    Connection getConnection() throws SQLException;

    DAOCargo getDAOCargoImpl(Connection connection);

    DAOClient getDAOUserImpl(Connection connection);
}
