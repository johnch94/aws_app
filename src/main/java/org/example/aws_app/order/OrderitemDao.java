package org.example.aws_app.order;

import java.util.ArrayList;

import org.example.aws_app.order.Cafeorder;
import org.example.aws_app.order.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderitemDao extends JpaRepository<Orderitem, Integer> {
	ArrayList<Orderitem> findByParent(Cafeorder order);
}
