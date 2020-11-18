package test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Component
@Slf4j
public class HariTest {
    @Autowired
    private static DataSource dataSource;

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            String sql = "insert into student values(?, ?)";
            //String sql = "select id, name FROM student";
            PreparedStatement preparedStatement=connection.prepareStatement(sql  );
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
        } catch (SQLException e) {
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
