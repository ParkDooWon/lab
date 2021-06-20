package com.doogang.lab.team.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.doogang.lab.common.BaseTimeEntity;
import com.doogang.lab.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Entity
public class Team extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "team", orphanRemoval = true, cascade = CascadeType.PERSIST) // jpql을 쓸거면 fetch 전략이 무의미하다
	private final List<User> users = new ArrayList<>();
	@Enumerated(EnumType.STRING)
	private Campus campus;

	public boolean deleteUser(User user) {
		System.err.println(users.size());
		boolean remove = users.remove(user);
		System.err.println(users.size());

		return remove;
	}
}

