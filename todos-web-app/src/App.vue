<template>
  <v-app>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>
    </nav>
    <router-view />
  </v-app>
</template>

<script setup>
import { onMounted, ref } from "vue";
import { useStore } from "vuex";

const store = useStore();

onMounted(() => {
  // const strCompleted = new Date().toLocaleString("fr-CH");
  // const dateCompleted = strCompleted.split(" ")[0];
  // const timeCompleted = strCompleted.split(" ")[1];
  // const todo1 = {
  //   id: 1,
  //   title: "Todo 1",
  //   description: "Todo 1 description",
  //   completedAt: null,
  // };
  // const todo2 = {
  //   id: 2,
  //   title: "Todo 2",
  //   description: "Todo 2 description",
  //   completedAt: "Completed: " + dateCompleted + " at " + timeCompleted,
  // };
  // const todo3 = {
  //   id: 3,
  //   title: "Todo 3",
  //   description: "Todo 3 description",
  //   completedAt: "Completed: " + dateCompleted + " at " + timeCompleted,
  // };
  // const todo4 = {
  //   id: 4,
  //   title: "Todo 4",
  //   description: "Todo 4 description",
  //   completedAt: null,
  // };
  // const todoListAll = ref([todo1, todo2, todo3, todo4]);

  // store.dispatch('setTodoList', todoListAll);

    store.dispatch('setTodoList');
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
}

nav {
  padding: 20px;
  background-color: #424242;
}

nav a {
  font-weight: bold;
  color: #acacac;
  text-decoration: none;
}

nav a.router-link-exact-active {
  color: #ffffff;
  text-decoration: underline;
}
</style>
