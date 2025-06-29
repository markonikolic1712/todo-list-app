<template>
  <v-container>
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
import { computed, onMounted } from "vue";
import { useStore } from "vuex";

const store = useStore();
const itemList = computed(() => store.getters.todoList);

onMounted(() => {
  store.dispatch("setTodoList");
});
</script>
