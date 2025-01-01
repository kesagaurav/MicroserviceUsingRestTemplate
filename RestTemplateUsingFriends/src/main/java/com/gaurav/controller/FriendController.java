package com.gaurav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaurav.dto.CompanyDto;
import com.gaurav.dto.EmployeeDto;
import com.gaurav.dto.FriendDto;
import com.gaurav.model.Friends;
import com.gaurav.service.FriendsService;

@RestController
public class FriendController {
	@Autowired
	private FriendsService fser;

	@PostMapping("/friend")
	public ResponseEntity<Friends> saveEmployee(@RequestBody FriendDto edto) {
		return new ResponseEntity<Friends>(fser.saveFriend(edto), HttpStatus.OK);
	}

	@GetMapping("/friends")
	public ResponseEntity<List<FriendDto>> getAllEmployee() {
		return new ResponseEntity<List<FriendDto>>(fser.getAllFriends(), HttpStatus.OK);
	}

	@GetMapping("/friend/{id}")
	public ResponseEntity<FriendDto> getById(@PathVariable int id) {
		FriendDto fdto = fser.getById(id);

		return new ResponseEntity<FriendDto>(fdto, HttpStatus.OK);

	}

	@GetMapping("/friend/phone/{phoneNo}")
	public ResponseEntity<List<Long>> getByPhoneNo(@PathVariable long phoneNo) {
		return new ResponseEntity<List<Long>>(fser.getSpecificFriend(phoneNo), HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public void delete(@PathVariable int id) {
		fser.delete(id);
	}
}
