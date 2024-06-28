package org.example.aws_app.store;

import org.example.aws_app.member.Member;
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
public class StoreDto {
	private String storeid;
	private Member sid;
	private String address;
	private boolean open;//매장 오픈 유무
}
