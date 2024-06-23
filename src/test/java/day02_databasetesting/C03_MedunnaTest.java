package day02_databasetesting;

import Utilities.JdbcMedunnaDBUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class C03_MedunnaTest {

    @Test
    public void medunnaDBtest() throws SQLException {


        //    Kullanıcı veritabanına bağlanır
        //    (Host name: medunna.com, Database name: medunna_db_v2, Username: select_user, Password: Medunna_pass_@6)
        //    Kullanıcı, oluşturulan odayı getirmek için room_number ile sorgu gönderir
        //    Kullanıcı, oda bilgilerinin doğru kaydedildiğini doğrular
        //    Kullanıcı, bağlantıyı kapatır


        //1) Expected Datalar duzenlenir
        String expectedRoomType ="TWIN";
        boolean expectedStatus=true;
        String expectedDescription="Batch 230 Database testi icin olusturuldu";


        //2) Database den gerekli query ile datalar cekilir
        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery("select * from room where room_number = 33669912");
        resultSet.next();

        //3) Actual Datalar duzenlenir
        String actualRoomType = resultSet.getString("room_type");
        boolean actualStatus = resultSet.getBoolean("status");
        String actualDescription= resultSet.getString("description");


        //4) Assertionlar yapilir
        Assert.assertEquals(expectedRoomType,actualRoomType);
        Assert.assertEquals(expectedStatus,actualStatus);
        Assert.assertEquals(expectedDescription,actualDescription);

    }

    @Test
    public void medunnaDBtest2() throws SQLException {

        ResultSet resultSet = JdbcMedunnaDBUtils.executeQuery("select * from room where room_number = 33669912");
        resultSet.next();

        Assert.assertEquals("TWIN",resultSet.getString("room_type"));
        Assert.assertEquals(true,resultSet.getBoolean("status"));
        Assert.assertEquals("Batch 230 Database testi icin olusturuldu",resultSet.getString("description"));

    }




}