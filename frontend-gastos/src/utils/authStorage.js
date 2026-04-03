import Cookies from "js-cookie";

const TOKEN_KEY = "auth_token";

export const authStorage = {
  setToken: (token) => {
    Cookies.set(TOKEN_KEY, token, {
      expires: 1,
      secure: true,
      sameSite: "strict",
    });
  },

  getToken: () => {
    return Cookies.get(TOKEN_KEY);
  },

  removeToken: () => {
    Cookies.remove(TOKEN_KEY);
  },

  isAuthenticated: () => {
    return !!Cookies.get(TOKEN_KEY);
  },
};
