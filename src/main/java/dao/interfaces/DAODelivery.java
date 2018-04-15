package dao.interfaces;

import model.Delivery;

import java.sql.SQLException;
import java.util.List;

public interface DAODelivery {
    Delivery create();

    Delivery read(int key) throws SQLException;

    List<Delivery> getAll() throws SQLException;
}
