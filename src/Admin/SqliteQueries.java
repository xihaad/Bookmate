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

     public ResultSet SearchData(String name) throws SQLException
     {
         PreparedStatement preparedStatement=null;
         ResultSet resultSet=null;
         String query="SELECT * FROM book WHERE name = ?";
         try
         {
             preparedStatement = connection.prepareStatement(query);
             preparedStatement.setString(1,name);
             resultSet = preparedStatement.executeQuery();
             if(resultSet.next())
             {
                 return resultSet;
             }
             else {
                 return null;
             }

         }catch (Exception e)
         {
             return null;
         }
         finally {
             preparedStatement.close();
             resultSet.close();
         }
     }

}
