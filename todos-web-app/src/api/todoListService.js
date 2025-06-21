import api from "./axiosconfig";

async function getAllTodo() {
  const response = await api.GET("/all");
  console.log(response);
  return response;
}

async function createTodo(todo) {
  const response = await api.POST("/create", todo);
  return response;
}

async function completeTodo(todo) {
  const response = await api.PUT(`/complete/${todo.id}`, todo);
  return response;
}

// kada korisnik klikne na delete dugme da izbrise neki todo taj red se ne brise iz baze nego se samo upisuje datetime u deletedAt
// podatak o trenutku brisanja se upisuje u todo objekat na backendu
async function deleteTodo(todo) {
  const response = await api.PUT(`/delete/${todo.id}`, todo);
  return response;
}

export { getAllTodo, createTodo, completeTodo, deleteTodo };
