package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {

	private String name;
	private List<Transition> transitions = new ArrayList<>();

	public State(String s) {
		this.name = s;
	}

	public String getName() {
		return this.name;
	}

	public List<Transition> getTransitions() {
		return this.transitions;
	}

	public void addTransition(Transition t) {
		this.transitions.add(t);
	}

	public Transition getTransitionByEvent(String string) {
		List<Transition> t = this.getTransitions();
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).getEvent().equals(string))
				return t.get(i);
		}
		return null;
	}

}
