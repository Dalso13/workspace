package org.joonzis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String name,dept;
	private int gradeNo,classNo;
	
	
}
