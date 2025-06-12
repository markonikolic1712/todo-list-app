import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import "vuetify/styles";
import { createVuetify } from "vuetify";
import * as components from "vuetify/components";
//import { VDataTable, VDataTableServer } from "vuetify/labs/VDataTable";

import * as directives from "vuetify/directives";
import "@mdi/font/css/materialdesignicons.css";

const taxAppTheme = {
  colors: {
    background: "#212121", // ono sto se setuje u background to ce bito background-color za App
    primary: "#424242", // tamno siva
    secondary: "#616161", // svetlija siva
    accent: "#c4c2c2", // svetlo siva
    success: "#00C853", // zelena
    error: "#d32f2f", // crvena
    info: "#f5f5f5", // prljavo bela
    warning: "#FFC107", // zuta
  },
};

const vuetify = createVuetify({
  components: {
    ...components,
  },
  directives,
  theme: {
    defaultTheme: "taxAppTheme",
    themes: {
      taxAppTheme,
    },
  },
});

createApp(App).use(store).use(vuetify).use(router).mount("#app");
