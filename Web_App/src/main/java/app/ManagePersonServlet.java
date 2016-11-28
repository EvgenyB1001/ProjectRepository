package app;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class interacts with server and performs actions post and get
 */
public class ManagePersonServlet extends HttpServlet {

    /**
     * Identifier dor serialize/deserialize
     */
    private static final long serialVersionUID = 1L;

    /**
     * General object, that contains phonebook data
     */
    private Phonebook phonebook;

    public ManagePersonServlet() {
        super();
        try {
            this.phonebook = Phonebook.getInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates name, surname and middlename and generates error info in case of invalid data
     *
     * @param person current person
     * @return error info
     */
    private String validatePersonFMLName(Person person) {
        String error_message = "";

        if (!person.validateFMLNamePart(person.getName(), false)) {
            error_message += "Имя должно быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }

        if (!person.validateFMLNamePart(person.getSurname(), false)) {
            error_message += "Фамилия должна быть строкой от 1 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }

        if (!person.validateFMLNamePart(person.getMiddlename(), true)) {
            error_message += "Отчество должно быть строкой от 0 до 150 символов из букв, цифр, знаков подчёркивания и знаков минус.<br />";
        }

        return error_message;
    }

    /**
     * Method validates phone number and generates error in case of invalid data
     *
     * @param number phone number
     * @param person current person
     * @return error info
     */
    private String validateNumber(String number, Person person) {
        String error_message = "";

        if (!person.validatePhoneNumber(number)) {
            error_message += "Номер должен быть строкой от 2 до 50 символов из цифр, знаков #, -, +.<br />";
        }
        return error_message;
    }

    /**
     * Method, that provide react for GET-requests
     *
     * @param request  request of server
     * @param response response of server
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        HashMap<String, String> jsp_parameters = new HashMap<String, String>();

        // Dispatchers for several JSP
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_managerNumber = request.getRequestDispatcher("/ManageNumber.jsp");

        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String numberID = request.getParameter("numberId");

        // If action, id and numberId are not initialized, then just show list of persons
        if ((action == null) && (id == null) && (numberID == null)) {
            request.setAttribute("jsp_parameters", jsp_parameters);
            dispatcher_for_list.forward(request, response);
        } else {
            switch (action) {
                // Add new person
                case "add":
                    Person empty_person = new Person();
                    // Sets JSP psrameters
                    jsp_parameters.put("current_action", "add");
                    jsp_parameters.put("next_action", "add_go");
                    jsp_parameters.put("next_action_label", "Добавить");

                    //Sets request attributes
                    request.setAttribute("person", empty_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    dispatcher_for_manager.forward(request, response);
                    break;

                // Edit person
                case "edit":
                    Person editable_person = this.phonebook.getPerson(id);
                    jsp_parameters.put("current_action", "edit");
                    jsp_parameters.put("next_action", "edit_go");
                    jsp_parameters.put("next_action_label", "Сохранить");
                    request.setAttribute("person", editable_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    dispatcher_for_manager.forward(request, response);
                    break;

                // Delete person
                case "delete":
                    if (phonebook.deletePerson(id)) {
                        jsp_parameters.put("current_action_result", "DELETION_SUCCESS");
                        jsp_parameters.put("current_action_result_label", "Удаление выполнено успешно");
                    } else {
                        jsp_parameters.put("current_action_result", "DELETION_FAILURE");
                        jsp_parameters.put("current_action_result_label", "Ошибка удаления (возможно, запись не найдена)");
                    }
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    dispatcher_for_list.forward(request, response);
                    break;
                // Add new phone number
                case "addNumber":
                    Person person = this.phonebook.getPerson(id);
                    jsp_parameters.put("current_action", "addNumber");
                    jsp_parameters.put("next_action", "addNumber_go");
                    jsp_parameters.put("next_action_label", "Добавить номер");
                    request.setAttribute("person", person);
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    dispatcher_for_managerNumber.forward(request, response);
                    break;
                // Edit phone number
                case "editNumber":
                    Person editable_number_person = this.phonebook.getPerson(id);
                    jsp_parameters.put("current_action", "editNumber");
                    jsp_parameters.put("next_action", "editNumber_go");
                    jsp_parameters.put("next_action_label", "Сохранить номер");
                    request.setAttribute("person", editable_number_person);
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    request.setAttribute("numberId", numberID);
                    dispatcher_for_managerNumber.forward(request, response);
                    break;
                // Delete phone number
                case "deleteNumber":
                    if (phonebook.deleteNumber(id, numberID)) {
                        jsp_parameters.put("current_action_result", "DELETION_SUCCESS");
                        jsp_parameters.put("current_action_result_label", "Удаление выполнено успешно");
                    } else {
                        jsp_parameters.put("current_action_result", "DELETION_FAILURE");
                        jsp_parameters.put("current_action_result_label", "Ошибка удаления (возможно, запись не найдена)");
                    }
                    request.setAttribute("jsp_parameters", jsp_parameters);
                    dispatcher_for_list.forward(request, response);
                    break;
            }
        }

    }

    /**
     * Method provides actions on Post-requests
     *
     * @param request  request of server
     * @param response response of server
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        HashMap<String, String> jsp_parameters = new HashMap<String, String>();

        // Sets dispatchers for JSP
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_managerNumber = request.getRequestDispatcher("/ManageNumber.jsp");

        String add_go = request.getParameter("add_go");
        String edit_go = request.getParameter("edit_go");
        String addNumber_go = request.getParameter("addNumber_go");
        String editNumber_go = request.getParameter("editNumber_go");
        String id = request.getParameter("id");

        // Add person
        if (add_go != null) {
            Person new_person = new Person(request.getParameter("name"), request.getParameter("surname"), request.getParameter("middlename"));
            String error_message = this.validatePersonFMLName(new_person);

            // If data of person is correct
            if (error_message.equals("")) {
                // If adding is complete
                if (this.phonebook.addPerson(new_person)) {
                    jsp_parameters.put("current_action_result", "ADDITION_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Добавление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "ADDITION_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка добавления");
                }
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_list.forward(request, response);
            } else {
                jsp_parameters.put("current_action", "add");
                jsp_parameters.put("next_action", "add_go");
                jsp_parameters.put("next_action_label", "Добавить");
                jsp_parameters.put("error_message", error_message);
                request.setAttribute("person", new_person);
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_manager.forward(request, response);
            }
        }

        // Edit person
        if (edit_go != null) {
            Person updatable_person = this.phonebook.getPerson(request.getParameter("id"));
            updatable_person.setName(request.getParameter("name"));
            updatable_person.setSurname(request.getParameter("surname"));
            updatable_person.setMiddlename(request.getParameter("middlename"));
            String error_message = this.validatePersonFMLName(updatable_person);

            // If data is correct
            if (error_message.equals("")) {
                // If adding is complete
                if (this.phonebook.updatePerson(id, updatable_person)) {
                    jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка обновления");
                }
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_list.forward(request, response);
            } else {
                jsp_parameters.put("current_action", "edit");
                jsp_parameters.put("next_action", "edit_go");
                jsp_parameters.put("next_action_label", "Сохранить");
                jsp_parameters.put("error_message", error_message);
                request.setAttribute("person", updatable_person);
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_manager.forward(request, response);

            }
        }
        // Add new number
        if (addNumber_go != null) {
            Person add_number_person = this.phonebook.getPerson(request.getParameter("id"));
            String error_message = this.validateNumber(request.getParameter("phone"), add_number_person);
            // if data is correct
            if (error_message.equals("")) {
                // If adding is complete
                if (this.phonebook.addNumber(add_number_person, request.getParameter("phone"))) {
                    jsp_parameters.put("current_action_result", "ADDITION_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Добавление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "ADDITION_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка добавления");
                }
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_list.forward(request, response);
            } else {
                jsp_parameters.put("current_action", "addNumber");
                jsp_parameters.put("next_action", "addNumber_go");
                jsp_parameters.put("next_action_label", "Добавить");
                jsp_parameters.put("error_message", error_message);

                request.setAttribute("person", add_number_person);
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_managerNumber.forward(request, response);
            }
        }

        // Edit phone number
        if (editNumber_go != null) {
            Person updatableNumber_person = this.phonebook.getPerson(request.getParameter("id"));
            String error_message = this.validateNumber(request.getParameter("phone"), updatableNumber_person);
            String numberID = request.getParameter("numberId");

            // If data is correct
            if (error_message.equals("")) {
                // If adding is complete
                if (this.phonebook.updateNumber(updatableNumber_person, numberID, request.getParameter("phone"))) {
                    jsp_parameters.put("current_action_result", "UPDATE_SUCCESS");
                    jsp_parameters.put("current_action_result_label", "Обновление выполнено успешно");
                } else {
                    jsp_parameters.put("current_action_result", "UPDATE_FAILURE");
                    jsp_parameters.put("current_action_result_label", "Ошибка обновления");
                }
                request.setAttribute("jsp_parameters", jsp_parameters);
                dispatcher_for_list.forward(request, response);
            } else {
                jsp_parameters.put("current_action", "editNumber");
                jsp_parameters.put("next_action", "editNumber_go");
                jsp_parameters.put("next_action_label", "Сохранить");
                jsp_parameters.put("error_message", error_message);

                request.setAttribute("person", updatableNumber_person);
                request.setAttribute("jsp_parameters", jsp_parameters);

                dispatcher_for_managerNumber.forward(request, response);
            }
        }
    }
}

