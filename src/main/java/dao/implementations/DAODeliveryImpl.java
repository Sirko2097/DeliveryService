package dao.implementations;

import dao.interfaces.DAODelivery;
import model.Delivery;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAODeliveryImpl implements DAODelivery {
    private final Connection connection;

    private static final Logger loger = Logger.getLogger(DAODeliveryImpl.class);

    public DAODeliveryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Delivery create() {
        return null;
    }

    @Override
    public Delivery read(int key) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT destination, receiving_date," +
                "total_price FROM delivery_info WHERE delivery_id = ?");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Delivery delivery = new Delivery();
        delivery.setDate(resultSet.getDate("receiving_date").toString());
        delivery.setDestination(resultSet.getString("destination"));
        delivery.setPrice(resultSet.getDouble("total_price"));

        return delivery;
    }
    @Override
    public List<Delivery> getAll() throws SQLException {
        return null;
    }
}
