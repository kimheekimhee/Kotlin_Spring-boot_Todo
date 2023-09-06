package com.khd.todo

import org.springframework.stereotype.Service

@Service
class TodoService(private val todoRepository: TodoRepository) {

    fun getAllTodos(): List<Todo> = todoRepository.findAll()

    fun createTodo(todo: Todo) = todoRepository.save(todo)

    fun getTodoById(id: Long): Todo = todoRepository.findById(id).orElseThrow { Exception("Todo not found") }

    fun updateTodo(id: Long, updatedTodo: Todo): Todo {
        val todo: Todo = todoRepository.findById(id).orElseThrow { Exception("Todo not found") }
        todo.title = updatedTodo.title
        todo.completed = updatedTodo.completed
        return todoRepository.save(todo)
    }

    fun deleteTodo(id: Long) = todoRepository.deleteById(id)
}
