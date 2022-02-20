package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;
import main.metamodel.Variable;

public class StateMachine {

	private Machine m = new Machine();
	private State initState;
	private State curState = null;
	private Transition curTransition = null;

	public Machine build() {
		if (this.curTransition != null) {
			this.curState.addTransition(this.curTransition);
		}
		if (this.curState != null) {
			this.m.addState(this.curState);
		}

		System.out.println(
				"Checking transition with target " + this.curTransition.getTargetName());

		System.out.println(
				"Checking transition with target " + this.curState.getTransitions().get(0).getTargetName());

		System.out.println(
				"Transitions of size " + this.m.getState("state 1").getTransitions().size());

		System.out.println(
				"Transitions of size " + this.m.getState("state 1").getName());

		System.out.println(
				"Checking transition with target " + this.m.getState("state 1").getTransitions().get(0).getTargetName());

		if (!this.m.getStates().isEmpty()) {
			for (State s : this.m.getStates()) {
				if (!s.getTransitions().isEmpty()) {
					for (Transition t : s.getTransitions()) {
						State target = m.getStateByName(t.getTargetName());
						if (target != null)
							t.setTarget(target);
						else
							System.err.println("Error: target state \"" + t.getTargetName() + "\" doesn't exist");
					}
				}
			}
		} else {
			System.out.println("Warning: this machine has no states");
		}

		if (initState != null)
			m.setInitState(initState);
		else {
			System.out.println("Warning: this machine has no initial state");
		}

		return this.m;
	}

	public StateMachine state(String string) {
		if (this.curState != null)
			this.m.addState(this.curState);
		this.curState = new State(string);

		return this;
	}

	public StateMachine initial() {
		this.initState = curState;
		return this;
	}

	public StateMachine when(String string) {
		if (this.curTransition != null)
			this.curState.addTransition(this.curTransition);
		this.curTransition = new Transition(string);

		return this;
	}

	public StateMachine to(String string) {
		this.curTransition.setTargetName(string);
		return this;
	}

	public StateMachine integer(String string) {
		this.m.getVariables().add(new Variable(string));
		return this;
	}

	public StateMachine set(String string, int i) {
		this.curTransition.setOperation("SET", string, i);
		return this;
	}

	public StateMachine increment(String string) {
		this.curTransition.setOperation("INC", string);
		return this;
	}

	public StateMachine decrement(String string) {
		this.curTransition.setOperation("DEC", string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		this.curTransition.setCondition("EQ", string, i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		this.curTransition.setCondition("GT", string, i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		this.curTransition.setCondition("LT", string, i);
		return this;
	}

}
