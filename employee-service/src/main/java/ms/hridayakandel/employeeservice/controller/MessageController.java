package ms.hridayakandel.employeeservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("config/refresh")
public class MessageController {
    @Value("${spring.boot.message}")
    private String message;
    @GetMapping
    public String getMessage(){
        return message;
    }

}