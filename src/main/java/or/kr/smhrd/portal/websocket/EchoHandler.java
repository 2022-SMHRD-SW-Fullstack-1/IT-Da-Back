package or.kr.smhrd.portal.websocket;

import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

public class EchoHandler extends TextWebSocketHandler {

    // 로그인중인 개별유저
    Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();

    Gson gson = new Gson();

    // 클라이언트가 서버로 연결시
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished : " + session);
        String[] uri = session.getUri().toString().split("/");
        users.put(URLDecoder.decode(uri[uri.length - 1], "UTF-8"), session);
        System.out.println("uri : " + uri);
        System.out.println("소켓연결완료 : " + users.toString());
    }

    // 알림메시지
    @Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("소켓연결완료 : " + users.toString());
        System.out.println("message.getPayload : " + message.getPayload());
		Map<String, Object> data = gson.fromJson(message.getPayload(), Map.class);

        if(data.get("mb_id_from") != null && users.containsKey(data.get("mb_id_to"))){
            System.out.println("데이터 뿌려짐");
            users.get(data.get("mb_id_to")).sendMessage(new TextMessage(message.getPayload()));
        }
        System.out.println("session : " + session);

		// Map<String, Object> data = gson.fromJson(message.getPayload(), Map.class);
		// System.out.println("handleTextMessage:" + data.toString());
		// System.out.println(data.get("talk"));
		
		// if(data.get("talker") != null && users.containsKey(data.get("sendto"))) {
		// 	System.out.println("데이터 뿌려짐");
		// 	users.get(data.get("sendto")).sendMessage(new TextMessage(message.getPayload()));
		// }
	}

  

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("소켓 닫힘 : afterConnectionClosed:" + session + ":" + status);
    }    


    // public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    //     log(session.getId() + " 익셉션 발생: " + exception.getMessage());
    // }
    // 
 
    // // 로그 메시지
    // private void log(String logmsg) {
    //     System.out.println(new Date() + " : " + logmsg);
    // }
}