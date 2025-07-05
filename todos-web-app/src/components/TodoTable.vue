<template>
  <v-container>
    <v-row class="pa-3">
      <v-col cols="6">
        <v-row>
          <v-col cols="5">
            <v-row justify="space-around" class="pl-2">
              <v-text-field
                label="Search by title"
                v-model="searchByTitle"
                @input="search"
              ></v-text-field>
            </v-row>
          </v-col>
          <v-col cols="5">
            <v-row justify="space-around" class="pl-2">
              <v-text-field
                label="Search by description"
                v-model="searchByDescription"
                @input="search"
              ></v-text-field>
            </v-row>
          </v-col>
        </v-row>
      </v-col>
      <v-col cols="4">
        <v-row>
          <v-col>
            <v-row>
              <v-checkbox
                label="Show just completed"
                v-model="completed"
                @change="searchCompleted"
              />
            </v-row>
          </v-col>
        </v-row>
      </v-col>
    </v-row>
    <v-table theme="dark">
      <thead>
        <tr>
          <th class="text-left">Id</th>
          <th class="text-left">Title</th>
          <th>Description</th>
          <th>Completed at</th>
          <th>Created at</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in itemList" :key="item.id">
          <td>{{ item.id }}</td>
          <td>{{ item.title }}</td>
          <td>{{ item.description }}</td>
          <!-- <td>{{ item.completedAt }}</td> -->
          <!-- <td>
            {{
              new Date(item.completedAt)
                .toLocaleString("fr-CH")
                .split(" ")[0] == "01.01.1970"
                ? "/"
                : new Date(item.completedAt)
                    .toLocaleString("fr-CH")
                    .split(" ")[0] +
                  ". " +
                  new Date(item.completedAt)
                    .toLocaleString("fr-CH")
                    .split(" ")[1]
            }}
          </td> -->
          <td>{{ item.completedAtText }}</td>
          <!-- <td>{{ item.createdAt }}</td> -->
          <td>
            {{
              new Date(item.createdAt).toLocaleString("fr-CH").split(" ")[0] +
              ". " +
              new Date(item.createdAt).toLocaleString("fr-CH").split(" ")[1]
            }}
          </td>
        </tr>
      </tbody>
    </v-table>
    <!-- <v-data-table
      :items="itemList"
      :headers="[
        { title: 'Id', align: 'start', sortable: true, key: 'id' },
        { title: 'Title', align: 'start', sortable: true, key: 'title' },
        {
          title: 'Description',
          align: 'start',
          sortable: true,
          key: 'description',
        },
        {
          title: 'Completed at',
          align: 'start',
          sortable: true,
          key: 'completedAt',
        },
        {
          title: 'Created at',
          align: 'start',
          sortable: true,
          key: 'createdAt',
        },
      ]"
    >
    </v-data-table> -->
  </v-container>
</template>

<script setup>
import { computed, onMounted, ref, watch } from "vue";
import { useStore } from "vuex";

const store = useStore();
//const allItems = computed(() => store.getters.todoList);
const itemList = ref([]);
const searchByTitle = ref("");
const searchByDescription = ref("");
const completed = ref(false);

const search = () => {
  itemList.value = store.getters.todoList.filter(
    (item) =>
      item.title.toLowerCase().includes(searchByTitle.value.toLowerCase()) &&
      item.title.toLowerCase().includes(searchByDescription.value.toLowerCase())
  );
};

const searchCompleted = () => {
  if (completed.value) {
    itemList.value = itemList.value.filter((item) => item.completedAt != null);
  } else {
    itemList.value = store.getters.todoList.filter(
      (item) =>
        item.title.toLowerCase().includes(searchByTitle.value.toLowerCase()) &&
        item.title
          .toLowerCase()
          .includes(searchByDescription.value.toLowerCase())
    );
  }
};

// watch(completed, () => {
//   }
// );

onMounted(() => {
  store.dispatch("setTodoList");
  itemList.value = store.getters.todoList;
});
</script>
