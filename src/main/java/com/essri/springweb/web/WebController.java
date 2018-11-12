package com.essri.springweb.web;

import com.essri.springweb.webservice.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts",postsService.findAllDesc());
        // handlebars 때문에 자동으로 지정됨. (prefix: src/main/resources/templates, suffix: .hbs)
        return "main";
    }
}
