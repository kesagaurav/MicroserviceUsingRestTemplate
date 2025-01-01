package com.gaurav.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.dto.EmployeeDto;
import com.gaurav.dto.FriendDto;
import com.gaurav.model.Employee;
import com.gaurav.model.Friends;
import com.gaurav.repository.FriendsRep;

@Service
public class FriendsService {
	@Autowired
	private FriendsRep erep;

	public Friends saveFriend(FriendDto fdto) {
		Friends f = fdto.toFriendDto();
		Friends f2 = erep.save(f);

		return f2;

	}

	public List<FriendDto> getAllFriends() {
		List<Friends> fList = erep.findAll();
		List<FriendDto> ftList = fList.stream().map(a -> FriendDto.toEmployeeEntity(a)).collect(Collectors.toList());
		return ftList;
	}

	public FriendDto getById(int id) {
		Optional<Friends> f = erep.findById(id);
		FriendDto fdto = null;
		if (f.isPresent()) {
			fdto = FriendDto.toEmployeeEntity(f.get());

		}
		return fdto;
	}

	public void delete(int id) {
		erep.deleteById(id);
	}
	
	public List<Long> getSpecificFriend(Long phoneNo){
		List<Long> friendList=new ArrayList<>();
		List<Friends> friends=erep.getByPhoneNo(phoneNo);
		for(Friends friend:friends) {
			friendList.add(friend.getPhoneNo());
		}
		
		return friendList;
	}
}
