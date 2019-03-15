package com.agilefaqs.dpw;

interface Supervisor {
    String NEW_LINE = System.getProperty("line.separator");

    String handleRequest(WorkRequest wr);

    boolean canHandleRequest(WorkRequest workRequest);

    String getName();

    String getType();
}
