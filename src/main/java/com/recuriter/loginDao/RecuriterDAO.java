package com.recuriter.loginDao;

import com.recuriter.loginModel.RecuritmentLogin;

public interface RecuriterDAO {
	public void addUser(RecuritmentLogin login);

	public RecuritmentLogin updateUser(RecuritmentLogin updateUser);

	public void removeuser(RecuritmentLogin removeUser);

	public RecuritmentLogin getUserByEmail(String email);
}
