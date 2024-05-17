package com.system.demo.appl.model.user;

import java.sql.Timestamp;
import java.util.Date;

public class User {
        private long id;


        private String authorities;
        private  String userId;
        private String username;
        private String password;

         private int isActive;


        private int isLocked;
        private Date lastLoginDate;
        private Date joinDate;
        private String role;
        /***
         * Default constructor of the User class.
         */
        public User() {

        }
        /***
         * An User class constructor that initializes the id,userId, username, password, lastLoginDate, joinDate  and role of the User instance.
         * @param id is the id of the user.
         * @param userId is the identity id of the user
         * @param username is the username of the user.
         * @param password is the password of the user.
         * @param lastLoginDate is the last login of the user .
         * @param joinDate is the date created of the user.
         * @param role is the date modified by the user.
         */
        public User(long id,String authorities, String userId, String username, String password,int isActive,int isLocked, Date lastLoginDate, Date joinDate, String role) {
            this.id = id;
            this.authorities = authorities;
            this.userId = userId;
            this.username = username;
            this.password = password;
            this.isActive = isActive;
            this.isLocked = isLocked;
            this.lastLoginDate = lastLoginDate;
            this.joinDate = joinDate;
            this.role = role;
        }
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public int getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(int isLocked) {
        this.isLocked = isLocked;
    }


    /**
         * This gets the User Id
         * @return the user's Id.
         */
        public long getId() { return id; }
        /**
         * This sets the user id
         * @param id is the ID to be set.
         */
        public void setId(long id) {
            this.id = id;
        }
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
        /**
         * This gets the User Username.
         * @return the user's username.
         */

        public String getUsername() {
            return username;
        }
        /**
         * This sets the user username
         * @param username is the username to be set.
         */
        public void setUsername(String username) {
            this.username = username;
        }
        /**
         * This gets the User password
         * @return the user's password.
         */
        public String getPassword() {
            return password;
        }
        /**
         * This sets the user password
         * @param password is the password to be set.
         */
        public void setPassword(String password) {
            this.password = password;
        }
        /**
         * This gets the User entity id
         * @return the user's entity id.
         */
        public Date getLastLoginDate() {
            return lastLoginDate;
        }
        /**
         * This sets the user lastLoginDate
         * @param lastLoginDate is the entity id to be set.
         */
        public void setLastLoginDate(Date lastLoginDate) {
            this.lastLoginDate = lastLoginDate;
        }
        /**
         * This gets the User date created
         * @return the user's date created.
         */
        public Date getJoinDate() {
            return joinDate;
        }
        /**
         * This sets the user date created
         * @param joinDate is the date created to be set.
         */
        public void setJoinDate(Date joinDate) {this.joinDate = joinDate;}
        /**
         * This gets the User date modified
         * @return the user's date modified.
         */
        public String  getRole() {
            return role;
        }
        /**
         * This sets the user date modified
         * @param role is the role of the user.
         */
        public void setRole(String role) {
            this.role = role;
        }
    }

