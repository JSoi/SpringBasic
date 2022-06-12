package hello.mvc.basic.requestmapping;

import hello.mvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @GetMapping(value = {"/hello-basic", "/hello-or"})
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    @GetMapping("/mapping/{userid}")
    public String mappingPath(@PathVariable("userid") String userid) {
        //public String mappingPath(@PathVariable String userid){ 도 가능
        log.info("mappingPath userId={}", userid);
        return "ok";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    // 파라미터 조건까지 추가적으로 매핑
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    @PostMapping(value = "/mapping-basic", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsume");
        return "ok";
    }

    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
        HelloData helloData =new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);
        log.info("username: {}, age : {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username: {}, age : {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
