package com.recuriter.loginService;

import com.recuriter.loginModel.RecuritmentLogin;

public interface RecuriterService {
	public void addUser(RecuritmentLogin login);

	public RecuritmentLogin updateUser(RecuritmentLogin updateUser);

	public void removeuser(RecuritmentLogin removeUser);

	public RecuritmentLogin getUserByEmail(String email);
}
