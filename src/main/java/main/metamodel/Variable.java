package main.metamodel;

public class Variable {
	private String name;
	private Integer value = 0;

	public Variable(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void increment() {
		this.value += 1;
	}

	public void decrement() {
		this.value -= 1;
	}
}
