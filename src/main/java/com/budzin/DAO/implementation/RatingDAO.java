package com.budzin.DAO.implementation;

import com.budzin.DAO.IGeneralDAO;
import com.budzin.model.Customer;
import com.budzin.model.Feedback;
import com.budzin.model.Rating;
import com.budzin.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO implements IGeneralDAO<Rating> {

    public static final String Table = "budzin_db_lab4_jdbc.Rating";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (number_of_star, Date, Customer_id, Customer_Trip_Order_id) VALUES (?,?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET  number_of_star = ?, Date = ?, Customer_id = ?, Customer_Trip_Order_id = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Rating> getAll() {
        List<Rating> rating = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Rating Rating = new Rating(
                        resultSet.getInt("id"),
                        resultSet.getString("number_of_star"),
                        resultSet.getString("Date"),
                        resultSet.getString("Customer_id"),
                        resultSet.getString("Customer_Trip_Order_id")

                );

                rating.add(Rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }

    @Override
    public Rating getById(int id) {
        Rating rating = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rating = new Rating(
                        resultSet.getInt("id"),
                        resultSet.getString("number_of_star"),
                        resultSet.getString("Date"),
                        resultSet.getString("Customer_id"),
                        resultSet.getString("Customer_Trip_Order_id")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }

    @Override
    public void create(Rating rating) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, rating.getNumber_of_star());
            statement.setString(2, rating.getDate());
            statement.setString(3, rating.getCustomer_id());
            statement.setString(4, rating.getCustomer_Trip_Order_id());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Rating rating) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, rating.getNumber_of_star());
            statement.setString(2, rating.getDate());
            statement.setString(3, rating.getCustomer_id());
            statement.setString(4, rating.getCustomer_Trip_Order_id());
            statement.setInt(5, id);
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
