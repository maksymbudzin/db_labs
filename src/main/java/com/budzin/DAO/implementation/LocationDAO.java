package com.budzin.DAO.implementation;

import com.budzin.DAO.IGeneralDAO;

import com.budzin.model.Location;
import com.budzin.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements IGeneralDAO<Location> {
    public static final String Table = "budzin_db_lab4_jdbc.Location";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (Country, City) VALUES (?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET  Country = ?, City = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                 Location Location = new Location(
                        resultSet.getInt("id"),
                        resultSet.getString("Country"),
                        resultSet.getString("City")

                );

                locations.add(Location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Location getById(int id) {
        Location location = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                location = new Location(
                        resultSet.getInt("id"),
                        resultSet.getString("Country"),
                        resultSet.getString("City")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public void create(Location location) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, location.getCountry());
            statement.setString(2, location.getCity());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Location location) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, location.getCountry());
            statement.setString(2, location.getCity());
            statement.setInt(3, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
