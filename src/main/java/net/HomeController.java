package net;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping(value="/")
    public String home()
    {
        return "WEB-INF/pages/FirstPage";
    }

    @RequestMapping(value="map")
    public String johome()
    {
        return "WEB-INF/pages/SecondPage";
    }
}
