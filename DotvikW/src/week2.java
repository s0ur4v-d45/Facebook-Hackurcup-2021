import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class week2 {
    public static void main(String[] args) throws Exception {

        Scanner sc=new Scanner(System.in);


        while(true)
        {
            System.out.println("Enter what you want to do:");
            System.out.println("press 1 for create table:");
            System.out.println("press 2 for insert in table:");
            System.out.println("press 3 for update in table:");
            System.out.println("press 4 for select from table:");
            System.out.println("press 5 for delete table");
            System.out.println("press 0 for exit:");
            int choice = sc.nextInt();

            if(choice==0)
            {
                break;
            }
            if(choice==1)
            {
                createTable();
            }
            else if(choice==2)
            {
                insert();
            }
            else if(choice==3)
            {
                updateTable();
            }
            else if(choice==4)
            {
                select();
            }
            else if(choice==5)
            {
                deletetable();
            }

        }

 

    }
    private static void deletetable() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");

        //creating a connection
        //creating a connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sourav","root","Souravdas123@");

        if(con.isClosed())
        {
            System.out.println("connection is closed....");
        }
        else
        {
            System.out.println("connection created....");
        }
        String q="drop table table1";
        Statement stmt= con.createStatement();
        stmt.executeUpdate(q);
        stmt.close();
        con.close();
        System.out.println("table deleted...\n");
    }

    private static void select() throws Exception {

        //loading a driver
        Class.forName("com.mysql.jdbc.Driver");

        //creating a connection
        //creating a connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sourav","root","Souravdas123@");

        if(con.isClosed())
        {
            System.out.println("connection is closed....\n");
        }
        else
        {
            System.out.println("connection created....\n");
        }

        String q="select * from table1";
        Statement statement=con.createStatement();
        ResultSet rs=statement.executeQuery(q);

        while(rs.next())
        {
            int id=rs.getInt(1);
            String name=rs.getString(2);
            String city=rs.getString(3);
            System.out.println(id+" "+name+" "+city);
        }
        con.close();

    }

    private static void updateTable() throws Exception
    {
        //loading a driver
        Class.forName("com.mysql.jdbc.Driver");

        //creating a connection
        //creating a connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sourav","root","Souravdas123@");

        if(con.isClosed())
        {
            System.out.println("connection is closed....\n");
        }
        else
        {
            System.out.println("connection created....\n");
        }
        String q="update table1 set tName=?,tCity=? where tId=?";
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a new name to set:");
        String name = br.readLine();
        System.out.println("Enter a new city name:");
        String city=br.readLine();
        System.out.println("Enter student id:");
        int id=Integer.parseInt(br.readLine());

        PreparedStatement preparedStatement=con.prepareStatement(q);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,city);
        preparedStatement.setInt(3,id);

        preparedStatement.executeUpdate();
        System.out.println("update done....");
        con.close();
    }

    private static void insert() throws Exception {
        //loading a driver
        Class.forName("com.mysql.jdbc.Driver");

        //creating a connection
        //creating a connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sourav","root","Souravdas123@");

        if(con.isClosed())
        {
            System.out.println("connection is closed....\n");
        }
        else
        {
            System.out.println("connection created....\n");
        }

        //dynamic query
        String q="insert into table1(tName,tCity) values (?,?)";

        //get the prepared statement object
        PreparedStatement preparedStatement= con.prepareStatement(q);

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name:");
        String name= br.readLine();
        System.out.println("Enter city name:");
        String city= br.readLine();

        //setting values to query
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,city);

        preparedStatement.executeUpdate();
        System.out.println("query has been inserted....\n");
        con.close();

    }

    private static void createTable() throws Exception {
        //loading a driver
        Class.forName("com.mysql.jdbc.Driver");

        //creating a connection
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sourav","root","Souravdas123@");

        if(con.isClosed())
        {
            System.out.println("connection is closed....\n");
        }
        else
        {
            System.out.println("connection created....\n");
        }

        //creating a query
        String q="create table table1(tId int(20) primary key auto_increment,tName varchar(200) not null,tCity varchar(400))";

        //create statement
        Statement statement=con.createStatement();
        statement.executeUpdate(q);
        System.out.println("table created in database....\n");
        con.close();

    }
}
