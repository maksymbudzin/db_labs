package com.budzin.DAO.implementation;

import com.budzin.DAO.IGeneralDAO;
import com.budzin.model.Location;
import com.budzin.model.Owner_information;
import com.budzin.model.Rating;
import com.budzin.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Owner_informationDAO implements IGeneralDAO<Owner_information> {
    public static final String Table = "budzin_db_lab4_jdbc.Owner_information";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (name, surname, country) VALUES (?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET  name = ?, surname = ?, country = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Owner_information> getAll() {
        List<Owner_information> owner_informations = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                 Owner_information Owner_information = new Owner_information(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                         resultSet.getString("country")

                );

                owner_informations.add(Owner_information);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owner_informations;
    }


    @Override
    public Owner_information getById(int id) {
        Owner_information owner_information = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                owner_information = new Owner_information(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("country")


                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owner_information;
    }

    @Override
    public void create(Owner_information owner_information) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, owner_information.getName());
            statement.setString(2, owner_information.getSurname());
            statement.setString(3, owner_information.getCountry());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Owner_information owner_information) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, owner_information.getName());
            statement.setString(2, owner_information.getSurname());
            statement.setString(3, owner_information.getCountry());
            statement.setInt(4, id);
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
