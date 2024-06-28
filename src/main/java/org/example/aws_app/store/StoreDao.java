package org.example.aws_app.store;

import java.util.ArrayList;

import org.example.aws_app.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDao extends JpaRepository<Store, String> {
	//점주로 매장 검색
	Store findBySid(Member m);
	ArrayList<Store> findByOpen(boolean open);
}
