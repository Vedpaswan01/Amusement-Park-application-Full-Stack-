package com.FunXtreme.controller;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.services.ActivityService;
import com.FunXtreme.services.CustomerService;

@RestController
public class ActivityController {

	@Autowired
	ActivityService activityService;

	@Autowired
	private CustomerService customerService;

	@PostMapping("/insertActivity")
	public ResponseEntity<Activity> createCustomer(@RequestBody Activity act) throws ActivityException, LoginException {

		Activity a = activityService.insertActivity(act);

		return new ResponseEntity<Activity>(a, HttpStatus.CREATED);

	}

	@PutMapping("/updateActivity")
	public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity) throws ActivityException, LoginException {

		Activity a = activityService.updateActivity(activity);

		return new ResponseEntity<Activity>(a, HttpStatus.OK);

	}

	@DeleteMapping("/deleteActivity")
	public ResponseEntity<Activity> deleteActivity(int activityid) throws ActivityException, LoginException {

		Activity a = activityService.deleteActivity(activityid);

		return new ResponseEntity<Activity>(a, HttpStatus.OK);

	}

	@GetMapping("/viewActivityofCharges")
	public ResponseEntity<List<Activity>> viewActivityofCharges(float charges) throws ActivityException, LoginException {

		List<Activity> aList = activityService.viewActivityofCharges(charges);

		return new ResponseEntity<List<Activity>>(aList, HttpStatus.OK);

	}

	@GetMapping("/countActivityOfCharges")
	public ResponseEntity<Integer> countActivityofCharges(float charges) throws ActivityException, LoginException {

		int aCount = activityService.countActivityofCharges(charges);

		return new ResponseEntity<Integer>(aCount, HttpStatus.OK);

	}

}
