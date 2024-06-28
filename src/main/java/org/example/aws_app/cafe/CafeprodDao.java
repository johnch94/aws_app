package org.example.aws_app.cafe;

import java.util.ArrayList;
import org.example.aws_app.store.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeprodDao extends JpaRepository<Cafeprod, Integer> {
	ArrayList<Cafeprod> findByStore(Store store);
}
