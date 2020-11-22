package com.budzin.DAO.implementation;

import com.budzin.DAO.IGeneralDAO;
import com.budzin.model.TripAdvizor_objec;
import com.budzin.persistance.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.plaf.synth.Region.TABLE;

public class TripAdvizor_objecDAO implements IGeneralDAO<TripAdvizor_objec> {

    public static final String Table = "budzin_db_lab4_jdbc.TripAdvizor_object";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + Table + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + Table + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + Table + " (objec_name, number_of_star, free_room, " +
            "busy_room, all_inclusive, ultra_all_inclusive)" +
            " VALUES (?,?,?,?,?,?);";

    private static final String UPDATE_QUERY = "UPDATE " + Table + " SET objec_name = ?, number_of_star = ?, free_room = ?," +
            " busy_room = ?, all_inclusive = ?, ultra_all_inclusive = ?  WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + Table + " WHERE id = ?;";

    @Override
    public List<TripAdvizor_objec> getAll() {
        List<TripAdvizor_objec> tripAdvizor_objects = new ArrayList<>();

        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                TripAdvizor_objec TripAdvizor_objec = new TripAdvizor_objec(
                       resultSet.getInt("id"),
                       resultSet.getString("objec_name"),
                       resultSet.getString("number_of_star"),
                       resultSet.getString("free_room"),
                       resultSet.getString("busy_room"),
                       resultSet.getString("all_inclusive"),
                       resultSet.getString("ultra_all_inclusive")
                       );

                tripAdvizor_objects.add(TripAdvizor_objec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tripAdvizor_objects;
    }


    @Override
    public TripAdvizor_objec getById(int id) {
        TripAdvizor_objec tripAdvizor_objec = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                tripAdvizor_objec = new TripAdvizor_objec(
                        resultSet.getInt("id"),
                        resultSet.getString("objec_name"),
                        resultSet.getString("number_of_star"),
                        resultSet.getString("free_room"),
                        resultSet.getString("busy_room"),
                        resultSet.getString("all_inclusive"),
                        resultSet.getString("ultra_all_inclusive")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tripAdvizor_objec;
    }

    @Override
    public void create(TripAdvizor_objec tripAdvizor_objec) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, tripAdvizor_objec.getObjec_name());
            statement.setString(2, tripAdvizor_objec.getNumber_of_star());
            statement.setString(3, tripAdvizor_objec.getFree_room());
            statement.setString(4, tripAdvizor_objec.getBusy_room());
            statement.setString(5, tripAdvizor_objec.getAll_inclusive());
            statement.setString(6, tripAdvizor_objec.getUltra_all_inclusive());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, TripAdvizor_objec tripAdvizor_objec) {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, tripAdvizor_objec.getObjec_name());
            statement.setString(2, tripAdvizor_objec.getNumber_of_star());
            statement.setString(3, tripAdvizor_objec.getFree_room());
            statement.setString(4, tripAdvizor_objec.getBusy_room());
            statement.setString(5, tripAdvizor_objec.getAll_inclusive());
            statement.setString(6, tripAdvizor_objec.getUltra_all_inclusive());
            statement.setInt(7, id);
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


