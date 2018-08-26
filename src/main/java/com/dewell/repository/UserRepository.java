package com.dewell.repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.dewell.entity.User;

/**
 * @author Reborn.Wang
 * @createDate 创建时间：2018年8月23日 下午5:28:13
 * @Description 类描述:User用户仓储 {@link User}} {@link Repository}}
 */
@Repository
public class UserRepository {

	/**
	 * 采用内存模型的存储方式 ——>Map
	 */
	private final ConcurrentHashMap<Integer, User> repository = new ConcurrentHashMap<>();
	private static final AtomicInteger idGenerator = new AtomicInteger();

	
	/**
	 * 
	 * @param user {@link User}} 对象
	 * @return 如果保存成功 返回<code>true<code> 否则返回<code>false<code>
	 */
	public boolean save(User user) {
		int id = idGenerator.incrementAndGet();
		user.setId(id);
		
		// 测试ConcurrentHashMap集合中存取key相同，值不同 返回值该key的上一次存储值 没有返回null
//		User user2 = new User();
//		user2.setId(4);
//		user2.setName("REBORN2");
//		User put = repository.put(4, user2);
//		System.out.printf("用户对象：%S 保存成功！", user2);
//		System.out.println();
		
		return repository.put(id, user) == null;
	}
	
	/**
	 * 返回所有用户列表
	 * @return
	 */
	public Collection<User> findAll(){
		return repository.values();
	}
}
