package server;

/**
 * @program: JAVA-000
 * @description: 服务端
 * @author: qpy
 */
public class NettyServer {
    public static void main(String[] args) {
        HttpServer server = new HttpServer(false,8088);
        try {
            server.run();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
