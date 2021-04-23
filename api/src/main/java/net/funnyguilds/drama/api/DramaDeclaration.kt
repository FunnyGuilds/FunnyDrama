package net.funnyguilds.drama.api

data class DramaDeclaration(
    val staticElements: Map<String, List<String>>,
    val sentences: List<String>
)
