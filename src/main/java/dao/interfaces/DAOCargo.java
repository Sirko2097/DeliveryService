package dao.interfaces;

import model.Cargo;

import java.sql.SQLException;
import java.util.List;

public interface DAOCargo {
    Cargo create();

    Cargo read(int key) throws SQLException;

    List<Cargo> getAll() throws SQLException;


    List<Cargo> getAll(int key) throws SQLException;
}
