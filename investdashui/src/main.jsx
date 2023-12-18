import React from "react";
import ReactDOM from "react-dom/client";
// import App from "./App.jsx";
import { SignUp } from "./pages/SignUp/index.jsx";
import "./styles.scss";

import i18n from "i18next";
import { initReactI18next } from "react-i18next";

i18n
  .use(initReactI18next) // passes i18n down to react-i18next
  .init({
    resources: {
      en: {
        translation: {
          signUp: "Sign Up",
          username: "Username",
          email: "E-mail",
          password: "Password",
          passwordRepeat: "Password Repeat",
          passwordMismatch: "Password Missmatch",
          genericError: "Unexpected error occured.Please try again",
        },
      },
      tr: {
        translation: {
          signUp: "Kayit Ol",
          username: "Kullanici Adi",
          email: "E-posta",
          password: "Sifre",
          passwordRepeat: "Sifre Tekrar",
          passwordMismatch: "Sifreniz Eslesmiyor",
          genericError: "Beklenmedik bir hata olustu, lutfen tekrar deneyin",
        },
      },
    },
    fallbackLng: "tr",

    interpolation: {
      escapeValue: false,
    },
  });

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <SignUp />
  </React.StrictMode>
);
