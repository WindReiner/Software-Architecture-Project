package org.csu.mypetstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("help")
public class HelpController {

    @GetMapping()
    public String viewHelp()
    {
        System.out.println("Hey!!");
        return "common/Help";
    }
}
