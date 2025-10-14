const routes = [
  {
    path: "/login",
    component: () => import("layouts/LoginLayout.vue"),
    children: [
      {
        name: "login",
        path: "",
        component: () => import("pages/authentication/Login.vue"),
        meta: "guest"
      }
      // {
      //   name: "register",
      //   path: "/register",
      //   component: () => import("pages/authentication/Register.vue"),
      //   meta: "guest"
      // }
      // {
      //   name: "recover",
      //   path: "/recover",
      //   component: () => import("pages/PasswordRecovery.vue"),
      //   meta: "guest"
      // }
    ]
  },
  {
    path: "/",
    component: () => import("layouts/MainLayout.vue"),
    children: [
      {
        name: "home",
        path: "home",
        component: () => import("pages/Index.vue")
      },
      {
        path: "profile",
        name: "profile",
        component: () => import("pages/authentication/Profile.vue")
      },
      {
        path: "welcome",
        name: "welcome",
        component: () => import("pages/authentication/Welcome.vue")
      },
      {
        path: "adminView",
        component: () => import("pages/manageCourse/indexAdmin.vue"),
        children: [
          {
            path: "",
            name: "adminView",
            component: () => import("pages/manageCourse/courseAdminView.vue")
          },
          {
            path: "module",
            name: "module",
            component: () => import("pages/manageCourse/moduleView.vue")
          },
          {
            path: "lesson",
            name: "lesson",
            component: () => import("pages/manageCourse/lessonView.vue")
          },
          {
            path: "content",
            name: "content",
            component: () => import("pages/manageCourse/contentView.vue")
          },
          {
            path: "galleryPhoto",
            name: "galleryPhoto",
            component: () => import("pages/gallery/photoGallery.vue")
          },
          {
            path: "galleryVideo",
            name: "galleryVideo",
            component: () => import("pages/gallery/videoGallery.vue")
          }
        ]
      }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "*",
    component: () => import("pages/Error404.vue")
  }
];

export default routes;
