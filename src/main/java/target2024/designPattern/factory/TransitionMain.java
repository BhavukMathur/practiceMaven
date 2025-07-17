package target2024.designPattern.factory;

public class TransitionMain {
	public static void main(String[] args) {
		TransitionActionFactory factory = new TransitionActionFactory();
		TransitionAction transitionAction = factory.getTransition("UPGRADE");
		transitionAction.execute();
	}
}
