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
    primary: "#3A4257", //"002939", //"#3A4257",
    secondary: "#F0DDBC", //"#E4CFA9", //"#F0DDBC"
    navbar: "#556180",
  },
};

const vuetify = createVuetify({
  components: {
    ...components,
    // VDataTable,
    // VDataTableServer,
  },
  directives,
  theme: {
    defaultTheme: "taxAppTheme",
    themes: {
      taxAppTheme,
    },
  },
  defaults: {
    // VDataTable: {
    //   fixedHeader: true,
    //   noDataText: "Result not found",
    // },
    // VTextField: {
    //   hideDetails: true,
    //   density: "compact",
    // },
    // VCombobox: {
    //   hideDetails: true,
    //   density: "compact",
    // },
    // VCheckbox: {
    //   hideDetails: true,
    //   density: "compact",
    // },
    // VSelect: {
    //   hideDetails: true,
    //   density: "compact",
    // },
  },
});

createApp(App)
    .use(store)
    .use(vuetify)
    .use(router)
    .mount("#app");
