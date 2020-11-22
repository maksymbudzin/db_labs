package com.budzin.DAO.implementation;

import com.budzin.DAO.IGeneralDAO;
import com.budzin.model.Rating;
import com.budzin.model.Trip_Order;
import com.budzin.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Trip_OrderDAO implements IGeneralDAO<Trip_Order> {

    public static final String Table = "budzin_db_lab4_jdbc.Trip_Order";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (price_in_dollars, date, Customer_id) VALUES (?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET  price_in_dollars = ?, date = ?, Customer_id = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Trip_Order> getAll() {
        List<Trip_Order> trip_orders = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Trip_Order Trip_Order = new Trip_Order(
                        resultSet.getInt("id"),
                        resultSet.getString("price_in_dollars"),
                        resultSet.getString("date"),
                        resultSet.getString("Customer_id")


                );

                trip_orders.add(Trip_Order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trip_orders;
    }

    @Override
    public Trip_Order getById(int id) {
        Trip_Order trip_order = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                trip_order = new Trip_Order(
                        resultSet.getInt("id"),
                        resultSet.getString("price_in_dollars"),
                        resultSet.getString("date"),
                        resultSet.getString("Customer_id")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trip_order;
    }

    @Override
    public void create(Trip_Order trip_order) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, trip_order.getPrice_in_dollars());
            statement.setString(2, trip_order.getDate());
            statement.setString(3, trip_order.getCustomer_id());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Trip_Order trip_order) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, trip_order.getPrice_in_dollars());
            statement.setString(2, trip_order.getDate());
            statement.setString(3, trip_order.getCustomer_id());
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
