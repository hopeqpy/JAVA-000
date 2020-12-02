package insert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

/**
 * @program: JAVA-000
 * @description: 测试插入
 * @author: qpy
 */
public class InsertDemo {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName( Constant.DRIVER_CLASS );
            connection = DriverManager.getConnection( Constant.URL, Constant.USERNAME, Constant.PASSWORD );
            connection.setAutoCommit( false );
            String sql = "INSERT INTO d_user (`id`, `name`, `sex`, `nick_name`, `birthday`, " +
                    "`nation`,`create_time`,`modify_time`,`address`) VALUES (?,?,?,?,?,?,?,?,?)";
            ps = connection.prepareStatement( sql );
            long start = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                long l = System.nanoTime();
                ps.setLong( 1, l );
                ps.setString( 2, "姓名" + l );
                ps.setInt( 3, new Random().nextInt( 1 ) );
                ps.setString( 4, "倪晨" + l );
                ps.setDate( 5, new Date( System.currentTimeMillis() ) );
                ps.setInt( 6, 1 );
                ps.setDate( 7, new Date( System.currentTimeMillis() ) );
                ps.setDate( 8, new Date( System.currentTimeMillis() ) );
                ps.setString( 9, "测试" );
            }
            ps.executeBatch();
            connection.commit();
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

