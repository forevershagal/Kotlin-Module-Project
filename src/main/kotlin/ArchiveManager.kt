class ArchiveManager(private val archives: MutableList<Archive> = mutableListOf())
{

    fun manage()
    {
        while (true)
        {
            println("\nМеню архивов:")
            println("0. Создать архив")
            for (index in archives.indices)
            {
                println("${index + 1}. ${archives[index].name}")
            }

            println("${archives.size + 1}. Выход")

            print("Введите номер пункта: ")
            val input = readLine()
            val choice = parseInputToInt(input)

            if (choice == null || choice < 0 || choice > archives.size + 1)
            {
                println("Ошибка: введите корректный номер пункта.")
                continue
            }

            when (choice)
            {
                0 -> createArchive()
                archives.size + 1 -> return
                else -> archives[choice - 1].manage()
            }
        }
    }

    private fun createArchive()
    {
        print("Введите название архива: ")
        val name = readLine()?.trim() ?: ""
        if (name.isEmpty())
        {
            println("Ошибка: название архива не может быть пустым.")
            return
        }

        archives.add(Archive(name))
        println("Архив '$name' успешно создан.")
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
