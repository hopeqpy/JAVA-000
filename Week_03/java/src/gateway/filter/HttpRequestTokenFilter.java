package gateway.filter;


import gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: JAVA-000
 * @description: http 过滤
 * @author: qpy
 */
@Slf4j
public class HttpRequestTokenFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) throws Exception {
        HttpHeaders headers = fullRequest.headers();
        headers.set( "gateway", "token" );
        String uri = fullRequest.uri();
        log.info( uri );
    }
}
