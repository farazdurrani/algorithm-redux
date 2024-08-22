package com.algorithm.greedy.activityselection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelectionProblem2 {

	public static void main(String[] args) {
		List<Activity> activities = List.of(new Activity(0, 0), // 0,0 is symbolic
				new Activity(1, 4), new Activity(3, 5), new Activity(0, 6), new Activity(5, 7), new Activity(3, 9),
				new Activity(5, 9), new Activity(6, 10), new Activity(8, 11), new Activity(8, 12), new Activity(2, 14),
				new Activity(12, 16));

		activities = new ArrayList<>(activities);
		// first step, sort by finish time
		//sort method
		List<Activity> selectedActivities = new ArrayList<>();

		// this is also greedy but recursive approach
		// start from ficticious 0
		RECURSIVE_ACTIVITY_SELECTOR(activities, 0, selectedActivities);

		System.out.println("Recursive ->");
		selectedActivities.forEach(a -> {
			System.out.println(a.getStart() + " | " + a.getFinish());
		});

		// this is iterative
		List<Activity> selectedActivities2 = GREEDY_ACTIVITIY_SELECTOR(activities);

		System.out.println("Iterative ->");
		selectedActivities2.forEach(a -> {
			System.out.println(a.getStart() + " | " + a.getFinish());
		});
	}

	private static void RECURSIVE_ACTIVITY_SELECTOR(List<Activity> activities, int k,
			List<Activity> selectedActivities) {
		
	}

	private static List<Activity> GREEDY_ACTIVITIY_SELECTOR(List<Activity> activities) {
		return null;
	}

}
