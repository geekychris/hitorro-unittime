# Quick Start Guide - Hitorro Unit Time

## Prerequisites

### 1. Java Development Kit
```bash
# Check Java version (19+ required)
java -version

# Install Java if needed
# macOS: brew install openjdk@19
# Ubuntu: sudo apt install openjdk-19-jdk
# Windows: Download from https://openjdk.org/
```

### 2. Apache Maven
```bash
# Check Maven version
mvn -version

# Install Maven if needed
# macOS: brew install maven
# Ubuntu: sudo apt install maven
# Windows: Download from https://maven.apache.org/
```

### 3. Dependencies

Install hitorro-base first:
```bash
cd ../hitorro-base
mvn clean install
```

## Building

### Quick Build

```bash
cd /Users/chris/hitorro/hitorro-unittime
./build.sh
```

### Manual Build

```bash
# Clean previous builds
mvn clean

# Build and install
mvn install

# Skip tests (if needed)
mvn install -DskipTests

# Build with sources and javadocs
mvn clean install source:jar javadoc:jar
```

## Using in Your Project

### Maven

Add to your `pom.xml`:

```xml
<dependency>
    <groupId>com.hitorro</groupId>
    <artifactId>hitorro-unittime</artifactId>
    <version>3.0.0</version>
</dependency>
```

### Gradle

Add to your `build.gradle`:

```gradle
implementation 'com.hitorro:hitorro-unittime:3.0.0'
```

## First Example

Create a simple performance test:

```java
import com.hitorro.unittime.*;

public class QuickStart {
    public static void main(String[] args) throws Exception {
        // Create context
        UnitTimeContext context = new UnitTimeContext();
        
        // Add a test command
        UnitTimeCommand command = new UnitTimeCommand("test.operation", 10000);
        context.addCommand(command);
        
        // Execute and measure
        UnitTimeResult result = context.execute("test.operation");
        
        // Print results
        System.out.println("Command: " + result.getCommandName());
        System.out.println("Total time: " + result.getExecutionTimeNanos() + " ns");
        System.out.println("Per operation: " + 
            result.getExecutionTimeNanos() / 10000 + " ns");
    }
}
```

## Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=UnitTimeContextTest

# Run specific test method
mvn test -Dtest=UnitTimeContextTest#testContextCreation

# Run with verbose output
mvn test -X
```

## Common Use Cases

### 1. Compare Data Structures

```java
UnitTimeContext context = new UnitTimeContext();

// Test ArrayList
context.addCommand(new UnitTimeCommand("arraylist.add", 1000));
UnitTimeResult r1 = context.execute("arraylist.add");

// Test LinkedList
context.addCommand(new UnitTimeCommand("linkedlist.add", 1000));
UnitTimeResult r2 = context.execute("linkedlist.add");

// Compare
System.out.println("ArrayList: " + r1.getExecutionTimeNanos() + " ns");
System.out.println("LinkedList: " + r2.getExecutionTimeNanos() + " ns");
```

### 2. Measure Operation Time

```java
UnitTimeContext context = new UnitTimeContext();

// Define operation
UnitTimeCommand command = new UnitTimeCommand("map.get", 10000);
context.addCommand(command);

// Warmup
for (int i = 0; i < 5; i++) {
    context.execute("map.get");
}

// Actual measurement
UnitTimeResult result = context.execute("map.get");
System.out.println("Average per get: " + 
    result.getExecutionTimeNanos() / 10000 + " ns");
```

### 3. Multiple Test Runs

```java
UnitTimeContext context = new UnitTimeContext();
context.addCommand(new UnitTimeCommand("test", 1000));

long total = 0;
int runs = 10;

for (int i = 0; i < runs; i++) {
    UnitTimeResult result = context.execute("test");
    total += result.getExecutionTimeNanos();
}

System.out.println("Average: " + total / runs + " ns");
```

## IDE Setup

### IntelliJ IDEA

1. Open the project: `File → Open → hitorro-unittime/pom.xml`
2. Enable auto-import: `Preferences → Build → Maven → Importing`
3. Set JDK 19+: `File → Project Structure → Project SDK`
4. Run tests: Right-click on test → Run

### Eclipse

1. Import project: `File → Import → Maven → Existing Maven Project`
2. Select the `hitorro-unittime` directory
3. Right-click project → Maven → Update Project
4. Run tests: Right-click on test → Run As → JUnit Test

### VS Code

1. Open the folder: `File → Open Folder → hitorro-unittime`
2. Install Java Extension Pack
3. Maven will auto-detect
4. Run tests from the Testing view

## Troubleshooting

### Build Fails

**Problem**: Cannot find hitorro-base dependency

**Solution**:
```bash
cd ../hitorro-base
mvn clean install
cd ../hitorro-unittime
mvn clean install
```

### Tests Fail

**Problem**: Test failures due to timing variations

**Solution**: Timing tests can be sensitive to system load. Try:
```bash
# Close other applications
# Run tests again
mvn clean test
```

### Java Version Issues

**Problem**: Unsupported class file major version

**Solution**:
```bash
# Check Java version
java -version

# Set JAVA_HOME to Java 19+
export JAVA_HOME=/path/to/jdk19
```

### Memory Issues

**Problem**: OutOfMemoryError during build

**Solution**:
```bash
export MAVEN_OPTS="-Xmx2g -XX:MaxPermSize=512m"
mvn clean install
```

## Performance Tips

1. **Warmup JVM**: Run tests 5-10 times before measuring
2. **Sufficient Iterations**: Use at least 1000 iterations
3. **Stable Environment**: Close other applications during benchmarking
4. **Multiple Runs**: Average results from multiple runs
5. **GC Pauses**: Call `System.gc()` before critical measurements

## Next Steps

1. Read the full [README.md](README.md) for comprehensive documentation
2. Review [EXTRACTION_SUMMARY.md](EXTRACTION_SUMMARY.md) for project details
3. Explore the test classes for usage examples
4. Check the `primitive/` package for built-in benchmarks

## Getting Help

- **Documentation**: See README.md
- **Examples**: Check test classes in `src/test/java`
- **Issues**: Report on GitHub
- **Support**: support@hitorro.com

## Quick Reference

```bash
# Build project
./build.sh

# Run tests
mvn test

# Clean build
mvn clean install

# Skip tests
mvn install -DskipTests

# Package without install
mvn package

# View dependency tree
mvn dependency:tree

# Update dependencies
mvn versions:display-dependency-updates
```

Happy benchmarking! 🚀
