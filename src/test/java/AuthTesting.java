import dao.implementations.DAOFactoryImpl;
import dao.interfaces.DAOClient;
import dao.interfaces.DAOFactory;
import model.Client;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class AuthTesting {
    @Test
    public void checkUserAuth() throws Exception {
        DAOFactory daoFactory = new DAOFactoryImpl();
        Client client;
        try(Connection connection = daoFactory.getConnection()) {
            DAOClient daoClient = daoFactory.getDAOClientImpl(connection);
            client = daoClient.checkAuth("Sirko2097", "123789Cthusq");
        }
        Assert.assertNotNull(client);
    }
}
