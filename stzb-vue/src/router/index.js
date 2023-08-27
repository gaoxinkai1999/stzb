import { createRouter, createWebHashHistory } from "vue-router";
// import MyHome from "@/components/MyHome";
// import MyTeam from "@/components/MyTeam";
// import MyFight from "@/components/MyFight";

const routes = [
    {
        path: "/",
        name: "/",
        component: () => import("../components/MyHome")
    },
    {
        path: "/MyHome",
        name: "MyHome",
        component: () => import("../components/MyHome")
    },
    {
        path: "/MyTeam",
        name: "MyTeam",
        component: () => import("../components/MyTeam")
    },
    {
        path: "/MyTools",
        name: "MyTools",
        component: () => import("../components/MyTools")
    },
    {
        path: "/MyFight",
        name: "MyFight",
        component: () => import("../components/MyFight")
    },
];

const router = createRouter({
    history: createWebHashHistory(), //
    routes,
});

export default router;
