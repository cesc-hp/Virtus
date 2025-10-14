const routes = [
  {
    path: "/",
    redirect: "/home"
  },
  {
    path: "/login",
    component: () => import("layouts/LoginLayout.vue"),
    children: [
      {
        name: "login",
        path: "",
        component: () => import("pages/authentication/Login.vue"),
        meta: "guest"
      },
      {
        name: "register",
        path: "/register",
        component: () => import("pages/authentication/Register.vue"),
        meta: "guest"
      }
      // {
      //   name: "recover",
      //   path: "/recover",
      //   component: () => import("pages/PasswordRecovery.vue"),
      //   meta: "guest"
      // }
    ]
  },
  {
    path: "/home",
    component: () => import("layouts/MainLayout.vue"),
    children: [
      {
        name: "home",
        path: "",
        component: () => import("pages/Index.vue"),
        meta: "auth"
      },
      {
        name: "profile",
        path: "profile",
        component: () => import("pages/authentication/Profile.vue"),
        meta: "auth"
      },
      {
        name: "welcome",
        path: "welcome",
        component: () => import("pages/authentication/Welcome.vue"),
        meta: "auth"
      },
      {
        path: "course",
        component: () => import("pages/manageCourse/indexCourse.vue"),
        children: [
          {
            name: "course",
            path: "",
            component: () => import("pages/manageCourse/courseAdminView.vue"),
            meta: "auth"
          },
          {
            path: ":idCourse/module",
            component: () => import("pages/manageCourse/indexCourse.vue"),
            children: [
              {
                name: "module",
                path: "",
                component: () => import("pages/manageCourse/moduleView.vue"),
                meta: "auth"
              },
              {
                path: ":idModule/lesson",
                component: () => import("pages/manageCourse/indexCourse.vue"),
                children: [
                  {
                    name: "lesson",
                    path: "",
                    component: () =>
                      import("pages/manageCourse/lessonView.vue"),
                    meta: "auth"
                  },
                  {
                    path: ":idLesson/content",
                    component: () =>
                      import("pages/manageCourse/indexCourse.vue"),
                    children: [
                      {
                        name: "content",
                        path: "",
                        component: () =>
                          import("pages/manageCourse/contentView.vue"),
                        meta: "auth"
                      }
                    ]
                  }
                ]
              }
            ]
          }
        ]
      },
      {
        name: "galleryPhoto",
        path: "galleryPhoto",
        component: () => import("pages/gallery/photoGallery.vue"),
        meta: "auth"
      },
      {
        name: "galleryVideo",
        path: "galleryVideo",
        component: () => import("pages/gallery/videoGallery.vue"),
        meta: "auth"
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
