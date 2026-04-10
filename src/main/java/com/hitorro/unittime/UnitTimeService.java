package com.hitorro.unittime;

import com.hitorro.util.startupframework.phases.ServiceDefinition;


@ServiceDefinition(dependentService = {},
        shortName = "unittime",
        description = "Run a unit time unit test",
        debugCommands = {UnitTimeCommand.class},
        uiDirectories = {})
public class UnitTimeService {
    public String deInit() {
        return null;
    }


    public String init(boolean dbInit, final boolean upgrading, final long currentVersion, final long targetVersion) {

        return null;
    }

    public String start(boolean dbInit) {

        return null;
    }
}
