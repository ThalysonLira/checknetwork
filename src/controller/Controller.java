package controller;

import factory.JPAFactory;
import model.DefaultEntity;
import model.User;
import repository.Repository;

public class Controller<T extends DefaultEntity<? super T>> {

	private static User user = null;

	public T save(T entity) {
		Repository<T> repository = new Repository<T>(JPAFactory.getEntityManager());

		repository.getEntityManager().getTransaction().begin();
		entity = repository.save(entity);
		repository.getEntityManager().getTransaction().commit();
		repository.getEntityManager().close();

		return entity;
	}

	public void remove(T entity) {
		Repository<T> repository = new Repository<T>(JPAFactory.getEntityManager());

		repository.getEntityManager().getTransaction().begin();
		repository.remove(entity);
		repository.getEntityManager().getTransaction().commit();
		repository.getEntityManager().close();
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Controller.user = user;
	}

}