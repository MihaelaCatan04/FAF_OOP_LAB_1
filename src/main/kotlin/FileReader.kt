import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File

// Class for file reading
class FileReader(
    private val filePath: String
) {
    // Method to read a JSON from a file and parse it
    fun readAndParseJson(): MutableList<Creature>? {
        // Variable for filepath
        val file = File(filePath)
        // Check if file exists
        return if (file.exists()) {
            // Use Jackson Object Mapper
            val mapper = jacksonObjectMapper()
            // Store the results in a Mutable List
            val creatureList: CreatureList = mapper.readValue(file)
            creatureList.data
        } else {
            // Return null if the file doesn't exist
            println("File does not exist")
            null
        }
    }
}