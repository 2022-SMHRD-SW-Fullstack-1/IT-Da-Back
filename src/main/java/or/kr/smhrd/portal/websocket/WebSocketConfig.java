package or.kr.smhrd.portal.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	//해당 uri로 websocket연결이 들어오면 replyechohandler 클래스에서 관련 로직을 처리하게됨.
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new EchoHandler(), "/replyEcho/{mb_id}").setAllowedOrigins("*")
		.addInterceptors(new HttpSessionHandshakeInterceptor());
	}
	
}  
