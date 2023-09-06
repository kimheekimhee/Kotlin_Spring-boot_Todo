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
                   @RequestBody updatedTodo: Todo) = todoService.updateTodo(id, updatedTodo)

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long) = todoService.deleteTodo(id)
}
