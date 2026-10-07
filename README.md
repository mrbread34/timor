# timor

A random idea I had. \
A terminal egg timer written in Java.

## Requirements

- Java 25

## Run

```
javac -d out src/main/java/org/timor/*.java
java -cp out org.timor.Main
```

Or open the project in IntelliJ and run `Main`.

## Usage

1. Type `egg` when asked what you're cooking.
2. Pick a style: `soft`, `medium` or `hard`.
3. Pick a size: `medium`, `large`, `extra large` or `jumbo`.
4. Press enter to start the countdown.

Type `quit` at the food prompt to exit.

## Cooking times

Times assume fridge-cold eggs lowered into water that's already boiling.

| Style  | Medium | Large | Extra large | Jumbo |
|--------|--------|-------|-------------|-------|
| Soft   | 5:30   | 6:00  | 6:30        | 7:00  |
| Medium | 7:00   | 7:30  | 8:00        | 8:30  |
| Hard   | 9:30   | 10:00 | 11:00       | 12:00 |
