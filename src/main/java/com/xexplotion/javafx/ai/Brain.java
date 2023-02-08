package com.xexplotion.javafx.ai;

public class Brain {
    private int id;
    private Agent[] agent;
    private boolean active;
    public Brain(int id, boolean active, Agent... agent){
        this.id = id;
        this.active = active;
        if(agent.length > 0) {
            this.agent = agent;
        }
    }
}
