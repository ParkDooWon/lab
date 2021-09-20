package com.doogang.lab.team.domain;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long> {

	@Query("select distinct t from Team t left join fetch t.users")
	List<Team> findAllLeftFetchJoin();

	@Query("select distinct t from Team t  join fetch t.users")
	List<Team> findAllInnerFetchJoin();

	@EntityGraph(attributePaths = "users")
	@Query("select t from Team t")
	List<Team> findAllWithEntityGraph(); // left outer join으로 조회하는데도 결과가 아래의 distinct가 있는 메서드와 같다.

	@EntityGraph(attributePaths = "users")
	@Query("select distinct t from Team t")
	List<Team> findAllDistinctWithEntityGraph();
}
