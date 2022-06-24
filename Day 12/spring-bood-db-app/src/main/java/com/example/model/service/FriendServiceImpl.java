package com.example.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.beans.Friend;
import com.example.model.dao.FriendRepository;

import antlr.collections.List;
@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendRepository friendDao;
	
	@Override
	@Transactional
	public Friend addFriend(int profileIdRef, Friend friend) {
		// to make it simple we will not enter profile id that doesn't exist in the Profile
		friend.setProfileIdRef(profileIdRef);
		return friendDao.save(friend);
	}
	@Override
	public Friend deleteFriend(int pid, int fid) throws FriendNotFoundException {
		List<Friend> friends = friendDao.getFriendsFromProfile(pid);
		Friend friend = null;
		for(Friend f: friends) {
			if(f.getId() == fid) {
				friend = f;
				friendDao.delete(friend);
			}
		}
		throw new FriendNotFoundException("Friend id" +id+ "not found");
		return friend;
	}

}