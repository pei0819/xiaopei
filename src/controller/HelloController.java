package controller;  
  
import service.UserService;
import model.User;

import com.jfinal.core.Controller;  
  
public class HelloController extends Controller {  
  
    UserService userService = new UserService();  
      
    public void index()  
    {  
        String name = getPara("name");  
        String password = getPara("password");  
        User user = new User();  
        user = null;  
          
        user = userService.findUser(name, password);  
          
        if(user != null)  
            render("/html/hello.html");  
        /*哈哈哈...GitHub提交成功了*/
        /*哈哈哈...GitHub再次提交了*/
        /*哈哈哈...GitHub第三次提交*/
    }  
}  
