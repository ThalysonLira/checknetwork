package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.User;

public class UserRepository extends Repository<User> {

    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public User findUser(String email, String password) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT COUNT(*) ");
		jpql.append("FROM UserSystem u ");
		jpql.append("WHERE u.email = ? ");
		jpql.append("AND u.password = ? ");
        
		Query query = getEntityManager().createQuery(jpql.toString());
        query.setParameter(1, email);
        query.setParameter(2, password);

        return (User) query.getSingleResult();
	}

    public List<User> findByEmail(String email) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT u ");
		jpql.append("FROM UserSystem u ");
		jpql.append("WHERE upper(u.email) ");
		jpql.append("LIKE upper(:email) ");

		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("email", "%" + email + "%");

		return query.getResultList();
	}
	
	public boolean contains(Integer id, String email) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT COUNT(*) ");
		jpql.append("FROM UserSystem u ");
		jpql.append("WHERE upper(u.email) = ? ");
		jpql.append("AND u.id <> ? ");
		
		Query query = getEntityManager().createNativeQuery(jpql.toString());
		query.setParameter(1, email);
		query.setParameter(2, id == null ? -1 : id);
		
		return (long) query.getSingleResult() == 0 ? false : true;
	}

}