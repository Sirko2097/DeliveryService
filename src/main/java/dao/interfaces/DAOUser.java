package dao.interfaces;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface DAOUser {
    User create();

    User read(int key) throws SQLException;

    List<User> getAll() throws SQLException;
}
