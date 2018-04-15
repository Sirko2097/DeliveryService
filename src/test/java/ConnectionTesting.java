import dao.implementations.DAOFactoryImpl;
import dao.interfaces.DAOCargo;
import dao.interfaces.DAOFactory;
import dao.interfaces.DAOClient;
import model.Cargo;
import model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConnectionTesting {



    @Test
    public void testGetAllCargoes() throws SQLException{
        DAOFactory daoFactory = new DAOFactoryImpl();
        List<Cargo> cargoes;
        try(Connection connection = daoFactory.getConnection()) {
            DAOCargo daoCargo = daoFactory.getDAOCargoImpl(connection);
            cargoes = daoCargo.getAll();
        }

        Assert.assertNotNull(cargoes);
        Assert.assertTrue(cargoes.size() > 0);

    }

    @Test
    public void testGetAllUsers() throws SQLException {
        DAOFactory daoFactory = new DAOFactoryImpl();
        List<Client> clients;
        try(Connection connection = daoFactory.getConnection()) {
            DAOClient daoClient = daoFactory.getDAOClientImpl(connection);
            clients = daoClient.getAll();
        }

        Assert.assertNotNull(clients);
        Assert.assertTrue(clients.size() > 0);
    }
}
