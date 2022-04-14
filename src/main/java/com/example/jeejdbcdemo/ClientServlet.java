package com.example.jeejdbcdemo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/ClientServlet")
public class ClientServlet extends HttpServlet {

    private DataSource dataSource;
    private DbUtilClient dbUtil;

    public ClientServlet() throws NamingException {

        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        dataSource = (DataSource) envCtx.lookup("jdbc/phones_web_app");
    }

    @Override
    public void init() throws ServletException {
        super.init();

        try{
            dbUtil = new DbUtilClient(dataSource);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void listPlaces(HttpServletRequest request, HttpServletResponse
                            response) throws Exception{

        List<Place> placeList = dbUtil.getPlaces();
        request.setAttribute("PLACES_LIST", placeList);

        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/client_view.jsp");
        dispatcher.forward(request,response);



    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        try{
            listPlaces(request,response);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
