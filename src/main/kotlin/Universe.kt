// Class for defining universe
data class Universe(
    val name: String,
    val individuals: MutableList<Creature> = mutableListOf()
)