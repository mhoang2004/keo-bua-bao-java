# Makefile for compiling and running Java programs in the src folder

# Define the Java compiler
JAVAC = javac

# Define the Java runtime
JAVA = java

# Specify the source folder
SRC_FOLDER = src

# Get a list of all Java source files in the src folder
JAVA_FILES = $(wildcard $(SRC_FOLDER)/*.java)

# Extract the base names of Java files (without the .java extension)
BASENAMES = $(patsubst $(SRC_FOLDER)/%.java,%,$(JAVA_FILES))

# Specify the default target
default: help

# Compile and run the specified Java program
%: $(SRC_FOLDER)/%.java
	$(JAVAC) $<
	$(JAVA) -cp $(SRC_FOLDER) $*

# Display help information
help:
	@echo "Usage:"
	@echo "  make <filename without extension>  - Compile and run the specified Java program"

# Clean up compiled files
clean:
	rm -f $(SRC_FOLDER)/*.class