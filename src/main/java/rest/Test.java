package rest;

import com.fx.demo.DemoApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @GetMapping(value = "test/{x}")
    public String test(@PathVariable("x") String x) {
        return x + " ok";
    }

    @GetMapping(value = "start/{x}")
    public String start(@PathVariable("x") String x) {
        DemoApplication.runFrame(x, false);

        return "ok";
    }

}
