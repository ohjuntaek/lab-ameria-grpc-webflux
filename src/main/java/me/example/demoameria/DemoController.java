package me.example.demoameria;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class DemoController {

    private final DemoService demoService;

//    public Mono<ResponseEntity<DemoModel>> getRandom() {
//        return demoService.getRandomDemoModel().map(demoModel -> {
//            if (demoModel.getArgs().get("randomNumber").equals("0")) {
//                return ResponseEntity.noContent().build();
//            } else {
//                return ResponseEntity.ok(demoModel);
//            }
//        });
//    }

    @GetMapping("/hello")
    @ResponseBody
    public Mono<String> getHello() {

        return demoService.getHello();

    }
}
