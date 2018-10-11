package com.h2rd.refactoring.usermanagement;

import java.util.ArrayList;
/**
 *  UserDao class handles updating, deleting, reading operation on user object.
 * @author aldocuevas
 */
public class UserDao {

    public ArrayList<User> users;

    public static UserDao userDao;

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public void saveUser(User user) {
        if (users == null) {
            users = new ArrayList<User>();
        }
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        try {
            return users;
        } catch (Throwable e) {
            System.out.println("error");
            return null;
        }
    }

    public void deleteUser(User userToDelete) {
        try {
            int removeIdx = -1;
            for (int i = 0; i < this.users.size(); i++) {
                if (this.users.get(i).getEmail().equals(userToDelete.getEmail())) {
                    removeIdx = i;
                    break;
                }
            }

            if (removeIdx > -1) {
                synchronized (this) {
                    this.users.remove(removeIdx);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/**
 *  This method handles updating operation on user object and using synchronized it'll update the user's email and roles simultaneously .
 *   @param userToUpdate User
*/
    public void updateUser(User userToUpdate) {
        try {
            for (User user : users) {
                if (user.getName() == userToUpdate.getName()) {
                    synchronized (this) {
                        user.setEmail(userToUpdate.getEmail());
                        user.setRoles(userToUpdate.getRoles());
                    }
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method finds  a user by providing an name
     * @param name String
     * @return User
     */
    public ArrayList<User> findUser(String name) {
        ArrayList<User> usr = new ArrayList<User>();
        try {
            for (User user : this.users) {
                if (user.getName().equals(name)) {
                    usr.add(user);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return usr;
    }

    /**
     * This method finds  a user by providing an email
     * @param email String
     * @return User
     */
    public User findUserByEmail(String email) {
        try {
            for (User user : this.users) {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;
    }
}

