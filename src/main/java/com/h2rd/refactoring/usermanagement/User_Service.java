package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 * Service Layer, it communicate with DAO layer.
 *@author Sharan
 */
@Component
public class User_Service {

    /**
     * This method is for Saving a user by passing User as a parameter
     * @param user User
     */
    public void saveUser(User user) {
        UserDao.getUserDao().saveUser(user);
    }

    /**
     * This method is for updating a user by passing User as a parameter
     * @param user User
     */
    public void updateUser(User user) {
        UserDao.getUserDao().updateUser(user);
    }

    /**
     * This method is for deleting a user by passing User as a parameter
     * @param user User
     */
    public void deleteUser(User user) {
        UserDao.getUserDao().deleteUser(user);
    }

    /**
     *This method returns the arraylist of a users.
     *@return ArrayList<User>
     */
    public ArrayList<User> getUsers() {
        return UserDao.getUserDao().getUsers();
    }

    /**
     * This method returns the user who's email have been passed
     *@param email String
     * @return User
     */
    public User findUserByEmail(String email) {
        return UserDao.getUserDao().findUserByEmail(email);
    }

    /**
     * This method finds a user by taking name as a parameter of type String
     * @param name String
     * @return ArrayList<User>
     */
    public ArrayList<User> findUser(String name) {
        return UserDao.getUserDao().findUser(name);
    }

    /**
     * This method tells whether any user exists or not
     * @param user User
     * @return boolean
     */
    public boolean isUserExist(User user) {

        User usr = findUserByEmail(user.getEmail());
        if (usr == null) {
            return false;
        } else {
            return true;
        }
    }
}