package com.essri.springweb.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    @GetMapping("/")
    public String main() {
        // handlebars 때문에 자동으로 지정됨. (prefix: src/main/resources/templates, suffix: .hbs)
        return "main";
    }
}
