package org.example.aws_app.order;

import java.util.ArrayList;

import org.example.aws_app.order.Cafeorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.aws_app.member.Member;
import org.example.aws_app.store.Store;

@Repository
public interface CafeorderDao extends JpaRepository<Cafeorder, Integer> {
	ArrayList<Cafeorder> findByOid(Member oid);
	ArrayList<Cafeorder> findByOstateAndStore(int ostate, Store store);
}
