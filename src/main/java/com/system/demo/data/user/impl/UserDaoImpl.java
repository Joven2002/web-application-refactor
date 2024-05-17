package com.system.demo.data.user.impl;

import com.system.demo.appl.model.user.User;
import com.system.demo.data.connection.ConnectionHelper;
import com.system.demo.data.user.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.system.demo.data.utils.QueryConstant.*;


public class UserDaoImpl implements UserDao {
    public static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User findUserByUsername(String username) {
        User user = null;

        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME_STATEMENT);
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    user.setLastLoginDate(resultSet.getDate("lastLoginDate"));
                    user.setJoinDate(resultSet.getDate("joinDate"));
                    user.setRole(resultSet.getString("role"));
                }
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Finding User failed.");
        return user;
    }

    @Override
    public User saveUser(User user) {

        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USER_STATEMENT);
            long maxId = getMaxUserId();

            preparedStatement.setLong(1, maxId + 1);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setDate(4, (Date) user.getLastLoginDate());
            preparedStatement.setDate(5, (Date) user.getJoinDate());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Saving User failed.");
        return user;
    }

    @Override
    public long getMaxUserId() {

        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_MAX_USER_ID_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                LOGGER.debug("MaxUser ID get successfully.");
                return resultSet.getLong("MAX_ID");
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Getting MaxUser ID failed.");
        return 0;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USER_STATEMENT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setAuthorities(resultSet.getString("authorities"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setLastLoginDate(resultSet.getDate("last_Login_Date"));
                user.setJoinDate(resultSet.getDate("join_Date"));
                user.setRole(resultSet.getString("role"));
                user.setIsActive(resultSet.getInt("is_Active"));
                user.setIsLocked(resultSet.getInt("is_Locked"));
                userList.add(user);
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("User database is empty.");
        return userList;
    }

//    @Override
//    public User getUserById(long id) {
//
//        try (Connection con = ConnectionHelper.getConnection())
//        {
//            PreparedStatement stmt = con.prepareStatement(GET_USER_BY_ID_STATEMENT);
//            stmt.setLong(1, id);
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                if (rs.next()) {
//                    LOGGER.debug("User retrieved successfully.");
//                    long idNum = rs.getLong("id");
//                    String userId = rs.getString("userId");
//                    String authorities = rs.getString("authorities");
//                    String username = rs.getString("username");
//                    String password = rs.getString("password");
//                    Date lastLoginDate = rs.getDate("lastLoginDate");
//                    Date joinDate = rs.getDate("joinDate");
//                    String role =rs.getString("role");
//                    int isActive = rs.getInt("is_active");
//                    int isLocked = rs.getInt("is_locked");
//                    return new User(idNum,authorities,userId, username, password, lastLoginDate, joinDate,role,isActive,isLocked);
//                } else {
//                    LOGGER.error("No user found with ID: " + id);
//                }
//            }
//        } catch (Exception ex) {
//            LOGGER.error("Error retrieving user with ID " + id + ": " + ex.getMessage());
//            ex.printStackTrace();
//        }
//        LOGGER.debug("User not found.");
//        return null;
//    }

    @Override
    public boolean updateUser() {
        User user = new User();

        try (Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement(UPDATE_USER_STATEMENT);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setDate(3, (Date) user.getLastLoginDate());
            stmt.setDate(4, (Date) user.getJoinDate());
            stmt.setLong(5, user.getId());
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;

        } catch (Exception ex) {
            LOGGER.error("Error updating user with ID " + user.getId() + ": " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUsername(String username) {
        User login = null;

        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USERNAME_STATEMENT);
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    LOGGER.debug("Username get successfully.");
                    login = new User();
                    login.setId((int) resultSet.getLong("id"));
                    login.setUsername(resultSet.getString("username"));
                    login.setPassword(resultSet.getString("password"));
                }
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Getting username failed.");
        return login;
    }

    @Override
    public User updatePassword(User user) {

        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_STATEMENT);

            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(3, user.getUsername());
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                LOGGER.debug("Password update failed.");
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Updating password failed.");
        return user;
    }

    @Override
    public String getPasswordByUsername(String username) {
        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PASSWORD_BY_USERNAME_STATEMENT);

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    LOGGER.debug("Password get successfully.");
                    return resultSet.getString("password");
                }
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Getting username failed.");
        return null;

    }

    @Override
    public String forgotPassword(String username, String newPassword) {

        try (Connection connection = ConnectionHelper.getConnection())
        {
            PreparedStatement preparedStatement = connection.prepareStatement(FORGOT_PASSWORD_STATEMENT);

            preparedStatement.setString(1, newPassword);
            preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
            preparedStatement.setString(3, username);
            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                LOGGER.debug("Password update failed.");
            }
        } catch (Exception e) {
            LOGGER.error("An SQL Exception occurred." + e.getMessage());
        }
        LOGGER.debug("Updating password failed.");
        return null;
    }

}
