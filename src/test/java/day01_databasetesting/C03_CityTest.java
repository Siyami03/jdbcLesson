package day01_databasetesting;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class C03_CityTest {
    /* connect to the database get city names from the 'cities' table verify that there are at least 10 city names in
       the city_name column close the connection    */
    /* Database e baglan, cities tablosundan sehir isimlerini al, city_name sutununda en az 10 tane city_name olduğunu
       dogrula ve Baglantiyi kapat*/

    @Test
    public void test01() throws SQLException {

        //Database e baglan
        String url ="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        //cities tablosundan sehir isimlerini al
        String sql ="select city_name from cities";
        ResultSet resultSet = statement.executeQuery(sql);

        //city_name sutununda en az 10 tane city_name olduğunu dogrula
        int counter=0;
        while (resultSet.next()){
            counter++;
        }
        Assert.assertTrue(counter>9);

        //Baglantiyi kapat
        statement.close();
        connection.close();
    }

    @Test
    public void secondWay() throws SQLException {

        //Database e baglan
        String url ="jdbc:postgresql://localhost:5432/myDatabase";
        String user="tester";
        String password="tester";
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        //cities tablosundan sehir isimlerinin sayisini al
        //city_name sutununda  10 tane city_name olduğunu dogrulayin
        ResultSet resultSet = statement.executeQuery("select count(city_name) from cities");

        resultSet.next();
        int actualResult = resultSet.getInt("count");
        Assert.assertEquals(10, actualResult);

        //Baglantiyi kapat
        statement.close();
        connection.close();

    }
}
























