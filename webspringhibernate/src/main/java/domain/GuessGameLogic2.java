package domain;

public class GuessGameLogic2 {
	private int theNumber;
	private int remainder = 5;
    private String hint;
	public GuessGameLogic2(int startNumber, int endNumber) {
		this.theNumber = generateRandomNumber(startNumber, endNumber);
	}

	public GuessGameLogic2(int startNumber, int endNumber, int remainder) {
		this.remainder = remainder;
		this.theNumber = generateRandomNumber(startNumber, endNumber);
	}

	public boolean isCorrectGuess(int guess) {
		if (guess == theNumber) {
			return true;
		} else {
			if(theNumber>guess)
				setHint("Guess Number too small");
			else
				setHint("Guess Number too big");
			remainder--;
			return false;
		}
	}

	private int generateRandomNumber(int startNumber, int endNumber) {
		double range = (double) (endNumber - startNumber + 1);
		return startNumber + (int) (Math.random() * range);
	}

	public int getRemainder() {
		return remainder;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}
}
