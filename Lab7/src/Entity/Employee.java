package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int id;
	private String name;
	private double salary;
	@Override
	public String toString() {
		return String.format(" %-5s | %-20s | %-13.0f", id, name, salary);
	}
}
