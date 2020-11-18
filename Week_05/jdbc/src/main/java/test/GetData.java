package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Slf4j
public class GetData {


    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class<?> mysql = Class.forName( "org.mysql.Driver" );
            String url = "jdbc:postgresql://localhost:3306/learn";
            connection = DriverManager.getConnection(url,"root","123456");
            String sql = "insert into student values(?, ?)";
            //String sql = "select id, name FROM student";
            PreparedStatement  preparedStatement=connection.prepareStatement(sql  );
            preparedStatement.setInt( 1,1 );
            preparedStatement.setString( 2,"qpy" );
            int i = preparedStatement.executeUpdate( sql );
            log.info( "影响的行数："+i );
            /* while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                log.info( "id:"+id +"/n");
                log.info( name );
            }*/
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }  finally {
            try{
                if(connection!=null) {
                    connection.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
