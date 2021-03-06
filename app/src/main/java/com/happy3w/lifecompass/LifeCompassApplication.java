package com.happy3w.lifecompass;

import com.happy3w.auditing.EnableAuditing;
import com.happy3w.i18n.MessageSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SpringBootApplication
@EnableAuditing
@Import(MessageSourceConfiguration.class)
public class LifeCompassApplication {

    @GetMapping("/api")
    public String defaultSwaggerUi() {
        return "redirect:/api/v1";
    }

    @GetMapping("/api/{version}")
    public ModelAndView swaggerUi(@PathVariable("version") String version) {
        return new ModelAndView("swagger-ui", "version", version);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(LifeCompassApplication.class, args);
    }

}
