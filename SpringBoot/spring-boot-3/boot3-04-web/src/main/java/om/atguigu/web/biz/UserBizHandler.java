package om.atguigu.web.biz;

import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import om.atguigu.web.bean.Person;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class UserBizHandler {
    public ServerResponse getUser(ServerRequest request) {
        String id = String.valueOf(request.param("id"));
        log.info("获取编号为【{}】用户的信息", id);
        Person person = new Person(1L, "admin", "123@qq.com", 18);
        return ServerResponse.ok().body(person);
    }
    public ServerResponse getUsers(ServerRequest request) {
        log.info("获取所有用户的信息");
        List<Person> list = Arrays.asList(new Person(1L, "admin", "123@qq.com", 18)
                , new Person(2L, "admin2", "2123@qq.com", 12));
        return ServerResponse.ok().body(list);
    }
    public ServerResponse saveUser(ServerRequest request) throws ServletException, IOException {
        Person person = request.body(Person.class);
        log.info("用户信息插入成功【{}】",person);
        return ServerResponse.ok().build();
    }
    public ServerResponse updataUser(ServerRequest request) {
        String id = String.valueOf(request.param("id"));
        log.info("更新编号为【{}】用户的信息", id);
        return ServerResponse.ok().build();
    }
    public ServerResponse deleteUser(ServerRequest request) {
        String id = String.valueOf(request.param("id"));
        log.info("删除编号为【{}】用户的信息", id);
        return ServerResponse.ok().build();
    }
}
