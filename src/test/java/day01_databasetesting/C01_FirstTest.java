package day01_databasetesting;

public class C01_FirstTest {

    /*Test          : Expected Result ve Actual Result un karsilastirilmasindan ibarettir
    Expected Data   : Gereksinimlere gore beklenen data
    Actual Data     : Database den cekilen asıl data     */

    public static void main(String[] args) {

        String expectedData="selenium";
        String actualData="seleniumm";

        if(expectedData.equals(actualData)){
            System.out.println("Test 1 Passed");
        }else{
            System.out.println("Test 1 Failed");
        }

        int expectedNumber=13;
        int actualNumber=13;

        if(expectedNumber==actualNumber){
            System.out.println("Test 2 Passed");
        }else{
            System.out.println("Test 2 Failed");
        }

    }
}











