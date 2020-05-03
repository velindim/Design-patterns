package fmi.patterns.zadanie2;

public class Main {

	public static void main(String[] args) {
		Trainer trainer = new Trainer();
		trainer.addObserver(new Viewer("Pesho"));
		trainer.addObserver(new Viewer("Gosho"));
		trainer.addObserver(new Viewer("Tosho"));
		
		FitnessInstructor instructor = new FitnessInstructor(trainer);
		
		instructor.giveExcercise(new GetUpExcercise());
		
		instructor.giveExcercise(new LieDownExcercise());
	}

}
