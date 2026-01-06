# Instruction Cycles Calculation in UnitTime Tests

## Overview

The UnitTime testing framework now includes **instruction cycle estimation** for each primitive operation test. This provides insight into approximately how many CPU clock cycles each Java operation requires.

## Changes Made

### 1. UnitTimeCommand.java
- **CPU Detection**: Added automatic CPU clock speed detection using `CPUInfo.getCPUClockSpeed()`
- **Default Fallback**: Falls back to 4.0 GHz if detection fails
- **New Column**: Added `instruction_cycles` column to response definition
- **Logging**: Logs detected or default CPU speed for transparency

### 2. UnitTimeResult.java
- **New Field**: Added `public double instructionCycles` field
- **Updated Methods**: Modified `toString()` and `addToRow()` to include instruction cycles

### 3. UnitTimeContext.java
- **CPU GHz Storage**: Added `cpuGigahertz` field to store CPU clock speed
- **Updated Signature**: `runTests()` now accepts `cpuGigahertz` parameter
- **Cycle Calculation**: Added instruction cycle computation in `executeTest()` method

## Instruction Cycle Calculation Formula

The calculation is based on the fundamental relationship between time and CPU clock speed:

```
Instruction Cycles = Nanoseconds × CPU Frequency (GHz)
```

### Mathematical Explanation

1. **CPU Frequency in GHz** means billions of cycles per second
   - Example: 3.0 GHz = 3,000,000,000 cycles/second

2. **One nanosecond** is one-billionth of a second
   - 1 ns = 1 / 1,000,000,000 seconds

3. **Cycles per nanosecond** = GHz value
   - At 3.0 GHz: 3 cycles per nanosecond
   - At 4.0 GHz: 4 cycles per nanosecond

4. **Total cycles** = nanoseconds × cycles per nanosecond
   - If operation takes 10 ns at 3.0 GHz: 10 × 3 = 30 cycles
   - If operation takes 10 ns at 4.0 GHz: 10 × 4 = 40 cycles

### Implementation

```java
// nsPerUnit is already computed (milliseconds * 1,000,000)
// cpuGigahertz is detected or defaulted to 4.0
if (cpuGigahertz > 0) {
    result.instructionCycles = result.nsPerUnit * cpuGigahertz;
}
```

## Example Results

### Intel CPU @ 2.6 GHz

| Operation | ns/unit | Instruction Cycles |
|-----------|---------|-------------------|
| Local Assignment | 0.5 ns | 1.3 cycles |
| Integer Addition | 1.0 ns | 2.6 cycles |
| Float Multiplication | 2.0 ns | 5.2 cycles |
| Array Access | 3.5 ns | 9.1 cycles |

### Apple M4 Max (Detection Not Available)

On Apple Silicon, CPU frequency detection returns `null` because these chips use dynamic frequency scaling with performance and efficiency cores. The system will:
- Use the default 4.0 GHz value
- Log a warning message
- Still provide meaningful relative cycle estimates

| Operation | ns/unit | Instruction Cycles (est.) |
|-----------|---------|--------------------------|
| Local Assignment | 0.5 ns | 2.0 cycles (estimated) |
| Integer Addition | 1.0 ns | 4.0 cycles (estimated) |

## Assumptions and Limitations

### Key Assumption
**One instruction per cycle**: The calculation assumes a theoretical CPU where each clock cycle can execute one instruction. This is a simplification.

### Real-World Considerations

1. **Superscalar CPUs**: Modern CPUs can execute multiple instructions per cycle
   - Intel/AMD: Often 4-6 micro-ops per cycle
   - Apple Silicon: Up to 8 instructions per cycle in some scenarios

2. **Pipeline Stalls**: Not all cycles are productive
   - Cache misses
   - Branch mispredictions
   - Memory latency

3. **JIT Compilation**: The JVM optimizes code at runtime
   - Inlining
   - Loop unrolling
   - Dead code elimination

4. **Dynamic Frequency Scaling**: CPU frequency varies with load
   - Turbo Boost (Intel)
   - Precision Boost (AMD)
   - Dynamic frequency on Apple Silicon

### Interpretation

The instruction cycle values should be interpreted as:
- **Relative comparison tool**: Compare different operations to each other
- **Lower bound estimate**: Real instruction count is likely lower due to parallelism
- **Platform-specific**: Results vary by CPU architecture and speed

## Usage Example

```bash
# Run all unit time tests
test.rununittime

# Run a specific test
test.rununittime testname=LocalAssignment
```

### Sample Output

```
CPU Speed: 2.60 GHz (detected)

ms_per_unit  | ns_per_unit | units | instruction_cycles | category | subcategory | description
------------ | ----------- | ----- | ------------------ | -------- | ----------- | -----------
0.0000004    | 0.4         | 1.0   | 1.04               | math     | primitive   | Local Assignment
0.0000012    | 1.2         | 3.0   | 3.12               | math     | primitive   | Integer Addition
```

## Benefits

1. **Hardware-Independent Metrics**: Compare performance across different CPUs
2. **Instruction-Level Insight**: Understand approximate cost in CPU cycles
3. **Optimization Guidance**: Identify operations that are more CPU-intensive
4. **Automatic Detection**: No manual configuration needed for CPU speed

## Platform Support

- **Linux**: Full CPU detection via `/proc/cpuinfo`
- **Mac (Intel)**: Full CPU detection via `sysctl`
- **Mac (Apple Silicon)**: Falls back to default 4.0 GHz with warning
- **Other Platforms**: Falls back to default 4.0 GHz with warning

## Technical Notes

### Precision
- The framework already accounts for:
  - System clock precision
  - Method invocation overhead
  - Baseline unit cost (for relative "units" calculation)
  
- The instruction cycle calculation adds:
  - CPU frequency-adjusted absolute cycle estimates
  - Hardware-specific timing information

### Future Enhancements

Potential improvements:
1. Allow manual CPU speed override via command argument
2. Detect performance vs. efficiency core speeds on Apple Silicon
3. Report CPU frequency scaling ranges
4. Add cycles-per-instruction (CPI) analysis
5. Account for memory hierarchy (L1/L2/L3 cache latency)

## See Also

- `CPUInfo.java` - CPU detection implementation
- `UnitTimer.java` - Base class for timing tests
- Original UnitTime documentation
