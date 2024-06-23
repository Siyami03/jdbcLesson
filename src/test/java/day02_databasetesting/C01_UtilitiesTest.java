package day02_databasetesting;

import Utilities.JdbcLocalDBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C01_UtilitiesTest {


//Connect to database
//Query city names with a population of more than 3 million from the 'cities' table
//Verify given city names "Istanbul", "Ankara", "Izmir"


    @Test
    public void test() throws SQLException {

        //  veritabanına bağlan
        // JdbcLocalDBUtils.connectToDatabase();
        // JdbcLocalDBUtils.createStatement();

        // 'cities' tablosundan nufusu 3 milyondan fazla olan sehir isimleri sorgula
        String sql = "select city_name from cities where population >3000000";
        ResultSet resultSet = JdbcLocalDBUtils.executeQuery(sql);

        // verilen sehir isimlerini doğrula "Istanbul", "Ankara", "Izmir"
        List<String> actualData = new ArrayList<>();
        while (resultSet.next()){

            String cityName = resultSet.getString("city_name");
            actualData.add(cityName);
        }

        List<String> expectedData = List.of("Istanbul", "Ankara", "Izmir");
        Assert.assertEquals(expectedData,actualData);

        JdbcLocalDBUtils.closeConnection();

    }
}