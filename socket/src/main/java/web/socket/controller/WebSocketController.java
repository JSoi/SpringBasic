package web.socket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import web.socket.dto.Greeting;
import web.socket.dto.HelloMessage;

@Controller
@Slf4j
public class WebSocketController {
//    @PostMapping("/test")
//    public String main(){
//        return "sample";
//    }
    
    @MessageMapping("/hello") //이 엔드포인트에 도달하면
    @SendTo("/topic/greetings") // 해당 주소로 메시지를 보낸다. -> subscribers listen
    public Greeting greeting(HelloMessage message) throws Exception {
        log.info("TESTSETSTSE");
        Thread.sleep(1000);
        return new Greeting("Hello, " + message + "!");
    }
}
