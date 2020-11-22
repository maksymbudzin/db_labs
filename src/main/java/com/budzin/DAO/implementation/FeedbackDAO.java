package com.budzin.DAO.implementation;

import com.budzin.DAO.IGeneralDAO;
import com.budzin.model.Feedback;
import com.budzin.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO implements IGeneralDAO<Feedback> {

    public static final String Table = "budzin_db_lab4_jdbc.Feedback";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (feedback_text, time, Customer_id, Customer_Trip_Order_id) VALUES (?,?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET feedback_text = ?,  time = ?, Customer_id = ?, Customer_Trip_Order_id = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<Feedback> getAll() {
        List<Feedback> feedbacks = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Feedback Feedback = new Feedback(
                        resultSet.getInt("id"),
                        resultSet.getString("feedback_text"),
                        resultSet.getString("time"),
                        resultSet.getString("Customer_id"),
                        resultSet.getString("Customer_Trip_Order_id")

                );

                feedbacks.add(Feedback);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedbacks;
    }

    @Override
    public Feedback getById(int id) {
        Feedback feedback = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                feedback = new Feedback(
                        resultSet.getInt("id"),
                        resultSet.getString("feedback_text"),
                        resultSet.getString("time"),
                        resultSet.getString("Customer_id"),
                        resultSet.getString("Customer_Trip_Order_id")

                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return feedback;
    }

    @Override
    public void create(Feedback feedback) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, feedback.getFeedback_text());
            statement.setString(2, feedback.getTime());
            statement.setString(3, feedback.getCustomer_id());
            statement.setString(4, feedback.getCustomer_Trip_Order_id());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Feedback feedback) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, feedback.getFeedback_text());
            statement.setString(2, feedback.getTime());
            statement.setString(3, feedback.getCustomer_id());
            statement.setString(4, feedback.getCustomer_Trip_Order_id());
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
