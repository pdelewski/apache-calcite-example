# mavenutils

This is an example pom.xml for downloading apache calcite dependencies via

```baah
mvn dependency:copy-dependencies
```

or (into defined directory)

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
