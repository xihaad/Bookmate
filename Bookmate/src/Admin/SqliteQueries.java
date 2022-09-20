package Admin;

import java.sql.*;

 public class SqliteQueries {
    Connection connection;
    public SqliteQueries()
    {
        connection = Admin.SQliteConnection.connector();
        if(connection==null) System.exit(1);
    }
    public boolean isDbConnected()
    {
        try {
            return !connection.isClosed();
        }
        catch (SQLException e)
        {
            return false;
        }
    }
    public boolean LoginNow(String user,String pass) throws SQLException
    {
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String query="SELECT * FROM admin WHERE username = ? and password = ?";
        try
        {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user);
            preparedStatement.setString(2,pass);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                return true;
            }
            else {
                return false;
            }

        }catch (Exception e)
        {
            return false;
        }
        finally {
            preparedStatement.close();
            resultSet.close();
        }
    }
    public boolean SignupNow(String name, String username, String password)
    {
        PreparedStatement preparedStatement=null;
        String insert="INSERT INTO admin(name,username,password) VALUES(?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(insert);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,username);
            preparedStatement.setString(3,password);
            preparedStatement.execute();
            return true;

        }catch (Exception e)
        {

            System.out.println();
        }

        return false;
    }

     public ResultSet SearchData() throws SQLException
     {
         PreparedStatement preparedStatement=null;
         ResultSet resultSet=null;
         String query="SELECT * FROM book";
         try
         {
             preparedStatement = connection.prepareStatement(query);
//             preparedStatement.setString(1,name);
             resultSet = preparedStatement.executeQuery();
//             if(resultSet.next())
//             {
//                 return resultSet;
//             }
//             else {
//                 return null;
//             }
             System.out.println("query executed resultset");

             System.out.println(resultSet);
             String st = resultSet.getString("name");
             System.out.println(st);
//             while (resultSet.next()) {
//                 String s = resultSet.getString("name");
//                 String n = resultSet.getString("description");
//                 System.out.println(s + "   " + n);
//             }
             return resultSet;

         }catch (Exception e)
         {
             return null;
         }
         finally {
             preparedStatement.close();
             resultSet.close();
         }
     }


     public boolean AddBook(String bookname, String author, String genre, String description)
     {
         PreparedStatement preparedStatement=null;
         String insert="INSERT INTO book(name,author,genre, description) VALUES(?,?,?,?)";
         try {
             preparedStatement=connection.prepareStatement(insert);
             preparedStatement.setString(1,bookname);
             preparedStatement.setString(2,author);
             preparedStatement.setString(3,genre);
             preparedStatement.setString(4,description);
//             preparedStatement.setString(5,pdflink);
             preparedStatement.execute();
             return true;

         }catch (Exception e)
         {

             System.out.println();
         }

         return false;
     }


 }
