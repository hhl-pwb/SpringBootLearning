package om.atguigu.web.controller;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import om.atguigu.web.bean.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {
    /**
     * 默认使用 PathpatternParsr进行路径匹配
     *
     * @param request
     * @param path
     * @return
     */
    @GetMapping("/a*/b?/**/{p1:[a-f]+}/**")
    public String hello(HttpServletRequest request, @PathVariable("p1") String path) {
        log.info("路径变量p1:{}", path);
        String uri = request.getRequestURI();
        return uri;
    }

    /**
     * 1、SpringBoot默认支持把对象写为json。因为默认web场景导入了jackson处理json的包，jackson-core
     * 2、jackson也支持把数据写为xml，但是需要导入相关的依赖
     * @return
     */
    @GetMapping("/person")
    public Person getPerSon() {
        Person person = new Person();
        person.setId(1L);
        person.setAge(10);
        person.setUserName("张三");
        person.setEmail("123@gmail.com");
        return person;
    }
}
