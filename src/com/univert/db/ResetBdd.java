package com.univert.db;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.io.IOUtils;

//import commons-io.*;



import test.TestDB;

public class ResetBdd {

    final static String NomBase = "jdbc:mariadb://localhost/univert2";	    
	
    public static boolean resetDatabase(InputStream inputStream) throws SQLException {
        String s            = new String();
        StringBuffer sb = new StringBuffer();
        Statement st = DbManagement.getInstance().getStatement();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
 
            while((s = br.readLine()) != null) {
                sb.append(s);
            }
            br.close();
            String[] inst = sb.toString().split(";");
 
            for(int i = 0; i<inst.length; i++) {
                if(!inst[i].trim().equals("")) {
                    st.executeUpdate(inst[i]);
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
