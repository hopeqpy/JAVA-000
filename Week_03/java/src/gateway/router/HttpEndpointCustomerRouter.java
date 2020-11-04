package gateway.router;

import gateway.router.HttpEndpointRouter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

/**
 * @program: JAVA-000
 * @description: http 路由
 * @author: qpy
 */
@Slf4j
public class HttpEndpointCustomerRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> endpoints) {
        log.info("经过路由器");
        return endpoints.get(new Random().nextInt(endpoints.size()));
    }
}
