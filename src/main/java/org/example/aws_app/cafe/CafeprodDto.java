package org.example.aws_app.cafe;

import org.springframework.web.multipart.MultipartFile;

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
public class CafeprodDto {
	private int num;
	private String name;
	private int price;
	private Store store;
	private String fname;
	private MultipartFile f;
}
