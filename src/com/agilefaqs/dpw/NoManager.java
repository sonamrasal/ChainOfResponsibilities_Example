package com.agilefaqs.dpw;

public class NoManager extends Entity {
	private static NoManager noManager;

	private NoManager(String n, Supervisor supervisor) {
		super(n, supervisor);
	}

	@Override
	public String handleRequest(WorkRequest wr) {
		return "No Entity present to handle task type=" + wr;
	}

	@Override
	public boolean canHandleRequest(WorkRequest workRequest) {
		return false;
	}

	@Override
	public String getType() {
		return "";
	}

	public static Supervisor getInstance() {
		if (null == noManager) {
			noManager = new NoManager("", null);
		}
		return noManager;
	}

}
