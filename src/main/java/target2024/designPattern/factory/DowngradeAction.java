package target2024.designPattern.factory;

public class DowngradeAction implements TransitionAction {
	@Override
	public void execute() {
		System.out.println("Downgrading the plan..");
	}
}
