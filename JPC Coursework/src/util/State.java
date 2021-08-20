package util;

public enum State {
	Waiting, // Waiting at a packing station to be released.
	Charging, // Not carrying anything, sat at a charging pod.
	toShelf, // Not carrying anything, heading towards a storage shelf.
	toStation, // Carrying item(s), heading towards the packing station.
	toPod, // Not carrying anything, heading to the charging pod.
}    