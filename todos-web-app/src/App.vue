<template>
  <v-app >
      <nav>
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link>
      </nav>
      <router-view />
  </v-app>
</template>

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
