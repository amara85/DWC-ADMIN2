package com.ensat.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DimtempsRepositoryImpl implements DimtempsRepositoryCustom {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Integer> returnDistinctAnnee() {
		
		List<Integer>  list = new ArrayList<Integer>();

		List<Map<String, Object>> rows = jdbcTemplate
				.queryForList("SELECT distinct annee as annee FROM dim_temps order by annee desc");

		for (Map<String, Object> row : rows) {
			BigDecimal bd = (BigDecimal) row.get("annee");
			Integer annee = bd.intValueExact();
			list.add(annee);
			//System.out.println(annee);
		}
		return list;
	}

}
