package com.khd.todo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(private val todoService: TodoService) {

    @GetMapping
    fun getAllTodos() = todoService.getAllTodos()

    @PostMapping
    fun createTodo(@RequestBody todo: Todo) = todoService.createTodo(todo)

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long) = todoService.getTodoById(id)

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long,
                   @RequestBody updatedTodo: Todo): Todo {
        val currentTodo = todoService.getTodoById(id)
        currentTodo.title = updatedTodo.title
        currentTodo.completed = updatedTodo.completed
        return todoService.updateTodo(id, currentTodo)
    }


    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long) = todoService.deleteTodo(id)
}
