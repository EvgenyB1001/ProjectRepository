package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.DBWorker;

/**
 * Class contains data of person
 */
public class Person {

    /**
     * Data of current person
     */
    private String id = "";
    private String name = "";
    private String surname = "";
    private String middlename = "";
    private HashMap<String, String> phones = new HashMap<String, String>();

    /**
     * Constructor creates new person based on data from data base
     *
     * @param id         id of person
     * @param name       name of person
     * @param middlename middlename of person (may be not initialized)
     * @param surname    surname of person
     */
    public Person(String id, String name, String surname, String middlename) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;

        // Get phone numbers of person
        ResultSet db_data = DBWorker.getInstance().getDBData("SELECT * FROM `phone` WHERE `owner`=" + id);

        try {
            // If there are no numbers, ResultSet == null.
            if (db_data != null) {
                while (db_data.next()) {
                    this.phones.put(db_data.getString("id"), db_data.getString("number"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor creates person with empty data
     */
    public Person() {
        this.id = "0";
        this.name = "";
        this.surname = "";
        this.middlename = "";
    }

    /**
     * Constructor creates person with data to add to data base
     *
     * @param name       name of person
     * @param middlename middlename of person (may be not initialized)
     * @param surname    surname of person
     */
    public Person(String name, String surname, String middlename) {
        this.id = "0";
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
    }

    /**
     * Validates name, surname and middlename
     *
     * @param fml_name_part name, middlename, surname of person
     * @param empty_allowed true - no middlename
     * @return boolean value: true - data is valid
     */
    public boolean validateFMLNamePart(String fml_name_part, boolean empty_allowed) {
        if (empty_allowed) {
            Matcher matcher = Pattern.compile("[A-Za-zА-Яа-яЁё-]{0,150}").matcher(fml_name_part);
            return matcher.matches();
        } else {
            Matcher matcher = Pattern.compile("[A-Za-zА-Яа-яЁё-]{1,150}").matcher(fml_name_part);
            return matcher.matches();
        }

    }

    /**
     * Validates phone number
     *
     * @param number phone number
     * @return boolean value: true - data is valid
     */
    public boolean validatePhoneNumber(String number) {
        Matcher matcher = Pattern.compile("[\\d\\-*\\+*\\#*]{2,50}").matcher(number);
        return matcher.matches();
    }


    /**
     * Returns id of person
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * Returns name of person
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns surname of person
     *
     * @return surname
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Returns middlename of person
     *
     * @return middlename
     */
    public String getMiddlename() {
        if ((this.middlename != null) && (!this.middlename.equals("null"))) {
            return this.middlename;
        } else {
            return "";
        }
    }

    /**
     * Method deletes person with current id
     *
     * @param id id of person
     */
    public void deleteNumber(String id) {
        this.phones.remove(id);
    }

    /**
     * Returns phone numbers of person
     *
     * @return list of phones
     */
    public HashMap<String, String> getPhones() {
        return this.phones;
    }

    /**
     * Method sets id to person
     *
     * @param id id pf person
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Method sets name of person
     *
     * @param name name of person
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method sets surname of person
     *
     * @param surname surname of person
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Method sets middlename of person
     *
     * @param middlename middlename of person
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * Method sets phone to current person
     *
     * @param id    id of number
     * @param phone number of phone
     */
    public void setPhones(String id, String phone) {
        this.phones.put(id, phone);
    }
}
