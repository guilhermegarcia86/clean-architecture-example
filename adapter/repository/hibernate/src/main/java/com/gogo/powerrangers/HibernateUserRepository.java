package com.gogo.powerrangers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.gogo.powerrangers.entity.User;
import com.gogo.powerrangers.entity.UserEntity;
import com.gogo.powerrangers.usecase.port.UserRepository;

public class HibernateUserRepository implements UserRepository{
	
	private EntityManagerFactory emf = null;
	
	public HibernateUserRepository() {
		emf = Persistence.createEntityManagerFactory("jpa-h2");
	}

	@Override
	public User create(User user) {
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		
		UserEntity entity = new UserEntity();
		entity.setId(UUID.randomUUID().toString());
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setAge(user.getAge());
		entity.setPersonality(user.getPersonality().getPersonality());
		entity.setRanger(user.getRanger());
		
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		
		return user;
	}

	@Override
	public Optional<User> findByEmail(String email) {
		EntityManager entityManager = emf.createEntityManager();
		
		//@formatter:off
		TypedQuery<UserEntity> query = entityManager.createQuery(new StringBuilder()
				.append("SELECT user ")
				.append("	FROM UserEntity user ")
				.append(" WHERE user.email = :email").toString(), UserEntity.class);
		// @formatter:on
		
		try {
			UserEntity userEntity = query.setParameter("email", email).getSingleResult();
			
			return Optional.of(UserEntity.toUser(userEntity));			
		} catch (NoResultException e) {
			return Optional.empty();
		}
	}

	@Override
	public Optional<List<User>> findAllUsers() {
		EntityManager entityManager = emf.createEntityManager();
		
		List<UserEntity> userEntityList = entityManager.createQuery("SELECT user FROM UserEntity user", UserEntity.class).getResultList();
		
		List<User> userList = userEntityList.stream().map(UserEntity::toUser).collect(Collectors.toList());

        return Optional.of(userList);
	}
	
}