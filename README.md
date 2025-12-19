# Hitorro Unit Time

> Micro-benchmark and performance profiling toolkit for measuring Java operation execution times

[![Java](https://img.shields.io/badge/Java-19%2B-orange)](https://openjdk.java.net/)
[![Maven](https://img.shields.io/badge/Maven-3.6%2B-blue)](https://maven.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

## Overview

Hitorro Unit Time is a lightweight, high-precision performance measurement toolkit designed for micro-benchmarking Java operations. It provides tools to measure and compare execution times of primitive operations, data structure operations, and custom code blocks with nanosecond precision.

### Key Features

- ⚡ **High Precision** - Nanosecond-level timing measurements
- 🎯 **Primitive Operations** - Built-in tests for arrays, casts, arithmetic
- 📊 **Performance Profiling** - Command-based execution framework
- 🔬 **Micro-Benchmarking** - Measure single operation performance
- 📈 **Statistical Analysis** - Track and compare multiple runs
- 🎪 **Extensible** - Easy to add custom performance tests
- 🧪 **Unit Tested** - Comprehensive test coverage

## Architecture

```
hitorro-unittime/
├── UnitTimeContext      - Execution context and command management
├── UnitTimeCommand      - Performance test command definition
├── UnitTimeResult       - Timing results and metrics
├── UnitTimeService      - Service coordination
└── primitive/           - Primitive operation benchmarks
    ├── array/          - Array operation tests
    ├── cast/           - Type casting tests
    ├── calls/          - Method call tests
    └── object/         - Object operation tests (Map, List, etc.)
```

## Installation

### Maven

```xml
<dependency>
    <groupId>com.hitorro</groupId>
    <artifactId>hitorro-unittime</artifactId>
    <version>3.0.0</version>
</dependency>
```

### Gradle

```gradle
implementation 'com.hitorro:hitorro-unittime:3.0.0'
```

## Quick Start

### Basic Timing

```java
import com.hitorro.unittime.*;

// Create context
UnitTimeContext context = new UnitTimeContext();

// Define a command
UnitTimeCommand command = new UnitTimeCommand("array.access", 10000);
context.addCommand(command);

// Execute and measure
UnitTimeResult result = context.execute("array.access");

// Get results
System.out.println("Execution time: " + result.getExecutionTimeNanos() + " ns");
System.out.println("Per operation: " + result.getExecutionTimeNanos() / 10000 + " ns");
```

### Comparing Operations

```java
UnitTimeContext context = new UnitTimeContext();

// Test different operations
context.addCommand(new UnitTimeCommand("arraylist.add", 1000));
context.addCommand(new UnitTimeCommand("linkedlist.add", 1000));
context.addCommand(new UnitTimeCommand("hashmap.put", 1000));

// Execute all
UnitTimeResult r1 = context.execute("arraylist.add");
UnitTimeResult r2 = context.execute("linkedlist.add");
UnitTimeResult r3 = context.execute("hashmap.put");

// Compare
System.out.println("ArrayList: " + r1.getExecutionTimeNanos() + " ns");
System.out.println("LinkedList: " + r2.getExecutionTimeNanos() + " ns");
System.out.println("HashMap: " + r3.getExecutionTimeNanos() + " ns");
```

## Core Components

### UnitTimeContext

Manages the execution environment for performance tests:

```java
UnitTimeContext context = new UnitTimeContext();

// Add commands
context.addCommand(new UnitTimeCommand("test.operation", 1000));

// Execute
UnitTimeResult result = context.execute("test.operation");

// Get command
UnitTimeCommand cmd = context.getCommand("test.operation");

// List all commands
Map<String, UnitTimeCommand> commands = context.getCommands();

// Clear all
context.clearCommands();
```

### UnitTimeCommand

Defines a performance test command:

```java
// Basic command
UnitTimeCommand command = new UnitTimeCommand("test.name", 1000);

// Get properties
String name = command.getName();
int iterations = command.getIterations();
```

### UnitTimeResult

Contains execution timing results:

```java
UnitTimeResult result = context.execute("test");

// Get timing
long nanos = result.getExecutionTimeNanos();
String commandName = result.getCommandName();

// Convert to different units
double millis = nanos / 1_000_000.0;
double seconds = nanos / 1_000_000_000.0;

// Calculate per-iteration time
long avgNanos = nanos / iterations;
```

## Primitive Operations

### Array Operations

Test array access and manipulation performance:

```java
// Array element access
UnitTimeCommand arrayAccess = new UnitTimeCommand("array.access", 10000);

// Array creation
UnitTimeCommand arrayCreate = new UnitTimeCommand("array.create", 1000);

// Array iteration
UnitTimeCommand arrayIterate = new UnitTimeCommand("array.iterate", 1000);
```

### Object Operations

Test collection and map operations:

```java
import com.hitorro.unittime.primitive.object.MapGet;

MapGet mapGet = new MapGet();
// Benchmark map get operations

// Also available:
// - List operations
// - Set operations
// - Queue operations
```

### Type Casting

Measure casting performance:

```java
// Test casting between types
UnitTimeCommand castTest = new UnitTimeCommand("cast.primitive", 10000);
UnitTimeCommand castObject = new UnitTimeCommand("cast.object", 10000);
```

### Method Calls

Measure method invocation overhead:

```java
UnitTimeCommand methodCall = new UnitTimeCommand("call.static", 10000);
UnitTimeCommand virtualCall = new UnitTimeCommand("call.virtual", 10000);
```

## Use Cases

### 1. Algorithm Comparison

Compare different implementations:

```java
UnitTimeContext context = new UnitTimeContext();

context.addCommand(new UnitTimeCommand("sort.bubble", 1000));
context.addCommand(new UnitTimeCommand("sort.quick", 1000));
context.addCommand(new UnitTimeCommand("sort.merge", 1000));

// Execute and compare
for (String name : new String[]{"sort.bubble", "sort.quick", "sort.merge"}) {
    UnitTimeResult result = context.execute(name);
    System.out.printf("%s: %d ns%n", name, result.getExecutionTimeNanos());
}
```

### 2. Data Structure Selection

Choose the best data structure for your use case:

```java
// Test different data structures
context.addCommand(new UnitTimeCommand("arraylist.random", 1000));
context.addCommand(new UnitTimeCommand("linkedlist.random", 1000));
context.addCommand(new UnitTimeCommand("treeset.random", 1000));

// Execute and analyze results
```

### 3. Optimization Verification

Verify that optimizations actually improve performance:

```java
// Before optimization
UnitTimeResult before = context.execute("operation.before");

// After optimization
UnitTimeResult after = context.execute("operation.after");

// Compare
long improvement = before.getExecutionTimeNanos() - after.getExecutionTimeNanos();
double percent = (improvement * 100.0) / before.getExecutionTimeNanos();
System.out.printf("Improvement: %.2f%%%n", percent);
```

### 4. JVM Warmup Analysis

Measure JVM warmup effects:

```java
UnitTimeCommand command = new UnitTimeCommand("test", 1000);
context.addCommand(command);

// Run multiple times
for (int i = 0; i < 10; i++) {
    UnitTimeResult result = context.execute("test");
    System.out.printf("Run %d: %d ns%n", i+1, result.getExecutionTimeNanos());
}
```

## Best Practices

### 1. Warmup the JVM

```java
// Run operations several times before measuring
for (int i = 0; i < 5; i++) {
    context.execute("test");
}

// Now measure
UnitTimeResult result = context.execute("test");
```

### 2. Multiple Iterations

```java
// Use enough iterations for stable measurements
UnitTimeCommand command = new UnitTimeCommand("test", 10000); // Not just 10
```

### 3. Statistical Analysis

```java
// Run multiple times and average
long total = 0;
int runs = 10;

for (int i = 0; i < runs; i++) {
    UnitTimeResult result = context.execute("test");
    total += result.getExecutionTimeNanos();
}

long average = total / runs;
System.out.println("Average: " + average + " ns");
```

### 4. Garbage Collection

```java
// Suggest GC before measurements
System.gc();
Thread.sleep(100);

// Now measure
UnitTimeResult result = context.execute("test");
```

## Performance Tips

1. **Minimize Object Creation** - Reuse objects when possible
2. **Avoid I/O** - Focus on CPU-bound operations
3. **Disable JIT Optimizations** - For consistent results (if needed)
4. **Use Sufficient Iterations** - At least 1000 for stable measurements
5. **Warmup the JVM** - Run 5-10 warmup iterations
6. **Isolate Tests** - Run one test at a time in production

## Dependencies

### Required
- **hitorro-base**: 3.0.0 - Core utilities and infrastructure

### Test
- **JUnit**: 4.13.2
- **Mockito**: 5.7.0

## Testing

The project includes comprehensive unit tests:

```bash
# Run all tests
mvn test

# Run specific test
mvn test -Dtest=UnitTimeContextTest

# Run with coverage
mvn test jacoco:report
```

### Test Coverage

- **UnitTimeContext**: Context management and command execution
- **UnitTimeCommand**: Command creation and properties
- **UnitTimeResult**: Result handling and metrics
- **MapGet**: Primitive map operation testing

## Building

```bash
# Clean and build
./build.sh

# Or use Maven directly
mvn clean install

# Skip tests
mvn clean install -DskipTests

# Build with sources and javadocs
mvn clean install -Psources,javadoc
```

## Contributing

1. Fork the repository
2. Create your feature branch
3. Add tests for new functionality
4. Ensure all tests pass
5. Submit a pull request

## Version History

- **3.0.0** (Current) - Standalone release with Java 19+ support
- **2.0** - Original monolith version

## License

This project is licensed under the MIT License.

## Support

For questions, issues, or contributions:
- **Issues**: GitHub Issues
- **Email**: support@hitorro.com
- **Documentation**: See QUICKSTART.md

## Acknowledgments

Built on the Hitorro framework for reliable Java performance measurement.
