/** Jerry Huang
 * APCS, Period 2
 * Kuszmaul
 * Think AP Java Exercise Ch15.5
 */

public class PokerHand extends Deck {
	
	// Initializing variables
	Card[] hand = new Card[5];
	int[] numOfEachSuit = new int[4];
	int[] numOfEachRank = new int[14];
	static int numOfStraightFlushes, numOfFourOfAKinds, numOfFullHouses, numOfFlushes,  numOfStraights,
			numOfThreeOfAKinds, numOfTwoPairs, numOfOnePairs, numOfHighCards;
	
	
	public static void main(String[] args) {
		final int NUM_OF_HANDS = 100000; // Number of hands to generate
		for (int i = 0; i < NUM_OF_HANDS; i++) {
			PokerHand hand = new PokerHand();
			hand.deal();
			hand.updateStats(); // Records stats
		}
		printSummary(NUM_OF_HANDS); // Prints probability table
	}
	
	public PokerHand deal() {
		
		Deck deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < hand.length; i++) {
			hand[i] = deck.cards[i];
		}
		
		findNumOfEachSuit(numOfEachSuit);
		findNumOfEachRank(numOfEachRank); 
		return this;
	}
	
	// Records number of each suit and rank in hand
	public void findNumOfEachSuit(int[] numOfEachSuit) {
		for (int i = 0; i < 5; i++) {
			numOfEachSuit[hand[i].suit]++;
		}
	}
	public void findNumOfEachRank(int[] numOfEachRank) {
		for (int i = 0; i < 5; i++) {
			numOfEachRank[hand[i].rank]++;
		}
	}
	
	
	/**
	 * Helper methods used to determine if hand has anything special
	 */
	public boolean handContainsOnePair() {
		for (int i = 1; i < 14; i++) {
			if (numOfEachRank[i] == 2)
				return true;
		}
		return false;
	}
	public boolean handContainsTwoPair() {
		int pairs = 0;
		for (int i = 1; i < 14; i++) {
			if (numOfEachRank[i] == 2)
				pairs++;
		}
		if (pairs == 2)
			return true;
		return false;
	}
	public boolean handContainsThreeOfAKind() {
		for (int i = 1; i < 14; i++) {
			if (numOfEachRank[i] == 3)
				return true;
		}
		return false;
	}
	public boolean handContainsFourOfAKind() {
		for (int i = 1; i < 14; i++) {
			if (numOfEachRank[i] == 4)
				return true;
		}
		return false;
	}
	public boolean handContainsAStraight() {
		for (int i = 0; i < 10; i++) {
			if (numOfEachRank[i] == 1 && numOfEachRank[i+1] == 1 && numOfEachRank[i+2] == 1 &&
					numOfEachRank[i+3] == 1 && numOfEachRank[i+4] == 1) {
				return true;
			}
		}
		return false;
	}
	public boolean handContainsAFlush() {
		if (hand[0].suit == hand[1].suit && hand[1].suit == hand[2].suit && 
				hand[2].suit == hand[3].suit && hand[3].suit == hand[4].suit) {
			return true;		
		}
		return false;
	}
	
	
	/**
	 * Methods used to determine what hand the player has
	 */
	public boolean hasOnePair() {
		return handContainsOnePair() && !handContainsThreeOfAKind() && !handContainsTwoPair();
	}
	public boolean hasTwoPair() {
		if (handContainsTwoPair())
			return true;
		return false;
	}
	public boolean hasThreeOfAKind() {
		return handContainsThreeOfAKind() && !handContainsOnePair();
	}
	public boolean hasFourOfAKind() {
		return handContainsFourOfAKind();
	}
	public boolean hasStraight() {
		return handContainsAStraight() && !handContainsAFlush();
	}
	public boolean hasFlush() {
		return handContainsAFlush() && !handContainsAStraight();
	}
	public boolean hasStraightFlush() {
		return handContainsAStraight() && handContainsAFlush();
	}
	public boolean hasFullHouse() {
		return handContainsOnePair() && handContainsThreeOfAKind();
	}
	public boolean hasHighCard() {
		// Checks if hand has anything
		if (!handContainsOnePair() && !handContainsAFlush() && !handContainsThreeOfAKind() && !handContainsAStraight()
				&& !handContainsFourOfAKind())
			return true;
		return false;
	}
	
	// Updates the number of different poker hands that have been dealt
	public void updateStats() {
		if (hasOnePair())
			numOfOnePairs++;
		if (hasTwoPair())
			numOfTwoPairs++;
		if (hasThreeOfAKind())
			numOfThreeOfAKinds++;
		if (hasFourOfAKind())
			numOfFourOfAKinds++;
		if (hasStraight())
			numOfStraights++;
		if (hasFlush())
			numOfFlushes++;
		if (hasStraightFlush())
			numOfStraightFlushes++;
		if (hasFullHouse())
			numOfFullHouses++;
		if (hasHighCard())
			numOfHighCards++;
	}
	
	// Determines the probability of getting a certain hand
	public static double probabilityOf(int numberOfAHand, int totalNumberOfHands) {
		return (100.0 * numberOfAHand / totalNumberOfHands);
	}
	
	// Prints all data, and the probabilities of getting a certain hand
	public static void printSummary(int numberOfHands) {
		System.out.println("One pairs: " + numOfOnePairs);
		System.out.println("Two pairs: " + numOfTwoPairs);
		System.out.println("Three of a kinds: " + numOfThreeOfAKinds);
		System.out.println("Four of a kinds: " + numOfFourOfAKinds);
		System.out.println("Straights: " + numOfStraights);
		System.out.println("Flushes: " + numOfFlushes);
		System.out.println("Straight flushes: " + numOfStraightFlushes);
		System.out.println("Full Houses: " + numOfFullHouses);
		System.out.println("High Cards: " + numOfHighCards);
		System.out.println("Total hands: " + numberOfHands);
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Probability of getting a: ");
		System.out.println("-----------------------");
		System.out.println("One pair: " + probabilityOf(numOfOnePairs, numberOfHands) + "%");
		System.out.println("Two pair: " + probabilityOf(numOfTwoPairs, numberOfHands) + "%");
		System.out.println("Three of a kind: " + probabilityOf(numOfThreeOfAKinds, numberOfHands) + "%");
		System.out.println("Four of a kind: " + probabilityOf(numOfFourOfAKinds, numberOfHands) + "%");
		System.out.println("Straight: " + probabilityOf(numOfStraights, numberOfHands) + "%");
		System.out.println("Flush: " + probabilityOf(numOfFlushes, numberOfHands) + "%");
		System.out.println("Straight flush: " + probabilityOf(numOfStraightFlushes, numberOfHands) + "%");
		System.out.println("Full house: " + probabilityOf(numOfFullHouses, numberOfHands) + "%");
		System.out.println("High card: " + probabilityOf(numOfHighCards, numberOfHands) + "%");
	}
}