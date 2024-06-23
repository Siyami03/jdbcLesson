package day02_databasetesting;

import Utilities.JdbcLocalDBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_CityTest {

// connect to database
// Get the license plate codes of cities with a population of less than 700 000 from the 'cities' table
// verify that the number of results from the database is 4
// Verify that the results from the database include license plate codes 58 and 43
// close the connection



    @Test
    public void test() throws SQLException {

        // veritabanına bağlan
        // 'cities' table'dan nüfusu 700 000 den az olan sehirlerin plaka kodlarini al
        ResultSet resultSet = JdbcLocalDBUtils.executeQuery("select plate_code from cities where population < 700000");

        // databaseden gelen sonuc sayisinin 4 oldugunu doğrula
        List<Integer> actualData = new ArrayList<>();

        while (resultSet.next()){
            actualData.add(resultSet.getInt("plate_code"));
        }
        Assert.assertEquals(4,actualData.size());


        // databaseden gelen sonuclarin 58 ve 43 plaka kodlarini icerdigini doğrula
        List<Integer> expectedData = Arrays.asList(58,43);
        Assert.assertTrue(actualData.containsAll(expectedData));

        // bağlantıyı kapat
        JdbcLocalDBUtils.closeConnection();
    }
}