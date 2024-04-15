package om.atguigu.web.config;

import om.atguigu.web.biz.UserBizHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class WebFunctionConfig {
    /**
     * 函数式Web
     * 1、给容器中放一个Bean：类型是RouteFunction<ServerResponse>,集中所有路由信息
     * 2、每个业务准备一个自己的Handler
     * 核心四大对象
     * 1、RouteFunction:定义路由信息。发什么请求，谁来处理
     * 2、RequestPredicate:定义请求规则。请求谓语。请求方式（GET POST）、请求参数等
     * 3、ServerRequest:封装请求完整数据
     * 4、ServerResponse:封装响应完整数据
     */
    @Bean
    public RouterFunction<ServerResponse> userRoute(UserBizHandler userBizHandler){
        return RouterFunctions.route()
                .GET("/user/{id}", RequestPredicates.accept(MediaType.ALL),userBizHandler::getUser)
                .GET("/users",userBizHandler::getUsers)
                .POST("/user",RequestPredicates.accept(MediaType.APPLICATION_JSON),userBizHandler::saveUser)
                .PUT("/user/{id}",RequestPredicates.accept(MediaType.APPLICATION_JSON),userBizHandler::updataUser)
                .DELETE("/user/{id}",userBizHandler::deleteUser)
                .build();
    }
}
