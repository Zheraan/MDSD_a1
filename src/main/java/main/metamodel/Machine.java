package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class Machine {

	private List<State> states = new ArrayList<>();
	private State initState;
	private List<Variable> variables = new ArrayList<>();

	public List<State> getStates() {
		return this.states;
	}

	public Machine setInitState(State state) {
		this.initState = state;
		return this;
	}

	public State getInitialState() {
		return this.initState;
	}

	public State getState(String string) {
		List<State> s = this.getStates();
		for (int i = 0; i < s.size(); i++) {
			if (s.get(i).getName().equals(string))
				return s.get(i);
		}
		System.out.println("Warning: this machine has no state");
		return null;
	}

	public void addState(State s) {
		this.states.add(s);
	}

	public int numberOfIntegers() {
		return this.variables.size();
	}

	public List<Variable> getVariables() {
		return this.variables;
	}

	public Variable getVariableByName(String string) {
		for (int i = 0; i < this.variables.size(); i++) {
			if (this.variables.get(i).getName().equals(string))
				return this.variables.get(i);
		}
		return null;
	}

	public State getStateByName(String string) {
		for (int i = 0; i < this.states.size(); i++) {
			if (this.states.get(i).getName().equals(string))
				return this.states.get(i);
		}
		return null;
	}

	public boolean hasInteger(String string) {
		for (int i = 0; i < this.variables.size(); i++) {
			if (this.variables.get(i).getName().equals(string))
				return true;
		}
		return false;
	}

}
