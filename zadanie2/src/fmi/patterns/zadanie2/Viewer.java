package fmi.patterns.zadanie2;

import java.util.Observable;
import java.util.Observer;

public class Viewer implements Observer {
	private String name;

	public Viewer(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Trainer) {
			System.out.println(name + " izpulni uprajnenieto : " + ((Trainer)o).getExcercise().toString());
		}

	}

}
