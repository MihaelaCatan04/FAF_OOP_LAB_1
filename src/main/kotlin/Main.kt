fun main() {
    // Create an instance of FileReader to read from the specified input JSON file
    val fileReader = FileReader("src/main/resources/input.json")

    // Read data from the JSON file and parse it into a list of Creature objects
    val data = fileReader.readAndParseJson()

    // Check if data was successfully read and parsed
    if (data != null) {
        // Create an instance of UniverseClassifier to classify the creatures
        val classifier = UniverseClassifier()
        // Classify the creatures based on their traits and characteristics
        classifier.classify(data)

        // Create an instance of OutputWriter to write classified creatures to output files
        val outputWriter = OutputWriter()
        // Write the classified creatures to respective output JSON files for each universe
        outputWriter.writeToOutputFiles("src/main/resources/output", classifier.universes)

        // Print a message indicating that the classification and output writing process is complete
        println("Classification complete. Output files written.")

        // Create an instance of View to display the output to the console
        val view = View()
        // Show the contents of the output files for each universe on the screen
        view.showContent()
    } else {
        // Print an error message if the input file could not be read or parsed
        println("Failed to read or parse the input file.")
    }
}
