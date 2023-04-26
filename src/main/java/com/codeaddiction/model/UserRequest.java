package com.codeaddiction.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserRequest {
	private Integer id;
	private String name;
	private String password;
	private String email;
	private List<String> roles;
}
