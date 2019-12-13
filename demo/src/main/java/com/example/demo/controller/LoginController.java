import com.example.demo.repository.UserAccountRepository;
import com.example.demo.entity.UserAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"login/index.htaml","/login","login/"})
public class LoginController {
    @Autowired
    UserAccountRepository userAccountRepository;    

    @GetMapping
    public ModelAndView ReturnView(@ModelAttribute("UserAccount") UserAccount account, ModelAndView model) {
        model.addObject("UserAccount", account);
        model.setViewName("login/index.html");
        return model;
    }
}