import { createStore } from "vuex";
import {
  getAllTodo,
  createTodo,
  completeTodo,
  deleteTodo,
} from "@/api/todoListService.js";

export default createStore({
  state: {
    todoList: [],
    addBtnState: false,
  },
  getters: {
    todoList: (state) => state.todoList,
    addBtnState: (state) => state.addBtnState,
  },
  mutations: {
    setTodoList(state, payload) {
      state.todoList = payload;
    },
    addTodoItem(state, payload) {
      state.todoList.push(payload);
    },
    deleteTodoItem(state, payload) {
      // const index = state.todoList.findIndex((i) => i.id === payload.id);
      // if (index >= 0) state.todoList.splice(index, 1);
      state.todoList = state.todoList.filter(item => item.id != payload.id);
    },
    completeTodoItem(state, payload) {
      const index = state.todoList.findIndex((i) => i.id === payload.id);
      if (index >= 0) {
        state.todoList[index].completedAt = payload.completedAt;
      }
    },
    changeAddBtnState(state, payload) {
      state.addBtnState = payload;
      console.log("state.addBtnState: ", state.addBtnState);
    },
  },
  actions: {
    // async setTodoList(ctx, todoList) {
    //   const data = await getAllTodo();
    //   ctx.commit("setTodoList", todoList);
    // },
    async setTodoList(ctx) {
      const data = await getAllTodo();
      data.forEach((item) => {
        if (item.completedAt) {
          const dateCompleted = new Date(item.completedAt)
            .toLocaleString("fr-CH")
            .split(" ")[0];
          const timeCompleted = new Date(item.completedAt)
            .toLocaleString("fr-CH")
            .split(" ")[1];
          item.completedAtText =
            "Completed: " + dateCompleted + " at " + timeCompleted;
        }
      });
      ctx.commit("setTodoList", data);
    },
    async addTodoItem(ctx, todoItem) {
      // salje se POST request na backend
      const response = await createTodo(todoItem);
      ctx.commit("addTodoItem", response);
    },
    async deleteTodoItem(ctx, todoItem) {
      // salje se PUT request na backend
      // kada korisnik klikne na delete za neki todo taj todo se ne brise iz baze nego mu se u bazi samo radi update kolone delete na true. Ovaj red ostaje u bazi ali ima flag da je delete
      const data = await deleteTodo(todoItem);
      console.log("deleteTodoItem: ", data);
      ctx.commit("deleteTodoItem", data);
    },
    async completeTodoItem(ctx, todoItem) {
      // salje se PUT request na backend
      const data = await completeTodo(todoItem);
      console.log("completeTodoItem: ", data);
      ctx.commit("completeTodoItem", data);
    },
    changeAddBtnState(ctx, payload) {
      ctx.commit("changeAddBtnState", payload);
    },
  },
  modules: {},
});
