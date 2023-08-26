package com.fakestoreapi.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;


public class LeerExcel {

    public String[] obtenerDatosExcel() {
        String archivoExcel = "src/main/resources/Data/DataUser.xlsx";
        String Endpoint = null;
        String Email = null;
        String Username = null;
        String Password = null;
        String Firstname = null;
        String Lastname = null;
        String CodeStatus = null;
        String Phone = null;
        String Id = null;

        try {
            FileInputStream file1 = new FileInputStream(new File(archivoExcel));
            XSSFWorkbook libro1 = new XSSFWorkbook(file1);
            XSSFSheet hoja = libro1.getSheet("InfoUser");
            Row fila;
            Cell celda;

            fila = hoja.getRow(1);
            celda = fila.getCell(0);
            Endpoint = celda.toString();
            celda = fila.getCell(1);
            Email = celda.toString();
            celda = fila.getCell(2);
            Username = celda.toString();
            celda = fila.getCell(3);
            Password = celda.toString();
            celda = fila.getCell(4);
            Firstname = celda.toString();
            celda = fila.getCell(5);
            Lastname = celda.toString();
            celda = fila.getCell(6);
            CodeStatus = celda.toString();
            celda = fila.getCell(7);
            Phone = celda.toString();
            celda = fila.getCell(8);
            Id = celda.toString();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String InfoUser[] = {Endpoint,Email,Username,Password,Firstname,Lastname,CodeStatus,Phone,Id};
        return InfoUser;
    }

}
