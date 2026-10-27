package com.agustin.recordatorios

import com.agustin.recordatorios.model.Reminder
import com.agustin.recordatorios.model.ReminderCategory
import com.agustin.recordatorios.model.ReminderPriority
import com.agustin.recordatorios.model.ReminderStatus

object ReminderData {

    // LIST: contiene los recordatorios simulados
    val reminders: List<Reminder> = listOf(
        Reminder(
            id = 1,
            title = "Entrenamiento de fútbol",
            description = "Entrenamiento de la tarde",
            category = ReminderCategory.Personal,
            priority = ReminderPriority.HIGH,
            status = ReminderStatus.PENDING,
            dueDate = "2026-10-26"
        ),
        Reminder(
            id = 2,
            title = "Estudiar Kotlin",
            description = "Repasar clases y listas",
            category = ReminderCategory.Study,
            priority = ReminderPriority.MEDIUM,
            status = ReminderStatus.PENDING
        ),
        Reminder(
            id = 3,
            title = "Comprar alimentos",
            category = ReminderCategory.Personal,
            priority = ReminderPriority.LOW,
            status = ReminderStatus.COMPLETED
        ),
        Reminder(
            id = 4,
            title = "Revisar proyecto",
            description = "Comprobar el código de la aplicación",
            category = ReminderCategory.Work,
            priority = ReminderPriority.HIGH,
            status = ReminderStatus.PENDING
        ),
        Reminder(
            id = 5,
            title = "Descanso y recuperación",
            category = ReminderCategory.Health,
            priority = ReminderPriority.MEDIUM,
            status = ReminderStatus.CANCELLED
        )
    )

    // SET: evita duplicar categorías
    val categories: Set<ReminderCategory> =
        reminders.map { it.category }.toSet()

    // MAP: relaciona cada categoría con su etiqueta y color
    val categoryInfo: Map<ReminderCategory, Pair<String, Long>> =
        categories.associateWith { category ->
            category.label to category.colorHex
        }

    // Filtra recordatorios por estado
    fun byStatus(status: ReminderStatus): List<Reminder> {
        return reminders.filter { it.status == status }
    }

    // Filtra recordatorios por prioridad
    fun byPriority(priority: ReminderPriority): List<Reminder> {
        return reminders.filter { it.priority == priority }
    }
}
