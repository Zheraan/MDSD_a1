package main;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

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
		List<Transition> l = this.machine.getState(this.curState.getName()).getTransitionsListByEvent(string);

		if (!l.isEmpty()) {
			for (Transition t : l) {

				if (t.isConditional()) {
					if (t.isConditionFilled(this.machine)) {
						if (t.hasOperation())
							this.machine.processOperation(t);
						this.curState = t.getTarget();
						return;

					} else {
						System.err
								.println("Warning: event " + string + " conditions not filled for transition");
						System.err
								.println(
										"Required var " + t.getConditionVariableName() + " to have value " + t.getConditionComparedValue());
					}

				} else {
					if (t.hasOperation())
						this.machine.processOperation(t);
					this.curState = t.getTarget();
					return;
				}
			}

		} else {
			System.err
					.println("Error: event " + string + " not associated to a transition");
		}
	}

	public int getInteger(String string) {
		return this.machine.getVariableByName(string).getValue();
	}
}
