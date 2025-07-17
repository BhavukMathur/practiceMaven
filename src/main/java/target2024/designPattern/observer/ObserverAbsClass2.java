package target2024.designPattern.observer;

public class ObserverAbsClass2 extends ObserverAbsClass {
	SubjectClass subjectClass;

	ObserverAbsClass2(SubjectClass subjectClass) {
		this.subjectClass = subjectClass;
		this.subjectClass.attachObserver(this);
	}

	@Override
	public void update() {
		System.out.println("Observer " + this.getClass().getSimpleName() + " knows best player is " + subjectClass.getBestPlayer());
	}
}
