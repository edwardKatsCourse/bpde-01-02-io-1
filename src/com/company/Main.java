package com.company;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        //Поток (Input/Output Stream)

        //java.io

        //OutputStream

        //InputStream

        URL url = new URL("https://google.com");

        InputStream inputStream = url.openStream();
//                new FileInputStream(
//                new File("C:\\Users\\Edward\\Desktop\\BPDE-01-02 IO 1\\file.txt"));

        readByteByByte(inputStream);

//        readToByteArray(inputStream);



        //int read()
        //byte (-128 .. 127) -> int (0 .. 255)

        //if read() returns "broken byte" (-1) - there is nothing left to read

    }

    public static void readByteByByte(InputStream inputStream) throws IOException {
        OutputStream outputStream = new ByteArrayOutputStream();
        while (true) {

            int actualByte = inputStream.read();
            System.out.println(actualByte);
            if (actualByte == -1) {
                break;
            }

            outputStream.write(actualByte);
        }
        byte [] data = ((ByteArrayOutputStream) outputStream).toByteArray();
        String print = new String(data);
        System.out.println(print);
    }



    public static void readToByteArray(InputStream inputStream) throws IOException {
        //0 - 32MB (audio), 32MB - 48MB (video), 48MB - 64MB
        byte [] data = new byte[1000 * 64]; // -> 64 MB

        //[0,1,2,3,4,5,6,7,8,9]
        //           offset
        while (true) {

            int byteCount = inputStream.read(data);
            System.out.println(byteCount);

            if (byteCount == -1) {
                break;
            }
        }


        System.out.println(new String(data));
    }
}
