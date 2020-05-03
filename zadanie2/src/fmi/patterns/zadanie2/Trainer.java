package fmi.patterns.zadanie2;

import java.util.Observable;

public class Trainer extends Observable {
	private Excercise excercise;

	public void showExercise(Excercise excercise) {
		this.excercise = excercise;
		excercise.doExcercise();
		setChanged();
		notifyObservers();
	}

	public Excercise getExcercise() {
		return excercise;
	}

}
