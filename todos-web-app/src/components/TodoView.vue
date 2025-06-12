<template>
  <!-- <v-container class="bg-grey-darken-4 text-white" fluid> -->
  <v-container fluid>
    <v-row justify="center" class="mt-10">
      <v-col cols="12" xl="6" lg="6" md="8" sm="10">
        <h1 class="text-center mb-6 text-h4 font-weight-bold">My Todos</h1>
        <v-card color="secondary" class="pa-3">
          <!-- <v-form> -->
            <v-row align-content="space-around" class="pt-2 px-1">
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
                <v-btn value="add" color="success" class="btn-add" @click="add">Add</v-btn>
              </v-col>
            </v-row>
          <!-- </v-form> -->
          <v-divider></v-divider>
          <v-row class="mt-4 mb-1 pl-4">
            <v-btn color="success">To Do</v-btn>
            <v-btn>Completed</v-btn>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup>
import { onMounted, ref, computed } from "vue";

const title = ref("");
const description = ref("");

const add = () => {
  console.log('title.value: ', title.value);
  console.log('description.value: ', description.value);
}

onMounted(() => {
  title.value = 'Title - start';
  description.value = 'Description - start';
  cl
});
</script>

<style scoped>
.btn-add {
  margin-top: 2px;
  min-height: 56px;
  color: white !important;
}
</style>
