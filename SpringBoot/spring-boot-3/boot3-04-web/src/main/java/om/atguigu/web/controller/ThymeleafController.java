package om.atguigu.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //适配 服务端渲染 前后不分离模式
public class ThymeleafController {
    // 利用模板引擎跳转到指定页面
    @GetMapping("/well")
    public String wellcome(@RequestParam("name") String name, Model model){
        // 模板的逻辑视图名
        // 物理视图 = 前缀 + 逻辑视图名 + 后置
        //真实地址 = classpath:/templates/wellcome.html
//        model.addAttribute("msg",name);
        String msg = "<span style='color:red'>"+"李四"+"</span>";
        model.addAttribute("msg",msg);
        //路径是动态的
        model.addAttribute("imgUrl","3.jpg");
        return "wellcome";
    }
}
