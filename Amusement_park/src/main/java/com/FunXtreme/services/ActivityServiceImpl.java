package com.FunXtreme.services;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityRepository activityRepository;

	@Override
	public Activity insertActivity(Activity activity) throws ActivityException, LoginException {
		// TODO Auto-generated method stub
		Activity a = activityRepository.save(activity);

		return a;
	}

	@Override
	public Activity updateActivity(Activity activity) throws ActivityException, LoginException {
		// TODO Auto-generated method stub
		Optional<Activity> optionalActivity = activityRepository.findById(activity.getActivityId());

		if (optionalActivity.isPresent()) {
			Activity existingActivity = optionalActivity.get();

			existingActivity.setDescription(activity.getDescription());
			existingActivity.setCharge(activity.getCharge());

			return activityRepository.save(existingActivity);

		} else {

			throw new ActivityException("No activity with this Id");
		}

	}

	@Override
	public Activity deleteActivity(int activityid) throws ActivityException, LoginException {

		Optional<Activity> a = activityRepository.findById(activityid);

		if (a.isPresent()) {
			Activity act = a.get();

			activityRepository.delete(act);

			return act;
		} else {

			throw new ActivityException("No activity with this id");
		}

	}

	@Override
	public List<Activity> viewActivityofCharges(float charges) throws ActivityException, LoginException {

		List<Activity> act = activityRepository.findByCharge(charges);

		if (act.isEmpty()) {

			throw new ActivityException("No activity List Database");
		} else {

			return act;
		}

	}

	@Override
	public int countActivityofCharges(float charges) throws ActivityException, LoginException {
		// TODO Auto-generated method stub
		List<Activity> act = activityRepository.findByCharge(charges);

		if (act.isEmpty()) {

			throw new ActivityException("No activity List Database");
		} else {

			return act.size();
		}
	}

}
