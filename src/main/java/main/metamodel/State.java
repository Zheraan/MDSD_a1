package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {

	private String name;
	private List<Transition> transitions;

	public State(String s) {
		this.name = s;
		this.transitions = new ArrayList<>();
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

	public List<Transition> getTransitionsListByEvent(String string) {
		List<Transition> t = this.getTransitions();
		List<Transition> list = new ArrayList<>();
		for (int i = 0; i < t.size(); i++) {
			if (t.get(i).getEvent().equals(string))
				list.add(t.get(i));
		}
		return list;
	}

}
