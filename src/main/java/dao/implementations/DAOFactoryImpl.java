package dao.implementations;

import dao.interfaces.DAOCargo;
import dao.interfaces.DAOFactory;
import dao.interfaces.DAOClient;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactoryImpl implements DAOFactory {
    private String user = "root";
    private String password = "123789Cthusq";
    private String url = "jdbc:mysql://localhost:3306/deliveryService";
    private String driver = "com.mysql.jdbc.Driver";

    private static final Logger logger = Logger.getLogger(DAOFactoryImpl.class);

    public DAOFactoryImpl() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            logger.error(ex);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public DAOCargo getDAOCargoImpl(Connection connection) {
        return new DAOCargoImpl(connection);
    }

    @Override
    public DAOClient getDAOUserImpl(Connection connection) {
        return new DAOClientImpl(connection);
    }
}
