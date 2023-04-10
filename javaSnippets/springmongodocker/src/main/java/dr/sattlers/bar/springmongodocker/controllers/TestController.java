package dr.sattlers.bar.springmongodocker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/status")
    public String getStatus() {
        return "available";
    }
}
