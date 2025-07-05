<template>
  <v-form ref="todoCreateForm">
    <v-row justify="space-around" class="pt-2">
      <v-col cols="5">
        <label class="font-weight-bold">Title:</label>
        <v-text-field
          bg-color="info"
          v-model="title"
          placeholder="What's the title of your To Do?"
        ></v-text-field>
      </v-col>
      <v-col cols="5">
        <label class="font-weight-bold">Description:</label>
        <v-text-field
          bg-color="info"
          v-model="description"
          placeholder="What's the description of your To Do?"
        ></v-text-field>
      </v-col>
      <v-col cols="2" align-self="center">
        <v-row justify="center" class="pr-3">
          <v-btn
            value="add"
            color="success"
            class="btn-add"
            @click="createTodo"
            :disabled="addBtnState"
            >Add</v-btn
          >
        </v-row>
      </v-col>
    </v-row>
  </v-form>
</template>

<script setup>
import { onMounted, ref, defineEmits, computed } from "vue";
import { useStore } from "vuex";

const store = useStore();
const title = ref("");
const description = ref("");
const todoCreateForm = ref();

const emit = defineEmits(["addTodoItem"]);
const addBtnState = computed(() => store.getters.addBtnState);

const createTodo = () => {
  // let id = 0;
  // store.state.todoList.forEach(item => {
  //   if(item.id > id) id = item.id;
  // })

  const todo = {
    //id: null,
    title: title.value,
    description: description.value,
    createdAt: new Date(),
    completedAt: null,
    deletedAt: null,
    modifiedAt: null,
  };
  emit("addTodoItem", todo);
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
