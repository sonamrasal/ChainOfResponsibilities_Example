package com.agilefaqs.dpw;

class Employee extends Entity {
	public Employee(String name, Supervisor manager) {
		super(name, manager);
	}

	@Override
	public String handleRequest(WorkRequest wr) {
		if (canHandleRequest(wr))
			return getType() + " " + getName() + ": PERFORMING task type=" + wr;
		else
			return getType() + " " + getName() + ": FORWARDING task type=" + wr
					+ Supervisor.NEW_LINE + manager.handleRequest(wr);
	}

	@Override
	public boolean canHandleRequest(WorkRequest wr) {
		return wr == WorkRequest.DESIGN_PRODUCT
				|| wr == WorkRequest.DEBUG_PRODUCT;
	}

	@Override
	public String getType() {
		return "Employee";
	}
}
