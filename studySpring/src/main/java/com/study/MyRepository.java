package com.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Goods> methodA() {
		jdbcTemplate.update("update goods set price = price + 1 where id = ?", "A01");	
		String sql = "SELECT * FROM goods where id like ?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, "%1");

		List<Goods> list = new ArrayList<>();

		for (Map<String, Object> a : result) { // 拡張for文を使用している
			Goods goods = new Goods();
			goods.setId((String) a.get("id"));
			goods.setName((String) a.get("name"));
			goods.setPrice((int) a.get("price"));
			list.add(goods);
		}
		return list;
	}
}
