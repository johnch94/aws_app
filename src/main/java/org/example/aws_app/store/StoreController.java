package org.example.aws_app.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.example.aws_app.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth/store")
public class StoreController {
	@Autowired
	private StoreService service;

	@PostMapping("")
	public Map add(StoreDto dto) {// 매장id, 점주id, 주소, false
		boolean flag = true;
		try {
			service.save(dto); // 한줄 추가
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}

	@PutMapping("/{storeid}")
	public Map open(@PathVariable("storeid") String storeid) {// 매장id => open을 true로 변경
		StoreDto dto = service.getStore(storeid);
		dto.setOpen(true);
		boolean flag = true;
		try {
			service.save(dto); // open을 true로 변경
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}

	@GetMapping("/list")
	public Map list() {
		Map map = new HashMap();
		map.put("list", service.getAll());
		return map;
	}

	@GetMapping("/{storeid}")
	public Map get(@PathVariable("storeid") String storeid) {
		Map map = new HashMap();
		map.put("s", service.getStore(storeid));
		return map;
	}

	@GetMapping("/sid/{sid}")
	public Map getbysid(@PathVariable("sid") String sid) {
		Map map = new HashMap();
		map.put("s", service.getStoreBySeller(new Member(sid, "", "", "", "")));
		return map;
	}

	@ResponseBody
	@GetMapping("/ajax/{sid}")
	public Map getbysida(@PathVariable("sid") String sid) {
		// 매장등록상태: 1.store없다 2.open(false) 3.open(true)
		StoreDto dto = service.getStoreBySeller(new Member(sid, "", "", "", ""));
		int state = 1; // 없다
		if (dto != null) {
			if (dto.isOpen()) {
				state = 3;
			} else {
				state = 2;
			}
		}
		Map map = new HashMap();
		map.put("state", state);
		return map;
	}

	@DeleteMapping("/{storeid}")
	public Map del(@PathVariable("storeid") String storeid) {
		boolean flag = true;
		try {
			service.delStore(storeid);
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		Map map = new HashMap();
		map.put("flag", flag);
		return map;
	}

	@ResponseBody
	@GetMapping("/listajax")
	public Map listajax() {
		ArrayList<StoreDto> list = service.getByOpen(true);
		Map map = new HashMap();
		map.put("list", list);
		return map;
	}
}
