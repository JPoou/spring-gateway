package com.codeaches.carinventoryservice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class InventoryController {

	@GetMapping("viewCars")
	//@PreAuthorize("hasAuthority('INVENTORY_VIEW')")
	//@PreAuthorize("hasAuthority('ROLE_USER')")
	public Set<String> viewCars() {

		return cars;
	}


	@GetMapping("viewCars2")
	//@PreAuthorize("hasAuthority('INVENTORY_VIEW')")
	@PreAuthorize("hasAuthority('ROLE_SUPERUSER')")
	public Set<String> viewCars2() {

		return cars;
	}

	@PostMapping("addCars")
	//@PreAuthorize("hasAuthority('INVENTORY_ADD')")
	@PreAuthorize("hasAuthority('USER')")
	public String addCars(@RequestBody HashMap<String, String> payload) {

		cars.addAll(payload.values());
		return payload.values() + " was added to inventory successfully";
	}

	static Set<String> cars = new HashSet<>();
	static {
		cars.add("Toyota");
		cars.add("Benz");
	}
}
