package com.agustin.recordatorios.model

enum class ReminderPriority {
    LOW,
    MEDIUM,
    HIGH
}

enum class ReminderStatus {
    PENDING,
    COMPLETED,
    CANCELLED
}

sealed class ReminderCategory(
    val label: String,
    val colorHex: Long
) {
    data object Work : ReminderCategory("Trabajo", 0xFF1565C0)
    data object Personal : ReminderCategory("Personal", 0xFF2E7D32)
    data object Study : ReminderCategory("Estudio", 0xFF6A1B9A)
    data object Health : ReminderCategory("Salud", 0xFFC62828)
}

data class Reminder(
    val id: Int,
    val title: String,
    val description: String? = null,
    val category: ReminderCategory,
    val priority: ReminderPriority,
    val status: ReminderStatus,
    val dueDate: String? = null
) {
    init {
        require(id > 0) { "El id debe ser mayor a 0" }
        require(title.isNotBlank()) { "El título no puede estar vacío" }
        require(description == null || description.isNotBlank()) {
            "La descripción, si existe, no puede estar vacía"
        }
        require(dueDate == null || DATE_REGEX.matches(dueDate)) {
            "La fecha debe tener el formato yyyy-MM-dd"
        }
    }

    private companion object {
        val DATE_REGEX = Regex("""\d{4}-\d{2}-\d{2}""")
    }
}