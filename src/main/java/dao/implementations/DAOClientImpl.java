package dao.implementations;

import dao.interfaces.DAOClient;
import model.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClientImpl implements DAOClient {
    private final Connection connection;

    private static final Logger logger = Logger.getLogger(DAOClientImpl.class);

    DAOClientImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Client create() {
        return null;
    }

    /**
     * This method finds user in DB by key(id) and
     * @return appropriate object.
     * */
    @Override
    public Client read(int key) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT login, first_name, " +
                "last_name, email FROM client_ind JOIN client_info info on client_ind.client_id = info.client_id WHERE info.client_id = ?");
        preparedStatement.setInt(1, key);
        ResultSet resultSet = preparedStatement.executeQuery();

        logger.info("Appropriate client was read.");

        resultSet.next();
        Client client = new Client();
        client.setLogin(resultSet.getString("login"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setEmail(resultSet.getString("email"));
        return client;
    }

    @Override
    public Client checkAuth(String login, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT login, password FROM client_ind" +
                " WHERE login = '" + login + "' AND password = '" + password + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        /*перевірка, якщо клієнт увів не коректні дані*/
        Client client = new Client();
        client.setLogin(resultSet.getString("login"));
        client.setPassword(resultSet.getString("password"));
        return client;
    }

    /**
     * This method finds all records in DB and
     * @return list of them.
     * */
    @Override
    public List<Client> getAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT login, password," +
                "first_name, last_name, email " +
                "FROM client_ind LEFT JOIN client_info info on client_ind.client_id = info.client_id");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Client> clients = new ArrayList<>();
        while (resultSet.next()) {
            clients.add(new Client(resultSet.getString("login"), resultSet.getString("password"),
                    resultSet.getString("first_name"), resultSet.getString("last_name"),
                    resultSet.getString("email")));
        }
        return clients;
    }

    @Override
    public void registration(String login, String password, String firstName) throws SQLException {
        Statement statement = connection.createStatement();
        if (!statement.execute("SELECT login FROM client_ind WHERE login = '" + login + "'")) {
            connection.setAutoCommit(false);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client_ind (login, password) " +
                        "VALUES ('" + login + "', '" + password + "')");
                preparedStatement.executeLargeUpdate();
                connection.commit();

            } catch (SQLException ex) {
                connection.rollback();
            }
            connection.setAutoCommit(true);
        } else {
            System.out.println("try again");
        }

    }
}
