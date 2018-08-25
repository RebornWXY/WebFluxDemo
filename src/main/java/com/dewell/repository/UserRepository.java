package com.dewell.repository;

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
		return repository.put(id, user) == null;
		
	}

}
