package com.tpe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //!!! 1.ADIM : Driver'i ekleme
        Class.forName("org.postgresql.Driver"); // JDK 7 ile birlikte gerek kalmadi

        //!!! 2.ADIM : Hangi DB , Hangi kullanici ve sifre
        Connection con  =
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_dt","techprodt","password");

        //!!! 3.ADIM: statement olusturma, yazacagimiz query'leri statement nesnesi ile DB ye gonderecegiz

        Statement st = con.createStatement();
        System.out.println("success");

        //!!! 4.ADIM: sorgulari olusturma

        //ÖRNEK 1:"workers" adında bir tablo oluşturup "worker_id,worker_name,salary" sütunlarını ekleyiniz.
        boolean sql1 =
        st.execute("CREATE TABLE IF NOT EXISTS workers(worker_id INT,worker_name VARCHAR(50),salary REAL)");
        System.out.println("sql1 : " + sql1);

        /*  execute:tüm sorguları çalıştırmak için kullanılır
            sorgunun sonucunda ResultSet alınıyorsa TRUE döndürür, aksi halde FALSE döndürür.
            1-DDL (Data Definition Language) -->FALSE ( Create gibi sorgular )
            2-DQL (Data Query Language) -->TRUE (Select gibi sorgular )
            2-DML (Data Manipulation Language) --> FALSE ( update, insert gibi sorgular )
            genellikle DDL için kullanılır.     */

        //ORNEK 2 : "workers" tablosuna VARCHAR(20) tipinde "city" sutununu ekleyelim
        //st.execute("ALTER TABLE workers ADD COLUMN city VARCHAR(20)");
        
        //ORNEK 3 : "workers" tablosunu silelim     //Ornek 2'yi comment'e almamız gerekiyor
        st.execute("DROP TABLE workers");

        //!!! 5.ADIM: kaynaklari kapatiyoruz
        st.close();
        con.close();
    }
}