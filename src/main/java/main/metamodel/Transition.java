package main.metamodel;

public class Transition {

	private String event;
	private State target;
	private String targetName;
	private String operation = "NO";
	private String condition = "NO";
	private String opVar;
	private String condVar;
	private int compVal;
	private int opVal;

	public Transition(String string) {
		this.event = string;
	}

	public Object getEvent() {
		return this.event;
	}

	public State getTarget() {
		return this.target;
	}

	public String getTargetName() {
		return this.targetName;
	}

	public Transition setTarget(State s) {
		this.target = s;
		return this;
	}

	public Transition setTargetName(String s) {
		this.targetName = s;
		return this;
	}

	public boolean hasSetOperation() {
		if (this.operation.equalsIgnoreCase("SET"))
			return true;
		return false;
	}

	public boolean hasIncrementOperation() {
		if (this.operation.equalsIgnoreCase("INC"))
			return true;
		return false;
	}

	public boolean hasDecrementOperation() {
		if (this.operation.equalsIgnoreCase("DEC"))
			return true;
		return false;
	}

	public String getOperationVariableName() {
		return this.opVar;
	}

	public boolean isConditional() {
		if (!this.condition.equalsIgnoreCase("NO"))
			return true;
		return false;
	}

	public String getConditionVariableName() {
		return this.condVar;
	}

	public Integer getConditionComparedValue() {
		return this.compVal;
	}

	public boolean isConditionEqual() {
		if (this.condition.equalsIgnoreCase("EQ"))
			return true;
		return false;
	}

	public boolean isConditionGreaterThan() {
		if (this.condition.equalsIgnoreCase("GT"))
			return true;
		return false;
	}

	public boolean isConditionLessThan() {
		if (this.condition.equalsIgnoreCase("LT"))
			return true;
		return false;
	}

	public boolean hasOperation() {
		if (!this.operation.equalsIgnoreCase("NO"))
			return true;
		return false;
	}

	public void setOperation(String operation, String variable) {
		this.opVar = variable;
		this.operation = operation;
	}

	public void setOperation(String operation, String variable, int value) {
		this.opVar = variable;
		this.opVal = value;
		this.operation = operation;
	}

	public void setCondition(String condition, String variable, int value) {
		this.condition = condition;
		this.condVar = variable;
		this.compVal = value;
	}

	public int getOperationValue() {
		return this.opVal;
	}

	public boolean isConditionFilled(Machine m) {
		if (this.isConditionEqual()
				&& (this.getConditionComparedValue() == m.getVariableByName(this.getConditionVariableName()).getValue())) {
			return true;
		}
		if (this.isConditionGreaterThan()
				&& (this.getConditionComparedValue() < m.getVariableByName(this.getConditionVariableName()).getValue())) {
			return true;
		}
		if (this.isConditionLessThan()
				&& (this.getConditionComparedValue() > m.getVariableByName(this.getConditionVariableName()).getValue())) {
			return true;
		}

		return false;
	}
}
