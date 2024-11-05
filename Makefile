# Define directories
LIBS_DIR = libs
OUT_DIR = out

# Define main class
MAIN_CLASS = Main

# Target to download dependencies using Maven
.PHONY: deps
deps:
	mvn dependency:copy-dependencies -DoutputDirectory=$(LIBS_DIR)

# Target to compile Java files to bytecode
.PHONY: build
build: deps
	mkdir -p $(OUT_DIR)
	javac -cp "$(LIBS_DIR)/*" -d $(OUT_DIR) *.java

# Target to create a native image using GraalVM
.PHONY: native-image
native-image: build
	native-image -cp "$(OUT_DIR):$(LIBS_DIR)/*" $(MAIN_CLASS)


# Clean up the output and libs directories
.PHONY: clean
clean:
	rm -rf $(LIBS_DIR) $(OUT_DIR) $(MAIN_CLASS)
