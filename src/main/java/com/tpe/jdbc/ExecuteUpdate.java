package com.tpe.jdbc;

import java.sql.*;

public class ExecuteUpdate {
    public static void main(String[] args) throws SQLException {

        //!!! 2.ADIM : Hangi DB , Hangi kullanici ve sifre
        Connection con  =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_dt",
                        "techprodt",
                        "password");

        //!!! 3.ADIM: statement olusturma, yazacagimiz query'leri statement nesnesi ile DB ye gonderecegiz

        Statement st = con.createStatement();
        System.out.println("success");

        // !!! update islemi oncesi kayitlarin isim ve maas bilgilerini ekrana basalim
        System.out.println("---------------- UPDATE ONCESI ---------------------");
        ResultSet rs = st.executeQuery("SELECT * FROM developers");
        while (rs.next()){
            System.out.println(rs.getString("name") + "--------" + rs.getDouble("salary"));
        }

        //!!!  ÖRNEK1:developers tablosunda maaşı, ortalama maaştan az olanların maaşını ortalama maaş ile güncelleyiniz

        String sql1 =
                "UPDATE developers SET salary=(SELECT AVG(salary) FROM developers) WHERE salary<(SELECT AVG(salary) FROM developers)";
        int updated = st.executeUpdate(sql1);
        System.out.println("Guncellenen kayit sayisi : " + updated);

        // !!! update islemi sonrasi kayitlarin isim ve maas bilgilerini ekrana basalim
        System.out.println("---------------- UPDATE SONRASI ---------------------");
        ResultSet rs2 = st.executeQuery("SELECT * FROM developers");
        while (rs2.next()){
            System.out.println(rs2.getString("name") + "--------" + rs2.getDouble("salary"));
        }

        st.close();
        con.close();
    }
}