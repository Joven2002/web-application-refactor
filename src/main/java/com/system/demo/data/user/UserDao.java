package com.system.demo.data.user;

import com.system.demo.appl.model.user.User;

import java.util.List;

public interface UserDao {
    User findUserByUsername(String username);

    /**
     * Saves the given user to the database.
     *
     * @param user the user to be saved
     * @return the saved user
     */
    User saveUser(User user);

    /**
     * Retrieves the maximum user ID.
     *
     * @return the maximum user ID
     */
    long getMaxUserId();

    /**
     * Retrieves all users.
     *
     * @return list of all User
     */
    List<User> getAllUsers() ;

    /**
     * Retrieves a user by ID.
     *
     * @param id the ID of the user to retrieve
     * @return the User with the given ID, or null if not found
     */
   // User getUserById(long id);

    /**
     * Updates a user.
     *
     * @return true if the update was successful, false otherwise
     */
    boolean updateUser();

    /**
     * Retrieves a user by username.
     *
     * @param username the username of the user to retrieve
     * @return the User with the given username, or null if not found
     */
    User getUsername(String username);

    /**
     * Updates the password for a user.
     *
     * @param user the user with the updated password
     * @return the updated User
     */
    User updatePassword(User user);


    /**
     * Retrieves the password for a user by username.
     *
     * @param username the username of the user
     * @return the password with the given username, or null if not found
     */
    String getPasswordByUsername(String username);

    /**
     * Resets the password for a user.
     *
     * @param username    the username of the user
     * @param newPassword the new password
     * @return the updated User
     */
    String forgotPassword(String username, String newPassword);
}
