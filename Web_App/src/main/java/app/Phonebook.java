package app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.DBWorker;

/**
 * Class provides actions with data base and contains all existing persons
 */
public class Phonebook {

    /**
     * List of existing persons
     */
    private HashMap<String, Person> persons = new HashMap<String, Person>();

    /**
     * Object, that works with data base
     */
    private DBWorker db = DBWorker.getInstance();

    /**
     * Pointer to specimen of class
     */
    private static Phonebook instance = null;

    /**
     * Method returns specimen of class
     *
     * @return object of phonebook
     */
    public static Phonebook getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new Phonebook();
        }

        return instance;
    }

    /**
     * Creates object of class and get data from database
     */
    protected Phonebook() throws ClassNotFoundException, SQLException {
        ResultSet db_data = this.db.getDBData("SELECT * FROM `person` ORDER BY `surname` ASC");
        while (db_data.next()) {
            this.persons.put(db_data.getString("id"), new Person(db_data.getString("id"), db_data.getString("name"), db_data.getString("surname"), db_data.getString("middlename")));
        }
    }

    /**
     * Method add new person to database
     *
     * @param person person
     * @return boolean value: true - action is complete
     */
    public boolean addPerson(Person person) {
        ResultSet db_result;
        String query;

        // Midllename may not initialized
        if (!person.getSurname().equals("")) {
            query = "INSERT INTO `person` (`name`, `surname`, `middlename`) VALUES ('" + person.getName() + "', '" + person.getSurname() + "', '" + person.getMiddlename() + "')";
        } else {
            query = "INSERT INTO `person` (`name`, `surname`) VALUES ('" + person.getName() + "', '" + person.getSurname() + "')";
        }

        Integer affected_rows = this.db.changeDBData(query);

        // if adding is complete
        if (affected_rows > 0) {
            person.setId(this.db.getLastInsertId().toString());

            // Set new person to general list
            this.persons.put(person.getId(), person);

            return true;
        } else {
            return false;
        }
    }


    /**
     * Update data of current person
     *
     * @param id     current person
     * @param person current person
     * @return boolean value: true - action is complete
     */
    public boolean updatePerson(String id, Person person) {
        Integer id_filtered = Integer.parseInt(person.getId());
        String query = "";

        // If there are no error
        if (!person.getSurname().equals("")) {
            query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname() + "', `middlename` = '" + person.getMiddlename() + "' WHERE `id` = " + id_filtered;
        } else {
            query = "UPDATE `person` SET `name` = '" + person.getName() + "', `surname` = '" + person.getSurname() + "' WHERE `id` = " + id_filtered;
        }

        Integer affected_rows = this.db.changeDBData(query);

        // If action is complete
        if (affected_rows > 0) {
            // Set new data to general list
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }


    /**
     * Method deletes current person
     *
     * @param id id of current person
     * @return boolean value: true - action is complete
     */
    public boolean deletePerson(String id) {
        if ((id != null) && (!id.equals("null"))) {
            int filtered_id = Integer.parseInt(id);

            Integer affected_rows = this.db.changeDBData("DELETE FROM `person` WHERE `id`=" + filtered_id);

            // If deleting is complete
            if (affected_rows > 0) {
                // Remove person from general list
                this.persons.remove(id);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Method adds new phone number to current person
     *
     * @param person current person
     * @param phone  phone number
     * @return boolean value: true - action is complete
     */
    public boolean addNumber(Person person, String phone) {
        String query = "";
        query = "INSERT INTO `phone` (`owner`, `number`) VALUES ('" + Integer.parseInt(person.getId()) + "', '" + phone + "')";
        Integer affected_rows = this.db.changeDBData(query);

        if (affected_rows > 0) {
            person.setPhones(this.db.getLastInsertId().toString(), phone);
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method update current phone number to current person
     *
     * @param person   current person
     * @param numberId id of phone number
     * @param phone    phone number
     * @return boolean value: true - action is complete
     */
    public boolean updateNumber(Person person, String numberId, String phone) {
        String query = "";
        query = "UPDATE `phone` SET `owner` = '" + person.getId() + "', `number` = '" + phone + "' WHERE `id` = " + numberId;
        Integer affected_rows = this.db.changeDBData(query);

        if (affected_rows > 0) {
            person.setPhones(numberId, phone);
            this.persons.put(person.getId(), person);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method deletes current phone number to current person
     *
     * @param id    of current person
     * @param numId if of number
     * @return boolean value: true - action is complete
     */
    public boolean deleteNumber(String id, String numId) {
        if ((id != null) && (!id.equals("null"))) {
            Integer affected_rows = this.db.changeDBData("DELETE FROM `phone` WHERE `id`=" + numId);
            if (affected_rows > 0) {
                this.persons.get(id).deleteNumber(numId);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Method returns list of existing persons
     *
     * @return list of persons
     */
    public HashMap<String, Person> getContents() {
        return persons;
    }

    /**
     * Method return person by id
     *
     * @param id id of person
     * @return person with got Id
     */
    public Person getPerson(String id) {
        return this.persons.get(id);
    }
}
