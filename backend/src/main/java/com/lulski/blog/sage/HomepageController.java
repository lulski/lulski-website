package com.lulski.blog.sage;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * blablba.
 */
@Controller
public class HomepageController {

  @RequestMapping("/greeting")
  public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
                         Model model) {
    model.addAttribute("name", name);

    return "index";
  }

}
