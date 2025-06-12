<template>
  <v-container class="bg-grey-darken-4 text-white" fluid>
    <v-row justify="center" class="mt-10">
      <v-col cols="12" md="8">
        <h1 class="text-center mb-6 text-h4 font-weight-bold">My Todos</h1>

        <v-card class="pa-4 bg-grey-darken-3">
          <v-row>
            <v-col cols="12" sm="5">
              <label>Title:</label>
              <v-text-field v-model="title" placeholder="What's the title of your To Do?" dense></v-text-field>
            </v-col>
            <v-col cols="12" sm="5">
              <label>Description:</label>
              <v-text-field v-model="description" placeholder="What's the description of your To Do?" dense></v-text-field>
            </v-col>
            <v-col cols="12" sm="2" class="d-flex align-end">
              <v-btn color="green" class="text-white" @click="addTodo">Add</v-btn>
            </v-col>
          </v-row>

          <v-divider class="my-4"></v-divider>

          <v-btn-toggle v-model="tab" dense mandatory>
            <v-btn value="todo" color="green">To Do</v-btn>
            <v-btn value="completed" color="grey">Completed</v-btn>
          </v-btn-toggle>

          <v-divider class="my-4"></v-divider>

          <v-card
            v-for="(todo, index) in filteredTodos"
            :key="index"
            class="my-3 pa-3 d-flex justify-space-between align-center"
            elevation="2"
            color="grey darken-2"
          >
            <div>
              <div class="text-h6 font-weight-bold text-green-accent-3">{{ todo.title }}</div>
              <div class="text-grey-lighten-1">{{ todo.description }}</div>
            </div>
            <div>
              <v-btn icon @click="deleteTodo(index, tab)">
                <v-icon :color="tab === 'todo' ? 'grey-lighten-4' : 'red'">mdi-delete</v-icon>
              </v-btn>
              <v-btn icon @click="toggleComplete(index)">
                <v-icon color="green">mdi-check</v-icon>
              </v-btn>
            </div>
          </v-card>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { ref, computed } from 'vue'

const title = ref('')
const description = ref('')
const tab = ref('todo')

const todos = ref([
  { title: 'Doing Workout', description: 'I have to do push up at 6 PM', completed: false },
  { title: 'Writing diary', description: 'I will write diary at 10 PM', completed: false }
])

const addTodo = () => {
  if (title.value.trim() && description.value.trim()) {
    todos.value.push({
      title: title.value,
      description: description.value,
      completed: false
    })
    title.value = ''
    description.value = ''
  }
}

const toggleComplete = (index) => {
  const list = tab.value === 'todo' ? uncompletedTodos.value : completedTodos.value
  const todo = list[index]
  todo.completed = !todo.completed
}

const deleteTodo = (index, currentTab) => {
  const list = currentTab === 'todo' ? uncompletedTodos : completedTodos
  const item = list.value[index]
  const realIndex = todos.value.findIndex(t => t === item)
  todos.value.splice(realIndex, 1)
}

const uncompletedTodos = computed(() => todos.value.filter(t => !t.completed))
const completedTodos = computed(() => todos.value.filter(t => t.completed))

const filteredTodos = computed(() => (tab.value === 'todo' ? uncompletedTodos.value : completedTodos.value))
</script>

<style scoped>
.text-h6 {
  font-size: 1.25rem;
}
</style>