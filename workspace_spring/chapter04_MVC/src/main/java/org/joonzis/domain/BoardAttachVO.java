package org.joonzis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardAttachVO {
	private String uuid;
	private String uploadPath;
	private String fileName;
	private long bno;
}
