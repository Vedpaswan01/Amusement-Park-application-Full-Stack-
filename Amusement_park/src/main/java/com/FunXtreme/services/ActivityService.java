package com.FunXtreme.services;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.model.Activity;


public interface ActivityService {

	public Activity insertActivity(Activity activity) throws ActivityException, LoginException;

	public Activity updateActivity(Activity activity) throws ActivityException, LoginException;

	public Activity deleteActivity(int activityid) throws ActivityException, LoginException;

	public int countActivityofCharges(float charges) throws ActivityException, LoginException;

	public List<Activity> viewActivityofCharges(float charges) throws ActivityException, LoginException;

}
