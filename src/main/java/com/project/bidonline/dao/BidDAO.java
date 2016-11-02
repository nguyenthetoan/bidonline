package com.project.bidonline.dao;

import java.util.List;

import com.project.bidonline.entity.Bid;

public interface BidDAO {
	public void saveBid(Bid bid);
	public List<Bid> getAllBid();
}
