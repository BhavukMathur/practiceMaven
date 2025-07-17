package target2024.designPattern.observer;

public class ObserverMain {
	public static void main(String[] args) {
		SubjectClass subject = new SubjectClass();

		ObserverAbsClass observer1 = new ObserverAbsClass1(subject);
		ObserverAbsClass observer2 = new ObserverAbsClass2(subject);

		subject.updateBestPlayer("Don Bradman");
		subject.updateBestPlayer("Gary Sobers");
		subject.updateBestPlayer("Sunil Gavaskar");
		subject.updateBestPlayer("Brian Lara");
		subject.updateBestPlayer("Sachin Tendulkar");
		subject.updateBestPlayer("Ricky Ponting");
		subject.updateBestPlayer("Virat Kohli");
	}
}
