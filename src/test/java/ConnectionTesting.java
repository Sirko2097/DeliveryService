import dao.implementations.DAOFactoryImpl;
import dao.interfaces.DAOCargo;
import dao.interfaces.DAOFactory;
import model.Cargo;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConnectionTesting {
    @Test
    public void testGetAll() throws SQLException{
        DAOFactory daoFactory = new DAOFactoryImpl();
        List<Cargo> cargoes;
        try( Connection connection = daoFactory.getConnection()) {
            DAOCargo daoCargo = daoFactory.getDAOCargoImpl(connection);
            cargoes = daoCargo.getAll();
        }
        Assert.assertNotNull(cargoes);
        Assert.assertTrue(cargoes.size() > 0);
    }
}
