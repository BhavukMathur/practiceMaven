package target2024.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

// Class being observed
public class SubjectClass {
	private String bestPlayer;
	private List<ObserverAbsClass> observerList = new ArrayList();

	public String getBestPlayer() {
		return bestPlayer;
	}

	public void attachObserver(ObserverAbsClass observer) {
		observerList.add(observer);
	}

	private void notifyObservers() {
		observerList.forEach(observer -> {
			observer.update();
		});
	}

	public void updateBestPlayer(String name) {
		this.bestPlayer = name;
		notifyObservers();
	}
}
