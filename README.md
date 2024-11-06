# GraalVM test

Run `make` or below steps

```bash
mvn dependency:copy-dependencies -DoutputDirectory=./libs

```

Compile with javac

```bash
javac -cp "libs/*" -d out *.java
```

Run with JVM

```bash
java -cp "out:libs/*" Main
```

Native with GraalVM

```bash
native-image -cp "out:libs/*" Main
```
