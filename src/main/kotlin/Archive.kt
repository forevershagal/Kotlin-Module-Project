class Archive(val name: String, private val notes: MutableList<Note> = mutableListOf()) {

    fun manage()
    {
        while (true)
        {
            println("\nМеню заметок:")
            println("0. Создать заметку")
            for (index in notes.indices)
            {
                println("${index + 1}. ${notes[index].title}")
            }
            println("${notes.size + 1}. Назад")

            print("Введите номер пункта: ")

            val input = readLine()
            val choice = parseInputToInt(input)

            if (choice == null || choice < 0 || choice > notes.size + 1)
            {
                println("Ошибка: введите корректный номер пункта.")
                continue
            }

            when (choice)
            {
                0 -> createNote()
                notes.size + 1 -> return
                else -> notes[choice - 1].view()
            }
        }
    }

    private fun createNote()
    {
        print("Введите название заметки: ")
        val title = readLine()?.trim() ?: ""
        if (title.isEmpty())
        {
            println("Ошибка: название заметки не может быть пустым.")
            return
        }

        print("Введите содержание заметки: ")
        val content = readLine()?.trim() ?: ""
        if (content.isEmpty())
        {
            println("Ошибка: содержание заметки не может быть пустым.")
            return
        }

        notes.add(Note(title, content))
        println("Заметка '$title' успешно создана.")
    }

    private fun parseInputToInt(input: String?): Int?
    {
        return try
        {
            input?.toInt()
        }
        catch (e: NumberFormatException)
        {
            null
        }
    }
}
