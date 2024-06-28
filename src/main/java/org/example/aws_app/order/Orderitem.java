package org.example.aws_app.order;

import org.example.aws_app.cafe.Cafeprod;
import org.example.aws_app.order.Cafeorder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Orderitem {
	@Id
	@SequenceGenerator(name = "seq_gen", sequenceName = "seq_orderitem", allocationSize = 1) // 시퀀스 생성
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_orderitem")
	private int num;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cafeprod prod;
	private int amount;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cafeorder parent;
}
