<template>
  <v-row class="mt-4 mb-1 px-1" justify="start">
    <v-col cols="12" class="btn-row">
      <v-btn
        class="btn-row-btn"
        :color="getCompletedItems ? 'todoItem' : 'success'"
        @click="showTodoList"
        >To Do</v-btn
      >
      <v-btn
        class="mx-2"
        :color="getCompletedItems ? 'success' : 'todoItem'"
        @click="showCompletedList"
        >Completed</v-btn
      >
    </v-col>

    <v-col cols="12" class="item-row">
      <v-card
        v-for="todo in todoList"
        :key="todo.id"
        color="todoItem"
        class="mb-2"
      >
        <TodoItem
          :todoItem="todo"
          :getCompletedItems="getCompletedItems"
          :key="todo.id"
          @deleteTodoItem="deleteTodo"
          @completeTodoItem="completeTodo"
        />
      </v-card>
    </v-col>
  </v-row>
</template>

<script setup>
import { ref, computed, onMounted, defineEmits } from "vue";
import TodoItem from "./TodoItem.vue";
import { useStore } from "vuex";

const emit = defineEmits(["deleteTodoItem", "completeTodoItem"]);
const store = useStore();
const getCompletedItems = ref(false);
const todoListAll = computed(() => {
  console.log("TodoList.vue =>  todoListAll.computed()");
  return store.getters.todoList;
});

const todoList = computed(() => {
  // ovde se filtriraju elementi cele liste
  // ako trebaju da se prikazu itemi koji su completed onda se uzimaju oni itemi koji imaju podatak u completedAt
  if (getCompletedItems.value) {
    return todoListAll.value.filter((item) => item.completedAt != null);
  } else {
    return todoListAll.value.filter((item) => item.completedAt == null);
  }
});

const showTodoList = () => {
  getCompletedItems.value = false;
  store.dispatch("changeAddBtnState", false);
  store.dispatch("setTodoList");
};

const showCompletedList = () => {
  getCompletedItems.value = true;
  store.dispatch("changeAddBtnState", true);
  store.dispatch("setTodoList");
};

const deleteTodo = (todo) => {
  emit("deleteTodoItem", todo);
  store.dispatch("setTodoList");
};

const completeTodo = (todo) => {
  emit("completeTodoItem", todo);
  store.dispatch("setTodoList");
};

onMounted(() => {});
</script>

<style scoped>
.btn-row {
  padding-bottom: 0px;
}

.btn-row-btn {
  color: white !important;
}
</style>
