package fmi.patterns.zadanie2;

public class FitnessInstructor {
	private Trainer trainer;

	public FitnessInstructor(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public void giveExcercise(Excercise excercise) {
		trainer.showExercise(excercise);
	}
	
}
