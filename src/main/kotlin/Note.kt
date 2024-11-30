data class Note(val title: String, val content: String)
{
    fun view()
    {
        println("\nНазвание заметки: $title")
        println("Содержание заметки: $content")
    }
}
