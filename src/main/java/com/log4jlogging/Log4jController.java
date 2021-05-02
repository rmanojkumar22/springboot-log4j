package com.log4jlogging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class Log4jController {

    private static final Logger logger = LogManager.getLogger(Log4jController.class);

    private List<String> str = Arrays.asList("spring", "boot", "app");

    @GetMapping("/")
    public String main(Model model) {

        logger.info("Logging from Log4j 2 - num : {}", () -> str);

        model.addAttribute("tasks", str);

        return "welcome"; //view
    }

}
