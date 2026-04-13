package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tree {
	private Integer nodeId;
	private String nodeName;
	private Integer parentId;
	private Integer level;
}
