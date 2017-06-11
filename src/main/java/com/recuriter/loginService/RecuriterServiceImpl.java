package com.recuriter.loginService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.recuriter.loginDao.RecuriterDAO;
import com.recuriter.loginModel.RecuritmentLogin;

@Service
@Transactional
public class RecuriterServiceImpl implements RecuriterService {

	private RecuriterDAO recuriterDAO;

	public void setRecuriterDAO(RecuriterDAO recuriterDAO) {
		this.recuriterDAO = recuriterDAO;
	}

	@Override
	@Transactional
	public void addUser(RecuritmentLogin login) {
		// TODO Auto-generated method stub
		recuriterDAO.addUser(login);

	}

	@Override
	@Transactional
	public RecuritmentLogin updateUser(RecuritmentLogin updateUser) {
		// TODO Auto-generated method stub
		return recuriterDAO.updateUser(updateUser);
	}

	@Override
	@Transactional
	public void removeuser(RecuritmentLogin removeUser) {
		// TODO Auto-generated method stub
		recuriterDAO.removeuser(removeUser);
	}

	@Override
	@Transactional
	public RecuritmentLogin getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return recuriterDAO.getUserByEmail(email);
	}

}
