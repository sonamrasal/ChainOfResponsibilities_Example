package com.agilefaqs.dpw;

abstract class Entity implements Supervisor {
    private String name;
	protected Supervisor manager;

    public Entity(String n, Supervisor supervisor) {
        name = n;
		this.manager = supervisor;
    }

    @Override
    public String getName() {
        return name;
    }
}
