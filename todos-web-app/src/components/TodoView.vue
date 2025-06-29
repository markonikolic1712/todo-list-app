<template>
  <!-- <v-container class="bg-grey-darken-4 text-white" fluid> -->
  <v-container>
    <v-row justify="center" class="mt-10">
      <v-col cols="12" xl="6" lg="6" md="8" sm="10">
        <h1 class="text-center mb-6 text-h4 font-weight-bold">My Todos</h1>
        <v-card color="primary" class="pa-3">
          <TodoForm @addTodoItem="createTodoItem" />
          <v-divider></v-divider>
          <TodoList
            @deleteTodoItem="deleteTodo"
            @completeTodoItem="completeTodo"
          />
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import TodoForm from "./TodoForm.vue";
import TodoList from "./TodoList.vue";
import { onMounted, ref } from "vue";
import { useStore } from "vuex";

const store = useStore();
const title = ref("");
const description = ref("");
const createTodoItem = (todo) => {
  store.dispatch("addTodoItem", todo);
};

const deleteTodo = (todo) => {
  // const index = todoListAll.value.findIndex((i) => i.id === todo.id);
  // if (index >= 0) todoListAll.value.splice(index, 1);
  console.log("TodoView.vue => deleteTodo(): ", todo);
  store.dispatch("deleteTodoItem", todo);
};

const completeTodo = (todo) => {
  // const index = todoListAll.value.findIndex((i) => i.id === todo.id);
  // if (index >= 0) todoListAll.value.splice(index, 1);
  console.log("TodoView.vue => completeTodo(): ", todo);
  store.dispatch("completeTodoItem", todo);
};

onMounted(() => {
  title.value = "Title - start";
  description.value = "Description - start";
});
</script>

<style scoped>
.btn-add {
  margin-top: 2px;
  min-height: 56px;
  color: white !important;
}
</style>
