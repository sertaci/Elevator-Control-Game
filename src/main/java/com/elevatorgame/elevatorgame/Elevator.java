package com.elevatorgame.elevatorgame;/*
 * Description: Elevator class provides an un-convenient way to transport.
 * People get in and struggle to get out most of the time however if they don't want to
 * use stairs for 8 floors, that is the only chance. Could save some ElevatorPersons some day.
 * 
 * Keeps track of the people inside of the elevator and when arrives the correct
 * floor, people are free to get out if they are the one who last got in.
 * 
 * Author: Arif Fil
 * Student ID: 200 501 110 37
 * 
 * Creation Date: 05.10.2022 22.10.34 by Arif Fil
 * Last Update: 09.10.2022 12.00.20 by Arif Fil
 *  
 */

public class Elevator {

	// how much did elevator travel from the creation of instance
	private static int travelMeter;

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(int maxFloor) {
		this.maxFloor = maxFloor;
	}

	public int getMinFloor() {
		return minFloor;
	}

	public void setMinFloor(int minFloor) {
		this.minFloor = minFloor;
	}

	public MyStack getPeople() {
		return people;
	}

	public void setPeople(MyStack people) {
		this.people = people;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// the floor which elevator is standing
	private int currentFloor;

	// maximum available floor to go
	private int maxFloor;

	// minimum available floor to go
	private int minFloor;

	// stack variable to keep track of the
	// people in the elevator
	private MyStack people = new MyStack();

	// maximum person capacity of the elevator
	private int capacity;


	// default constructor
	Elevator() {
		this.capacity = 4;
		this.minFloor = 0;
		this.maxFloor = 10;
	}

	// create an Elevator instance containing custom
	// capacity, minFloor and maxFloor
	Elevator(int size, int minFloor, int maxFloor) {
		this.capacity = size;
		this.minFloor = minFloor;
		this.maxFloor = maxFloor;
	}

	// return travelMeter
	public static int getTravelMeter() {
		return Elevator.travelMeter;
	}

	// put a new person into the elevator if it has enough space
	// if target is not available then throw IllegalArgumentException
	// if elevator is full return false
	// add a new person to the stack if everything is correct
	public boolean enter(Person p, int target) throws IllegalArgumentException {
		
		// if target floor does not available
		if (target < this.minFloor || target > this.maxFloor) {
			throw new IllegalArgumentException(String.format("target %d out of bounds", target));
		}
		
		// if elevator is full
		if (this.capacity == this.people.getSize()) {
			return false;
		}
		
		//if everything is fine
		
		people.push((Object)(new ElevatorPerson(p, this.currentFloor, target)));
		System.out.printf("%s is in.\n", p.getName());

		return true;


	}

	// change the floor which the elevator stands
	// and dump all the people which is on the target
	public void goToFloor(int floor) throws IllegalArgumentException {
		
		// check if the requested floor is available
		if (floor > this.maxFloor || floor < this.minFloor) {
			throw new IllegalArgumentException(String.format("target %d out of bounds", floor));
		}
		
		// calculate the new travelMeter
		Elevator.travelMeter += Math.abs(floor - this.currentFloor);

		// adjust the current floor
		this.currentFloor = floor;

		// get person from top of the stack
		ElevatorPerson p;

		// is there any other person in the elevator to get off
		boolean personFlag = true;
		
		// if person is going to get off then release him
		while (personFlag) {

			// break the loop if elevator is empty
			if (people.isEmpty()) {
				personFlag = false;
				continue;
			}

			// get the person which last got in
			p =  (ElevatorPerson)people.peek();

			// get off if the floor is right
			if (p.getTarget() == this.currentFloor) {
				System.out.printf("%s is out.\n", p.getPerson().getName());
				System.out.println(p);
				this.people.pop();
			
			} else {	// if there isn't any person to get off next
				personFlag = false;
			}

				
		}

		// print current status of the elevator
		System.out.println(this);

	}

	// carry all remaining people to correct floor then dump them out
	public void releaseEveryone() {

		// dump them until the elevator is empty
		while (!people.isEmpty()) {
			goToFloor(((ElevatorPerson)people.peek()).getTarget());
		}

	}

	// return true if elevator is full, false otherwise
	public boolean isFull() {
		return this.capacity == this.people.getSize() ? true : false;
	}

	// return true if elevator is empty, true otherwise
	public boolean isEmpty() {	
		return this.people.isEmpty();
	}

	// return the status of the elevator in a pretty message string
	public String toString() {
		return String.format("Elevator is on floor: %d, Number of people: %d\n",
				this.currentFloor,
				this.people.getSize());
	}


}
