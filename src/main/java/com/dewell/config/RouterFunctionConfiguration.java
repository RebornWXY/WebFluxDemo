/**
 * 
 */
package com.dewell.config;

import java.util.Collection;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.dewell.entity.User;
import com.dewell.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author reborn
 * @createDate 创建时间：2018年8月26日 下午6:25:46
 * @description 类说明：路由函数 配置
 *
 */
@Configuration
public class RouterFunctionConfiguration {
	/**
	 * Servlet
	 * 请求接口：ServletRequest 或者 HttpServletRequest
	 * 响应接口：ServletResponse 或者 HttpServletResponse
	 * 
	 * Spring5.0重新定义服务器请求和响应接口
	 * 请求接口：ServerRequest
	 * 响应接口：ServerResponse
	 * 即可支持Servlet规范，也可支持自定义，比如Netty（Web Server）
	 * 
	 * 本例：
	 * 定义 GET 请求，并且返回所有用户对象 URI：/person/find/all
	 * Flux 是 0-N 个对象集合
	 * Mono 是0-1 个对象集合
	 * Reactive 中的 Flux 或者 Mono 他是异步处理（非阻塞）
	 * 集合对象基本上是同步处理（阻塞）
	 * Flux 或者 Mono 都是 publisher
	 */
	@Bean
	@Autowired
	public RouterFunction<ServerResponse> personFiandAll(UserRepository userRepository){
		
//		RequestPredicate predicate;
//		HandlerFunction handlerFunction;
		return RouterFunctions.route(RequestPredicates.GET("/person/find/all"), 
				request ->{
							// Mono<ServerResponse> response = null;
							// 返回所有的用户对象
							Collection<User> users = userRepository.findAll();
							Flux<User> userFlux = Flux.fromIterable(users);
							// Publisher userFlux;
							return ServerResponse.ok().body(userFlux, User.class);
							// return ServerResponse.ok().body(null);
						});
	}
}
