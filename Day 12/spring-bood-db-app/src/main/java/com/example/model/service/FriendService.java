package com.example.model.service;

import com.example.model.beans.Friend;

public interface FriendService {
	// since Friend table must have profileIdRef we will pass profile id while adding a friend
	public Friend addFriend(int profileIdRef, Friend friend);

	Friend deleteFriend(int pid, int fid) throws FriendNotFoundException;
}