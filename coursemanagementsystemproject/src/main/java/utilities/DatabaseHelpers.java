package utilities;

import datamodels.StudentModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelpers {

    private String url = "jdbc:sqlserver://LAPTOP-B6LV7JN4\\SQLEXPRESS;databaseName=CourseManagementSystem.Models.SchoolContext;integratedSecurity=true";


    public void clearPersonTableForStudent(){

        try {

            Connection con = DriverManager.getConnection(url);

            if (con != null){
                System.out.println("DB connected Successfully");
            }

            String queryString = "Delete from Person";
            Statement sqlStatement = con.createStatement();
            sqlStatement.executeUpdate(queryString);

        }catch (Exception e){
          e.printStackTrace();
        }
    }

    public List<StudentModel> FetchDataFromPersonTable(){
        List<StudentModel> stddata = new ArrayList<StudentModel>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url);
            if (con != null){
                System.out.println("DB connected Successfully");
            }

            String queryString = "select * from person";
            Statement sqlStatement = con.createStatement();
            ResultSet sqlResult = sqlStatement.executeQuery(queryString);

            while (sqlResult.next()){

                 StudentModel student = new StudentModel();
                 student.setFirstname(sqlResult.getString(3));
                 student.setLastname(sqlResult.getString(2));
                 student.setDiscriminator(sqlResult.getString(8));

                 System.out.println(student.getFirstName());

                 stddata.add(student);
            };


        }catch (Exception ex){
            ex.getMessage();
        }

        return stddata;
    }


}
