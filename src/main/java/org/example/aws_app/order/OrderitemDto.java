package org.example.aws_app.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.aws_app.cafe.Cafeprod;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderitemDto {
	private int num;
	private Cafeprod prod;
	private int amount;
	private Cafeorder parent;
}
