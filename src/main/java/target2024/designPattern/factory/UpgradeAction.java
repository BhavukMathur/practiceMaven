package target2024.designPattern.factory;

public class UpgradeAction implements TransitionAction {
	@Override
	public void execute() {
		System.out.println("Upgrading the plan..");
	}
}
