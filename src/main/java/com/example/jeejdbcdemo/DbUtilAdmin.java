package com.example.jeejdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtilAdmin extends DBUtil {

    private String URL;
    private String name;
    private String password;

    public DbUtilAdmin(String URL) {
        this.URL = URL;
    }

    @Override
    List<Place> getPlaces() throws Exception {

        List<Place> places = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // polaczenie z BD
            conn = DriverManager.getConnection(URL, name, password);

            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Places");

            while (resultSet.next()) {

                places.add(new Place(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("descrip")
                ));

            }

        } finally {
            close(conn, statement, resultSet);
        }

        return places;
    }


    public void addPlace(Place place) throws Exception {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(URL, name, password);
            String sql = "INSERT INTO Places(name,address,descrip) " +
                    "VALUES(?,?,?)";

            statement = conn.prepareStatement(sql);
            statement.setString(1, place.getName());
            statement.setString(2, place.getAddress());
            statement.setString(3, place.getDescrip());

            statement.execute();


        } finally {
            close(conn, statement, null);
        }

    }

    public Place getPlace(String id) throws Exception{

        Place place = null;
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            int placeID = Integer.parseInt(id);
            conn = DriverManager.getConnection(URL, name, password);
            statement = conn.prepareStatement("SELECT * FROM Places WHERE id=?");
            statement.setInt(1,placeID);

            resultSet = statement.executeQuery();

            if(resultSet.next()){

                place = new Place(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("descrip")
                );

            } else{
                throw new Exception("Nie ma takiego id " + placeID);
            }

            return  place;


        } finally {
            close(conn,statement,resultSet);

        }
    }

    public void updatePlace(Place place) throws Exception{

        Connection conn = null;
        PreparedStatement statement = null;

        try{
            conn = DriverManager.getConnection(URL, name, password);

            String sql = "UPDATE Places SET name=?, address=?, descrip=? WHERE id=?";

            statement = conn.prepareStatement(sql);
            statement.setString(1, place.getName());
            statement.setString(2, place.getAddress());
            statement.setString(3, place.getDescrip());
            statement.setString(4, String.valueOf(place.getId()));

            statement.execute();

        } finally {
            close(conn,statement,null);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void deletePlace(String id) throws Exception{

        Connection conn = null;
        PreparedStatement statement = null;

        try{

            int placeID = Integer.parseInt(id);

            conn = DriverManager.getConnection(URL, name, password);

            String sql = "DELETE FROM Places WHERE id=?";

            statement = conn.prepareStatement(sql);
            statement.setInt(1, placeID);


            statement.execute();

        } finally {
            close(conn,statement,null);
        }




    }


}
