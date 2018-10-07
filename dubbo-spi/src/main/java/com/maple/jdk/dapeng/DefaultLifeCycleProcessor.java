package com.maple.jdk.dapeng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maple 2018.09.26 上午12:05
 */
public class DefaultLifeCycleProcessor implements LifeCycleProcessor {

    private volatile boolean containerIsRunning = false;



    private List<LifeCycle> lifeCycles = new ArrayList<>(16);

    DefaultLifeCycleProcessor() {
    }



    @Override
    public void addLifecycles(LifeCycle lifeCycle) {
        lifeCycles.add(lifeCycle);
    }

    @Override
    public void removeLifecycles(LifeCycle lifeCycle) {
        lifeCycles.remove(lifeCycle);
    }

    @Override
    public void onLifecycleEvent() {
        if (!containerIsRunning) {
            lifeCycles.forEach(LifeCycle::start);
        } else {
            lifeCycles.forEach(LifeCycle::stop);
        }
    }


}
