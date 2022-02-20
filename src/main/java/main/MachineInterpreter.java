package main;

import java.io.Console;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {

	private State curState;
	private Machine machine;

	public void run(Machine m) {
		this.curState = m.getInitialState();
		this.machine = m;
	}

	public State getCurrentState() {
		return this.curState;
	}

	public void processEvent(String string) {
		Transition t = this.machine.getState(this.curState.getName()).getTransitionByEvent(string);

		if (t != null) {
			if (t.hasOperation()) {
				if (t.hasDecrementOperation())
					machine.getVariableByName(t.getOperationVariableName()).decrement();
				if (t.hasIncrementOperation())
					machine.getVariableByName(t.getOperationVariableName()).increment();
				if (t.hasSetOperation())
					machine.getVariableByName(t.getOperationVariableName()).setValue(t.getOperationValue());
			}

			this.curState = t.getTarget();
		} else {
			System.err.println("Error: event " + string + " not associated to a transition");
		}
	}

	public int getInteger(String string) {
		return this.machine.getVariableByName(string).getValue();
	}

}
