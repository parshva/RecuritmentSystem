package com.recuriter.loginDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.recuriter.loginModel.RecuritmentLogin;

@Repository
public class RecuriterDAOImpl implements RecuriterDAO {

	private static final Logger logger = LoggerFactory.getLogger(RecuriterDAO.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addUser(RecuritmentLogin login) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(login);
		logger.info("Username and Password Saved Successfully" + login.getEmail());
	}

	@Override
	public RecuritmentLogin updateUser(RecuritmentLogin updateUser) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(updateUser);
		logger.info("Username and Password updated Successfully" + updateUser.getEmail());
		return updateUser;
	}

	@Override
	public void removeuser(RecuritmentLogin removeUser) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		RecuritmentLogin p = (RecuritmentLogin) session.get(RecuritmentLogin.class, new String(removeUser.getEmail()));
		if (p != null) {
			session.delete(p);
		}
		logger.info("Username deleted succesfully" + removeUser.getEmail());
	}

	@Override
	public RecuritmentLogin getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		RecuritmentLogin login = (RecuritmentLogin) session.get(RecuritmentLogin.class, new String(email));
		return login;
	}

}
