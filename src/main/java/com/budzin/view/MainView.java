package com.budzin.view;

import com.budzin.DAO.implementation.Owner_informationDAO;
import com.budzin.controller.*;
import com.budzin.model.*;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private final TripAdvizor_objecController tripAdvizor_objecController = new TripAdvizor_objecController();
    private final CustomerController customerController = new CustomerController();
    private final FeedbackController feedbackController = new FeedbackController();
    private final RatingController ratingController = new RatingController();
    private final LocationController locationController = new LocationController();
    private final Owner_informationController ownerInformationController = new Owner_informationController();
    private final Trip_OrderController trip_orderController = new Trip_OrderController();


    private final Map<String, Printable> menu = new LinkedHashMap<>();


    public MainView(){


      /*  menu.put("Q", "Q - exit program");
        menu.put("S", "S - show menu");

        menu.put("1", "1 - Get all tripAdvizoOobjects");
        menu.put("2", "2 - Get tripAdvizorObject by ID");
        menu.put("3", "3 - Create tripAdvixorObjects");
        menu.put("4", "4 - Delete tripAdvizorObject by ID");
        menu.put("5", "5 - Update tripAdvizorObject");

        methodsMenu.put("1", this::getAllTripAdvizorObjects);
        methodsMenu.put("2", this::getTripAdvizorObjectsById);
        methodsMenu.put("3", this::createTripAdvizorObject);
        methodsMenu.put("4", this::deleteTripAdvizorObject);
        methodsMenu.put("5", this::updateTripAdvizorObject);*/

        menu.put("11", this::getAllTripAdvizorObjects);
        menu.put("12", this::getTripAdvizorObjectsById);
        menu.put("13", this::createTripAdvizorObject);
        menu.put("14", this::updateTripAdvizorObject);
        menu.put("15", this::deleteTripAdvizorObject);

        menu.put("21", this::getAllCustomers);
        menu.put("22", this::getCustomerById);
        menu.put("23", this::createCustomer);
        menu.put("24", this::updateCustomer);
        menu.put("25", this::deleteCustomer);

        menu.put("31", this::getAllFeedbacks);
        menu.put("32", this::getFeedbackById);
        menu.put("33", this::createFeedback);
        menu.put("34", this::updateFeedback);
        menu.put("35", this::deleteFeedback);

        menu.put("41", this::getAllRating);
        menu.put("42", this::getRatingById);
        menu.put("43", this::createRating);
        menu.put("44", this::updateRating);
        menu.put("45", this::deleteRating);

        menu.put("51", this::getAllLocation);
        menu.put("52", this::getLocationById);
        menu.put("53", this::createLocation);
        menu.put("54", this::updateLocation);
        menu.put("55", this::deleteLocation);

        menu.put("61", this::getAllOwnerInformation);
        menu.put("62", this::getOwnerInformationById);
        menu.put("63", this::createOwnerInformation);
        menu.put("64", this::updateOwnerInformation);
        menu.put("65", this::deleteOwnerInformation);

        menu.put("71", this::getAllTripOrder);
        menu.put("72", this::getTripOrderById);
        menu.put("73", this::createTripOrder);
        menu.put("74", this::updateTripOrder);
        menu.put("75", this::deleteTripOrder);





    }

    public void displayMenu() {
        System.out.println("=======================================================================");
        System.out.println("                 Enter XY to choose the option, where:");
        System.out.println("=======================================================================");
        System.out.println("X - entity number:                 |       Y - CRUD number:");
        System.out.println("  1 - trip object                  |         1 - GET ALL");
        System.out.println("  2 - customer                     |         2 - GET ONE");
        System.out.println("  3 - feedback                     |         3 - CREATE");
        System.out.println("  4 - rating                       |         4 - UPDATE");
        System.out.println("  5 - Location                     |         5 - DELETE");
        System.out.println("  6 - Owner Information");
        System.out.println("  7 - Trip Order");
        System.out.println("=======================================================================");
    }

    public final void show() {
        String input;
        displayMenu();
        System.out.println("\nChoose your fighter:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    private void getAllTripAdvizorObjects() throws SQLException {
        System.out.println("\n[TripAdvizorObject / GET]");
        System.out.println(tripAdvizor_objecController.getAll() + "\n");
    }

    private void getTripAdvizorObjectsById() throws SQLException {
        System.out.println("\n[TripAdvizorObject / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(tripAdvizor_objecController.getById(id) + "\n");
    }

    private TripAdvizor_objec getTripAdvizorObgectsInputs() {
        System.out.println("Enter objec_name: ");
        String objec_name = SCANNER.next();
        System.out.println("Enter number_of_star: ");
        String number_of_star = SCANNER.next();
        System.out.println("\nEnter free room");
        String free_room = SCANNER.next();
        System.out.println("\nEnter busy room");
        String busy_room = SCANNER.next();
        System.out.println("\nEnter all inclusive");
        String all_inclusive = SCANNER.next();
        System.out.println("\nEnter ultra all inclusive");
        String ultra_all_inclusive = SCANNER.next();

        return new TripAdvizor_objec(objec_name, number_of_star, free_room, busy_room, all_inclusive, ultra_all_inclusive);
    }

    private void createTripAdvizorObject () throws SQLException {
        System.out.println("\n[Trip Advizor Object / CREATE]");
        TripAdvizor_objec tripAdvizor_objec = getTripAdvizorObgectsInputs();
        tripAdvizor_objecController.create(tripAdvizor_objec);
        System.out.println("Trip Advizor Object successfully created\n");
    }

    private void updateTripAdvizorObject () throws SQLException {
        System.out.println("\n[Trip Advizor Object/ UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        TripAdvizor_objec tripAdvizor_objec = getTripAdvizorObgectsInputs();
        tripAdvizor_objec.setId(id);

        tripAdvizor_objecController.update(tripAdvizor_objec.getId(), tripAdvizor_objec);
        System.out.println("Trip Object with ID=" + id + " successfully updated\n");
    }

    private void deleteTripAdvizorObject() throws SQLException {
        System.out.println("\n[Trip Advizor Object / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        tripAdvizor_objecController.delete(id);
        System.out.println("Trip object with ID=" + id + " successfully deleted\n");
    }


    private void getAllCustomers() throws SQLException {
        System.out.println("\n[Customers / GET]");
        System.out.println(customerController.getAll() + "\n");
    }

    private void getCustomerById() throws SQLException {
        System.out.println("\n[Customers / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(customerController.getById(id) + "\n");
    }


    private Customer getCustomersInputs() {
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter surname: ");
        String surname = SCANNER.next();

        return new Customer(name, surname);
    }

    private void createCustomer () throws SQLException {
        System.out.println("\n[Customer / CREATE]");
        Customer customer = getCustomersInputs();
        customerController.create(customer);
        System.out.println("Customer successfully created\n");
    }

    private void updateCustomer () throws SQLException {
        System.out.println("\n[Customer/ UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Customer customer =  getCustomersInputs();
        customer.setId(id);

        customerController.update(customer.getId(), customer);
        System.out.println("Customer with ID=" + id + " successfully updated\n");
    }

    private void deleteCustomer() throws SQLException {
        System.out.println("\n[Customer / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        customerController.delete(id);
        System.out.println("Customer with ID=" + id + " successfully deleted\n");
    }


    private void getFeedbackById() throws SQLException {
        System.out.println("\n[feedback / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(feedbackController.getById(id) + "\n");
    }


    private void getAllFeedbacks() throws SQLException {
        System.out.println("\n[Feedback / GET]");
        System.out.println(feedbackController.getAll() + "\n");
    }

    private Feedback getFeedbacksInputs() {
        System.out.println("Enter name: ");
        String name = SCANNER.next();
        System.out.println("Enter time: ");
        String time = SCANNER.next();
        System.out.println("Customer Id: ");
        String Customer_Id = SCANNER.next();
        System.out.println("customer_trip: ");
        String Customer_Trip_Order_id = SCANNER.next();

        return new Feedback(name, time, Customer_Id, Customer_Trip_Order_id );
    }

    private void createFeedback () throws SQLException {
        System.out.println("\n[Feedback / CREATE]");
        Feedback feedback = getFeedbacksInputs();
        feedbackController.create(feedback);
        System.out.println("Feedback successfully created\n");
    }

    private void updateFeedback () throws SQLException {
        System.out.println("\n[Feedback/ UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Feedback feedback = getFeedbacksInputs();
        feedback.setId(id);

        feedbackController.update(feedback.getId(), feedback);
        System.out.println("Feedback with ID=" + id + " successfully updated\n");
    }

    private void deleteFeedback() throws SQLException {
        System.out.println("\n[Feedback / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        feedbackController.delete(id);
        System.out.println("Feedback with ID=" + id + " successfully deleted\n");
    }


    private void getRatingById() throws SQLException {
        System.out.println("\n[Rating / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(ratingController.getById(id) + "\n");
    }


    private void getAllRating() throws SQLException {
        System.out.println("\n[Rating / GET]");
        System.out.println(ratingController.getAll() + "\n");
    }


    private Rating getRatingInputs() {
        System.out.println("Enter number_of_star: ");
        String number_of_star = SCANNER.next();
        System.out.println("Enter date: ");
        String date = SCANNER.next();
        System.out.println("Customer Id: ");
        String Customer_Id = SCANNER.next();
        System.out.println("customer_trip: ");
        String Customer_Trip_Order_id = SCANNER.next();

        return new Rating(number_of_star, date, Customer_Id, Customer_Trip_Order_id );
    }

    private void createRating () throws SQLException {
        System.out.println("\n[Rating / CREATE]");
        Rating rating = getRatingInputs();
        ratingController.create(rating);
        System.out.println("Rating successfully created\n");
    }

    private void updateRating () throws SQLException {
        System.out.println("\n[Rating / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Rating rating = getRatingInputs();
        rating.setId(id);
        ratingController.update(rating.getId(), rating);
        System.out.println("Rating with ID=" + id + " successfully updated\n");
    }

    private void deleteRating() throws SQLException {
        System.out.println("\n[Rating / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        ratingController.delete(id);
        System.out.println("Rating with ID=" + id + " successfully deleted\n");
    }


    private void getLocationById() throws SQLException {
        System.out.println("\n[Location / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(locationController.getById(id) + "\n");
    }


    private void getAllLocation() throws SQLException {
        System.out.println("\n[Location / GET]");
        System.out.println(locationController.getAll() + "\n");
    }


    private Location getLocationInputs() {
        System.out.println("Enter number_of_star: ");
        String Country = SCANNER.next();
        System.out.println("Enter date: ");
        String City = SCANNER.next();


        return new Location(Country, City);
    }

    private void createLocation () throws SQLException {
        System.out.println("\n[Location / CREATE]");
        Location location = getLocationInputs();
        locationController.create(location);
        System.out.println("Location successfully created\n");
    }

    private void updateLocation () throws SQLException {
        System.out.println("\n[Location / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Location location = getLocationInputs();
        location.setId(id);
        locationController.update(location.getId(), location);
        System.out.println("Location with ID=" + id + " successfully updated\n");
    }

    private void deleteLocation() throws SQLException {
        System.out.println("\n[Location / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        locationController.delete(id);
        System.out.println("Location with ID=" + id + " successfully deleted\n");
    }

    private void getOwnerInformationById() throws SQLException {
        System.out.println("\n[Owner / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(ownerInformationController.getById(id) + "\n");
    }


    private void getAllOwnerInformation() throws SQLException {
        System.out.println("\n[Owner / GET]");
        System.out.println(ownerInformationController.getAll() + "\n");
    }


    private Owner_information getOwnerInputs() {
        System.out.println("Enter Name: ");
        String Name = SCANNER.next();
        System.out.println("Enter Surname: ");
        String Surname = SCANNER.next();
        System.out.println("Enter Country: ");
        String Country = SCANNER.next();


        return new Owner_information(Name, Surname, Country);
    }

    private void createOwnerInformation () throws SQLException {
        System.out.println("\n[Owner / CREATE]");
        Owner_information owner_information =  getOwnerInputs();
        ownerInformationController.create(owner_information);
        System.out.println("Owner successfully created\n");
    }

    private void updateOwnerInformation () throws SQLException {
        System.out.println("\n[Owner / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Owner_information owner_information =  getOwnerInputs();
        owner_information.setId(id);
        ownerInformationController.update(owner_information.getId(), owner_information);
        System.out.println("Owner with ID=" + id + " successfully updated\n");
    }

    private void deleteOwnerInformation() throws SQLException {
        System.out.println("\n[Owner / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        ownerInformationController.delete(id);
        System.out.println("Owner with ID=" + id + " successfully deleted\n");
    }

    private void getTripOrderById() throws SQLException {
        System.out.println("\n[Trip Order / GET] Enter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(trip_orderController.getById(id) + "\n");
    }


    private void getAllTripOrder() throws SQLException {
        System.out.println("\n[Trip Order  / GET]");
        System.out.println(trip_orderController.getAll() + "\n");
    }


    private Trip_Order getTripOrderInputs() {
        System.out.println("Enter Price: ");
        String price_in_dollars = SCANNER.next();
        System.out.println("Enter  Date: ");
        String date = SCANNER.next();
        System.out.println("Enter Customer iD: ");
        String Customer_id = SCANNER.next();


        return new Trip_Order(price_in_dollars, date, Customer_id);
    }

    private void createTripOrder () throws SQLException {
        System.out.println("\n[Trip Order / CREATE]");
        Trip_Order trip_order = getTripOrderInputs();
        trip_orderController.create(trip_order);
        System.out.println("Trip order successfully created\n");
    }

    private void updateTripOrder () throws SQLException {
        System.out.println("\n[Trip Oder / UPDATE] Enter ID: ");
        Integer id = SCANNER.nextInt();
        Trip_Order trip_order = getTripOrderInputs();
        trip_order.setId(id);
        trip_orderController.update(trip_order.getId(), trip_order);
        System.out.println("Trip Order with ID=" + id + " successfully updated\n");
    }

    private void deleteTripOrder() throws SQLException {
        System.out.println("\n[Trip Order / DELETE] Enter ID: ");
        int id = SCANNER.nextInt();

        trip_orderController.delete(id);
        System.out.println("Trip Order with ID=" + id + " successfully deleted\n");
    }







   /* private void getAllTripAdvizorObjects() throws SQLException {
        System.out.println("\nTrip Advizor objects:");
        System.out.println(tripAdvizor_objecController.getAll());
    }

    private void getTripAdvizorObjectsById() throws SQLException {
        System.out.println("\nEnter ID for the TripAdvizor object you want to find");
        int id = INPUT.nextInt();
        System.out.println(tripAdvizor_objecController.getById(id));
    }

    private void deleteTripAdvizorObject() throws SQLException {
        System.out.println("\nEnter TripAdvizor object for the user you want to delete");
        int id = INPUT.nextInt();
        System.out.println(tripAdvizor_objecController.delete(id));
    }

    private void createTripAdvizorObject () throws SQLException {
        System.out.println("\nEnter TripAdvizorObject ID");
        int Id = INPUT.nextInt();
        System.out.println("\nEnter object name ");
        String objec_name = INPUT.next();
        System.out.println("\nEnter number star");
        String number_of_star = INPUT.next();
        System.out.println("\nEnter free room");
        String free_room = INPUT.next();
        System.out.println("\nEnter busy room");
        String busy_room = INPUT.next();
        System.out.println("\nEnter all inclusive");
        String all_inclusive = INPUT.next();
        System.out.println("\nEnter ultra all inclusive");
        String ultra_all_inclusive = INPUT.next();
        TripAdvizor_objec tripAdvizor_objec = new TripAdvizor_objec(Id, objec_name, number_of_star, free_room, busy_room, all_inclusive, ultra_all_inclusive);
        System.out.println(tripAdvizor_objecController.create(tripAdvizor_objec));
    }

    private void updateTripAdvizorObject() throws SQLException {
        System.out.println("\nEnter TripAdvizorObject ID");
        int Id = INPUT.nextInt();
        System.out.println("\nEnter object name ");
        String objec_name = INPUT.next();
        System.out.println("\nEnter number star");
        String number_of_star = INPUT.next();
        System.out.println("\nEnter free room");
        String free_room = INPUT.next();
        System.out.println("\nEnter busy room");
        String busy_room = INPUT.next();
        System.out.println("\nEnter all inclusive");
        String all_inclusive = INPUT.next();
        System.out.println("\nEnter ultra all inclusive");
        String ultra_all_inclusive = INPUT.next();
        TripAdvizor_objec tripAdvizor_objec = new TripAdvizor_objec(Id, objec_name, number_of_star, free_room, busy_room, all_inclusive, ultra_all_inclusive);
        System.out.println(tripAdvizor_objecController.update(tripAdvizor_objec));
    }*/
}
