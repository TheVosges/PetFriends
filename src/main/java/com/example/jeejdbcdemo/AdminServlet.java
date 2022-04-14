package com.example.jeejdbcdemo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {

    private DbUtilAdmin dbUtil;
    private final String url = "jdbc:mysql://localhost:3306/pet_friends?useSSL=false&allowPublicKeyRetrieval=true&" +
            "serverTimezone=CET";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            dbUtil = new DbUtilAdmin(url);
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String command = request.getParameter("command");

            if (command == null)
                command = "LIST";

            switch (command) {
                case "LIST":
                    listPlace(request, response);
                    break;
                case "ADD":
                    addPlace(request, response);
                    break;
                case "LOAD":
                    loadPlace(request, response);
                    break;
                case "UPDATE":
                    updatePlace(request, response);
                    break;
                case "DELETE":
                    deletePlace(request, response);
                    break;
                default:
                    listPlace(request, response);

            }

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String name = request.getParameter("loginInput");
        String password = request.getParameter("passwordInput");

        dbUtil.setName(name);
        dbUtil.setPassword(password);

        if (validate(name, password)) {

            RequestDispatcher dispatcher = request.getRequestDispatcher
                    ("/admin_view.jsp");
            List<Place> placeList = null;

            try {
                placeList = dbUtil.getPlaces();
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("PLACES_LIST", placeList);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index3.html");
            dispatcher.include(request, response);
        }

    }

    private boolean validate(String name, String pass) {

        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, name, pass);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    private void listPlace(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Place> placeList = dbUtil.getPlaces();
        request.setAttribute("PLACES_LIST", placeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_view.jsp");
        dispatcher.forward(request, response);

    }

    private void addPlace(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String name = request.getParameter("nameInput");
        String address = request.getParameter("addressInput");
        String descrip = request.getParameter("descripInput");

        Place place = new Place(name, address, descrip);
        dbUtil.addPlace(place);

        listPlace(request, response);

    }

    private void loadPlace(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String id = request.getParameter("placeID");
        Place place = dbUtil.getPlace(id);

        request.setAttribute("PLACE",place);

        RequestDispatcher dispatcher = request.getRequestDispatcher
                ("/update_place_form.jsp");
        dispatcher.forward(request,response);

    }

    private void updatePlace(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        int id = Integer.parseInt(request.getParameter("placeID"));

        String name = request.getParameter("nameInput");
        String address = request.getParameter("addressInput");
        String descrip = request.getParameter("descripInput");

        Place place = new Place(id,name,address,descrip);
        dbUtil.updatePlace(place);


        listPlace(request,response);


    }

    private void deletePlace(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String id = request.getParameter("placeID");
        dbUtil.deletePlace(id);
        listPlace(request,response);

    }
}
