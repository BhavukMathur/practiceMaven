package target2024.designPattern.factory;

public class TransitionActionFactory {
	public TransitionAction getTransition(String type) {
		if(type.equals("UPGRADE")) {
			return new UpgradeAction();
		}
		if(type.equals("DOWNGRADE")) {
			return new DowngradeAction();
		}
		throw new RuntimeException("UNSUPPORTED");
	}
}
