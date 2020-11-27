package com.budzin;

import com.budzin.persistance.HibernateUtil;
import com.budzin.view.MainView;
import org.hibernate.Session;

public class Application {

    public static void main(String[] args) {
        try (Session SESSION = HibernateUtil.getSession()) {
            System.out.println("Test session established. ");
            new MainView().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}