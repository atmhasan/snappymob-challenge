# Snappymob Programming Challenge (Java + Docker)

This project solves the programming challenge provided by Snappymob using Java (Maven) and Docker. It includes three parts:

- **Challenge A**: Generates a 10MB file with random objects (strings, numbers, alphanumerics).
- **Challenge B**: Reads that file and prints the type of each object.
- **Challenge C**: Dockerized version that runs Challenge B inside a container, using mounted folders for input and output.

---

## 🔧 Technologies Used

- Java 17
- Maven
- Docker (multi-stage build)
- No external libraries used

---

## 🚀 How to Run

### 📦 Build the Project

```bash
mvn clean package


🔎 	Run Challenge A (generate data.txt)
	java -cp target/snappymob-challenge-1.0-SNAPSHOT-jar-with-dependencies.jar com.snappymob.ChallengeA

This creates data.txt in the current folder (~10MB of comma-separated values).


🔎 	Run Challenge B (process and classify objects)
	java -jar target/snappymob-challenge-1.0-SNAPSHOT-jar-with-dependencies.jar data.txt result.txt
This reads the generated file and writes output to result.txt.


🐳 Run Challenge C with Docker
1. Build the Docker image:
docker build -t snappymob-challenge .
2. Create folders:
mkdir input output
Place data.txt inside the input/ folder.

3. Run the container:
# Windows CMD
docker run --rm -v %cd%\input:/input -v %cd%\output:/output snappymob-challenge

# PowerShell
docker run --rm -v ${PWD}/input:/input -v ${PWD}/output:/output snappymob-challenge
Output is saved to output/result.txt.

📁 Project Structure
snappymob-challenge/
├── Dockerfile
├── pom.xml
├── README.md
├── input/
│   └── data.txt
├── output/
│   └── result.txt
└── src/
    └── main/
        └── java/
            └── com/snappymob/
                ├── ChallengeA.java
                ├── ChallengeB.java
                └── Main.java

👤 Notes
I tested everything locally and inside Docker to ensure the file size, object types, and classification outputs are handled correctly.
