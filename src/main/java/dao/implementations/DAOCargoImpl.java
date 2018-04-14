package dao.implementations;

import dao.interfaces.DAOCargo;
import model.Cargo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of DAOCargo interface.
 * */
public class DAOCargoImpl implements DAOCargo {
    private final Connection connection;

    private final static Logger logger = Logger.getLogger(DAOCargoImpl.class);

    public DAOCargoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cargo create() {
        return null;
    }


    /**
     * Method which finds record by key in DB and return the object;
     *
     * @param   key id of the record in DB
     * @return  object of class "Cargo"
     * */
    @Override
    public Cargo read(int key) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT type, " +
                "cargo_desc.length, cargo_desc.width, cargo_desc.depth, cargo_desc.weight " +
                "FROM cargo_desc JOIN cargo_info info on cargo_desc.cargo_id = info.cargo_id where info.cargo_id = ?");
        preparedStatement.setInt(1, key);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Cargo cargo = new Cargo();
        cargo.setType(resultSet.getString("type"));
        cargo.setLength(resultSet.getDouble("length"));
        cargo.setLength(resultSet.getDouble("width"));
        cargo.setLength(resultSet.getDouble("depth"));
        cargo.setLength(resultSet.getDouble("weight"));

        return cargo;
    }

    /**
     * This method finds all records from DB and
     * @return list of appropriate objects.
     * */
    @Override
    public List<Cargo> getAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT type, length," +
                "width, depth, weight, info.cargo_id FROM cargo_desc JOIN cargo_info info on cargo_desc.cargo_id = info.cargo_id");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Cargo> cargoes = new ArrayList<>();
        while (resultSet.next()) {
            cargoes.add(new Cargo(resultSet.getString("type"), resultSet.getDouble("length"),
                    resultSet.getDouble("width"), resultSet.getDouble("depth"),
                    resultSet.getDouble("weight")));
        }
        return cargoes;
    }


    /**
     * This method finds all records from DB by the key(id) and
     * @return list of appropriate objects.
     * */
    @Override
    public List<Cargo> getAll(int key) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT type, length," +
                "width, depth, weight, info.cargo_id FROM cargo_desc JOIN cargo_info info " +
                "on cargo_desc.cargo_id = info.cargo_id WHERE info.cargo_id = ?");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Cargo> cargoes = new ArrayList<>();
        while (resultSet.next()) {
            cargoes.add(new Cargo(resultSet.getString("type"), resultSet.getDouble("length"),
                    resultSet.getDouble("width"), resultSet.getDouble("depth"),
                    resultSet.getDouble("weight")));
        }
        return cargoes;
    }
}
