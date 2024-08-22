package com.algorithm.greedy.activityselection;

import java.util.Objects;

public class Activity {
	private int start;
	private int finish;
	public Activity(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	@Override
	public int hashCode() {
		return Objects.hash(finish, start);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		return finish == other.finish && start == other.start;
	}
}
