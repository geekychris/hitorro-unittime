package com.hitorro.unittime;

import com.hitorro.jsontypesystem.JVS;
import com.hitorro.util.commandandcontrol.Command;
import com.hitorro.util.commandandcontrol.CommandSession;
import com.hitorro.util.commandandcontrol.Response;
import com.hitorro.util.commandandcontrol.ResponseShape;
import com.hitorro.util.commandandcontrol.ano.CommandArgument;
import com.hitorro.util.commandandcontrol.ano.CommandDef;
import com.hitorro.util.commandandcontrol.ano.RespColumn;
import com.hitorro.util.commandandcontrol.ano.ResponseDefinition;
import com.hitorro.util.core.CPUInfo;
import com.hitorro.util.core.Log;
import com.hitorro.util.json.keys.StringProperty;

/**
 * Copyright (c) 2003 - present HiTorro All rights reserved. User: chris Date: Nov 22, 2006 Time: 6:47:16 PM
 */
@CommandDef(command = "test.rununittime", description = "Execute unit time tests")
public class UnitTimeCommand extends Command {
    @ResponseDefinition(command = "utr",
            rowname = "utr",
            columns = {@RespColumn(name = "ms_per_unit", lName = "msperunit", type = Double.class),
					@RespColumn(name = "ns_per_unit", lName = "nsperunit", type = Double.class),
                    @RespColumn(name = "units", lName = "units", type = Double.class),
                    @RespColumn(name = "instruction_cycles", lName = "instructioncycles", type = Double.class),
                    @RespColumn(name = "category", lName = "category"),
                    @RespColumn(name = "subcategory", lName = "subcategory"),
                    @RespColumn(name = "description", lName = "description"),
                    @RespColumn(name = "name", lName = "name")})
    private ResponseShape responseShape = new ResponseShape();
    @CommandArgument(required = false)
    private StringProperty TestName = new StringProperty("testname", "individual test to run", "");

    public UnitTimeCommand() {
        System.out.println();
    }

    @Override
    public boolean execute(String rawValue, JVS args, Response response, CommandSession session) {
        UnitTimeContext context = new UnitTimeContext();
        String singleTest = TestName.apply(args);
        response.setResponseShape(responseShape);
        
        // Detect CPU clock speed using CPUInfo utility
        double gigahertz = 4.0; // Default fallback
        CPUInfo.ClockSpeed cpuSpeed = CPUInfo.getCPUClockSpeed();
        if (cpuSpeed != null) {
            gigahertz = cpuSpeed.getSpeedGHz();
            Log.util.info("Detected CPU speed: %.2f GHz", gigahertz);
        } else {
            Log.util.warn("Unable to detect CPU speed, using default: %.2f GHz", gigahertz);
        }
        
        context.runTests(response, singleTest, gigahertz);
        return true;
    }

}
