<template>
  <v-card-text
    ><v-row>
      <v-col cols="10">
        <p class="todo-item-title">
          {{ todo.title }}
        </p>
        <p class="todo-item-description">
          id: {{ todo.id }}; description: {{ todo.description }}
        </p>
        <p class="todo-item-completed-at">
          {{ todo.completedAtText }}
        </p>
      </v-col>
      <v-col cols="2" align-self="center">
        <v-row justify="space-around">
          <v-col cols="1">
            <v-btn icon @click="deleteTodo(todo)">
              <v-icon
                v-if="todo.completedAt == null && !getCompletedItems"
                class="btn-delete"
                >mdi-delete-outline</v-icon
              >
              <v-icon
                v-if="todo.completedAt != null && getCompletedItems"
                class="btn-delete"
                >mdi-delete-outline</v-icon
              >
            </v-btn>
          </v-col>
          <v-col cols="1">
            <v-btn icon @click="completeTodo(todo)">
              <v-icon v-if="todo.completedAt == null" class="btn-check"
                >mdi-check-outline</v-icon
              >
            </v-btn>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
  </v-card-text>
</template>

<script setup>
import { defineProps, computed, defineEmits } from "vue";

const props = defineProps({
  todoItem: {},
  getCompletedItems: Boolean,
});

const emit = defineEmits(["deleteTodoItem", "completeTodoItem"]);

const todo = computed(() => props.todoItem);

const deleteTodo = () => {
  emit("deleteTodoItem", todo.value);
};

const completeTodo = () => {
  if (todo.value.completedAt) return;
  emit("completeTodoItem", todo.value);
};
</script>

<style scoped>
.todo-item-title {
  font-size: 30px;
  font-weight: bold;
  color: #23a669;
}

.todo-item-description {
  margin-top: 5px;
  color: #acacac !important;
}

.todo-item-completed-at {
  color: #acacac !important;
  margin-top: 10px;
  font-style: italic;
}

.btn-check {
  color: #acacac;
  transition-duration: 0.3s;
}

.btn-check:hover {
  color: #23a669;
}

.btn-delete {
  color: #acacac;
  transition-duration: 0.3s;
}

.btn-delete:hover {
  color: #d32f2f;
}
</style>
