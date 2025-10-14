import {_axios} from "boot/axios"

export const login = ({ commit, dispatch }, form) => {
  _axios
    .post("api/auth/signup", {
      username: form.username,
      email: form.email,
      password: form.password,
      role: ["admin"],
    })
    .then((res) => {
      if (res.data.accessToken) {
        console.log(res.data.accessToken);
        commit("login", res.data.username);
      }
    })
    .catch((err) => {
      alert(Object.values(error.response.data));
      console.log(err);
    });
};

export const increment = ({ commit }) => {
  commit('increment');
};

export const logins = ({ commit }, form) => {
  commit("login", form);
};
