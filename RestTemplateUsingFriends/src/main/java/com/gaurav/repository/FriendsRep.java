package com.gaurav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.model.Friends;

@Repository
public interface FriendsRep extends JpaRepository<Friends, Integer> {

	List<Friends> getByPhoneNo(Long phoneNo);

}
