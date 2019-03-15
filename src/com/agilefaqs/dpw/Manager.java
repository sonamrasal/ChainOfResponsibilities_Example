package com.agilefaqs.dpw;

class Manager extends Entity {
	public Manager(String n) {
		this(n, null);
	}

	public Manager(String name, Supervisor manager) {
		super(name, manager);
	}

	@Override
	public String handleRequest(WorkRequest wr) {
		if (canHandleRequest(wr))
			return getType() + " " + getName() + ": PERFORMING task type=" + wr;
		else if (null != manager)
			return getType() + " " + getName() + ": FORWARDING task type=" + wr
					+ Supervisor.NEW_LINE + manager.handleRequest(wr);
		else
			return "No Entity present to handle task type=" + wr;
	}

	@Override
	public boolean canHandleRequest(WorkRequest wr) {
		return wr == WorkRequest.SIGN_INVOICE || wr == WorkRequest.ASSIGN_WORK;
	}

	@Override
	public String getType() {
		return "Manager";
	}
}
