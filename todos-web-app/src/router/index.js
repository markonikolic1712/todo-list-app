import { createRouter, createWebHistory } from "vue-router";
import TodoView from "../components/TodoView.vue";

const routes = [
  {
    path: "/",
    name: "todo",
    component: TodoView,
  },
  {
    path: "/table",
    name: "table",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../components/TodoTable.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
