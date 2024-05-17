package com.system.demo.data.utils;

    public class QueryConstant {
        /**
         * SQL query to retrieves all students from the database.
         */
        public static final String GET_ALL_STUDENTS_STATEMENT = "SELECT * FROM STUDENT";

        /**
         * SQL query to retrieves an student by their Student Number from the database.
         */
        public static final String GET_STUDENT_BY_STUDENT_ID_STATEMENT = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";

        /**
         * SQL query that adds a new student to the database.
         */
        public static final String ADD_STUDENT_STATEMENT = "INSERT INTO STUDENT (address, birthdate, birthplace, citizenship, civil_Status, contact_Number, email, first_Name, last_Name, middle_Name, religion, sex, student_Number, section_section_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        /**
         * SQL query to updates an existing student in the database.
         */
        public static final String UPDATE_STATEMENT = "UPDATE STUDENT" +
                " SET id = ?, address = ?, birthdate = ?, birthplace = ?, citizenship = ?, civil_Status = ?, contact_Number = ?, email = ?, first_Name = ?, last_Name = ?, middle_Name = ?, religion = ?, sex = ?, student_number = ?, section_section_id = ?" +
                " WHERE id = ?";
        /**
         * SQL query to find an existing email of the student in the database.
         */

        /**user query***/
        public static final String FIND_STUDENT_BY_EMAIL_STATEMENT = "SELECT * FROM STUDENT WHERE email = ?";

        public static final String GET_USER_BY_USERNAME_STATEMENT = "SELECT * FROM login WHERE username=?";

        public static final String SAVE_USER_STATEMENT = "INSERT INTO login (ID, USERNAME, PASSWORD, ENTITY_ID, DATE_CREATED, DATE_MODIFIED) VALUES (?, ?, ?, ?, ?, ?)";

        public static final String GET_MAX_USER_ID_STATEMENT = "SELECT MAX(ID) AS MAX_ID FROM login";

        public static final String GET_ALL_USER_STATEMENT = "SELECT * FROM LOGIN";

        public static final String GET_USER_BY_ID_STATEMENT = "SELECT * FROM login WHERE id = ?";

        public static final String UPDATE_USER_STATEMENT = "UPDATE login SET username = ?, password = ?, lastLoginDate = ?, joinDate = ?, role = ? WHERE id = ?";

        public static final String GET_USERNAME_STATEMENT = "SELECT * FROM login WHERE username=?";

        public static final String UPDATE_PASSWORD_STATEMENT = "UPDATE login SET password=?, lastLoginDate=? WHERE username=?";

        public static final String GET_PASSWORD_BY_USERNAME_STATEMENT = "SELECT password FROM login WHERE username=?";

        public static final String FORGOT_PASSWORD_STATEMENT = "UPDATE login SET password=?, lastLoginDate=? WHERE username=?";



        /**employee query***/
        public static final String GET_ALL_EMPLOYEE_STATEMENT = "SELECT * FROM EMPLOYEE";

        /**
         * SQL query to retrieves an employee by their Employee Number from the database.
         */
        public static final String GET_EMPLOYEE_BY_ID_STATEMENT = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_NO = ?";

        /**
         * SQL query that adds a new employee to the database.
         */
        public static final String ADD_EMPLOYEE_STATEMENT = "INSERT INTO EMPLOYEE (LAST_NAME, FIRST_NAME, MIDDLE_NAME, POSITION_IN_RC, DATE_EMPLOYED, BIRTHDATE, BIRTHPLACE, SEX, CIVIL_STATUS, CITIZENSHIP, RELIGION, HEIGHT, WEIGHT, EMAIL, SSS_NO, TIN_NO, PAGIBIG_NO, EMPLOYEE_NO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        /**
         * SQL query to updates an existing employee in the database.
         */
        public static final String UPDATE_EMPLOYEE_STATEMENT = "UPDATE EMPLOYEE SET LAST_NAME = ?, FIRST_NAME = ?, MIDDLE_NAME = ?, POSITION_IN_RC = ?, DATE_EMPLOYED = ?, BIRTHDATE = ?, BIRTHPLACE = ?, SEX = ?, CIVIL_STATUS = ?, CITIZENSHIP = ?, RELIGION = ?, HEIGHT = ?, WEIGHT = ?, EMAIL = ?, SSS_NO = ?, TIN_NO = ?, PAGIBIG_NO = ? WHERE EMPLOYEE_NO = ?";

        /**
         * SQL query to Get all CsSlip in the database.
         */
       public static final  String GET_ALL_CSSLIP_STATEMENT ="SELECT * FROM LOGIN";
    }
