package com.elevatorgame.elevatorgame;/*
 * Description: ElevatorPerson class provides persons to put into an elevator.
 * Stores some useful information about underlying person and the floor variables.
 * Could be saved by an elevator someday...
 * 
 * Author: Arif Fil
 * Student ID: 200 501 110 37
 * 
 * Creation Date: 05.10.2022 22.8.26 by Arif Fil
 * Last Update: 09.10.2022 11.58.30 by Arif Fil
 *  
 */

public class ElevatorPerson {

	// amount of the travel of the elevator when person got in
	private int enterTime;

	// the floor when person got into the elevator
	private int initialPosition;

	// the floor that person wants to arrive
	private int target;

	// underlying Person to store Person attributes
	private Person person;

	ElevatorPerson(Person p, int ip, int t) {
		this.person = p;
		this.initialPosition = ip;
		this.target = t;
		this.enterTime = Elevator.getTravelMeter();
	}

	// return underlying Person object
	public Person getPerson() {
		return this.person;
	}

	// return target floor
	public int getTarget() {
		return this.target;
	}

	// return the name, how much did travel and mood of the person
	public String toString() {
		String mood;

		// total amount of travel after getting in the elevator
		int amountOfTravel = (Elevator.getTravelMeter() - this.enterTime);

		// best amount of travel if person goes directly to the target
		int optimumAmountOfTravel = Math.abs(this.target - this.initialPosition);
		
		// if person is traveled more than going directly to the target
		// person is unhappy
		// otherwise happy
		if (optimumAmountOfTravel < amountOfTravel) {
			mood = "unhappy";
		} else {
			mood = "happy";
		}

		return String.format("I am %s. I traveled %d floors. I am %s",
				this.person.getName(),
				amountOfTravel,
				mood);
	}

}
