package com.example.jeejdbcdemo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtilClient extends DBUtil {

    private DataSource dataSource;

    public DbUtilClient(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    List<Place> getPlaces() throws Exception {

        List<Place> places = new ArrayList<>();

        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // polaczenie z BD
            conn = dataSource.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Places");
            while(resultSet.next()){

                places.add(new Place(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("descrip")
                ));

            }

        } finally {
            close(conn,statement,resultSet);
        }

        return places;
    }
}
