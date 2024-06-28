package org.example.aws_app.order;

import java.util.ArrayList;
import java.util.Date;

import org.example.aws_app.member.Member;
import org.example.aws_app.store.Store;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CafeorderDto {
	private int num;
	private Member oid;
	private Date odate;
	private int payment;
	private int ostate;
	private Store store;
	ArrayList<OrderitemDto> items;
}
