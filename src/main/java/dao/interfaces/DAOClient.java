package dao.interfaces;

import model.Client;

import java.sql.SQLException;
import java.util.List;

public interface DAOClient {
    Client create();

    Client read(int key) throws SQLException;

    Client checkAuth(String login, String password) throws SQLException;

    List<Client> getAll() throws SQLException;
}
